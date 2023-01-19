package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Mail;
import com.masai.model.MailListDTO;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.MailRepo;
import com.masai.repository.UserRepo;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailRepo mro;

	@Autowired
	private CurrentUserSessionRepo cro;

	@Autowired
	private UserRepo uro;

	@Override
	public Mail sendMailToOne(String key, String mailId, Mail mail) throws MailException, UserException {

		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("login please...");
		}

		Optional<User> oruser = uro.findById(mailId);

		if (oruser.isEmpty())
			throw new UserException("enter valid mail id");

		Optional<User> osuser = uro.findById(cus.getEmail());

		User receiver = oruser.get();

		receiver.getMails().add(mail);

		uro.save(receiver);

		return mail;
	}

	@Override
	public Mail starAMail(String key, Integer id) throws MailException, UserException {
		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("login please...");
		}

		Optional<User> osuser = uro.findById(cus.getEmail());

		User user = osuser.get();

		List<Mail> mails = user.getMails();

		if (mails.isEmpty())
			throw new MailException("no mail available to star...");
		boolean flag = false;
		for (int i = 0; i < mails.size(); i++) {
			if (mails.get(i).getId() == id) {
				flag = true;
				mails.get(i).setStar(true);
			}
		}

		if (flag == false)
			throw new UserException("no mail available with this id...");

		uro.save(user);

		return mro.save(mro.findById(id).get());

	}

	@Override
	public String deleteMail(String key, Integer id) throws MailException, UserException {
		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("login please...");
		}

		Optional<User> osuser = uro.findById(cus.getEmail());

		User user = osuser.get();

		List<Mail> mails = user.getMails();

		if (mails.isEmpty())
			throw new MailException("no mail available to star...");
		boolean flag = false;
		for (int i = 0; i < mails.size(); i++) {
			if (mails.get(i).getId() == id) {
				flag = true;
				mails.remove(i);
			}
		}

		if (flag == false)
			throw new UserException("no mail available with this id...");

		uro.save(user);

		mro.delete(mro.findById(id).get());

		return "deleted successfully....";

	}

	@Override
	public Mail sendMailToMany(String key, MailListDTO mailIds, Mail mail) throws MailException, UserException {

		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("login please...");
		}

		List<String> mails = mailIds.getMails();

		for (int i = 0; i < mails.size(); i++) {

			Optional<User> oruser = uro.findById(mails.get(i));

			if (oruser.isEmpty())
				throw new UserException("enter valid Email id");

			Optional<User> osuser = uro.findById(cus.getEmail());

			User receiver = oruser.get();

			receiver.getMails().add(mail);

			uro.save(receiver);

		}

		return mail;

	}

}
