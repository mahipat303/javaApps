package com.masai.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
//import com.masai.model.FIR;
import com.masai.model.LoginDTO;
import com.masai.model.Mail;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionRepo;
//import com.masai.repository.FIRRepo;
import com.masai.repository.UserRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uro;

	@Autowired
	private CurrentUserSessionRepo cro;

	@Override
	public User registerUser(User user) throws UserException, ValidationException {

		Optional<User> oUser = uro.findById(user.getEmail());

		if (oUser.isPresent()) {
			throw new UserException("user already registerd in app");
		}

		User u = uro.findByMobileNumber(user.getMobileNumber());

		if (u != null) {
			throw new UserException("User is already registerd...");
		}

		return uro.save(user);

	}

	@Override
	public CurrentUserSession userLogin(LoginDTO dto) throws UserException {

		Optional<User> oUser = uro.findById(dto.getEmail());

		if (!oUser.isPresent()) {
			throw new UserException("User not exist with this email plz create Account");
		}

		User existingUser = oUser.get();

		Optional<CurrentUserSession> validSession = Optional
				.ofNullable(cro.findByEmail(existingUser.getMobileNumber()));

		if (validSession.isPresent()) {
			throw new UserException("User already logged in with this Number");

		}

		if (existingUser.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(8);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getEmail(), key,
					LocalDateTime.now());

			return cro.save(currentUserSession);

		} else {

			throw new UserException("Please enter valid password");
		}

	}

	@Override
	public List<Mail> checkAllMail(String key) throws UserException, MailException {

		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		Optional<User> ouser = uro.findById(cus.getEmail());

		if (!ouser.isPresent())
			throw new UserException("no user present ");

		User user = ouser.get();

		List<Mail> mails = user.getMails();

		if (mails.isEmpty()) {
			throw new MailException("No mails available...");
		}

		return mails;

	}

	@Override
	public List<Mail> checkAllStaredMail(String key) throws UserException, MailException {

		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		Optional<User> ouser = uro.findById(cus.getEmail());

		if (!ouser.isPresent())
			throw new UserException("no user present ");

		User user = ouser.get();

		List<Mail> mails = user.getMails();

		List<Mail> staredMails = new ArrayList<>();

		for (Mail mail : mails) {
			if (mail.isStar()) {
				staredMails.add(mail);
			}
		}

		if (staredMails.isEmpty()) {
			throw new MailException("No stared mails available...");
		}

		return staredMails;

	}

	@Override
	public String updateUser(String key, User user) throws UserException {

		CurrentUserSession cus = cro.findByUuid(key);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		Optional<User> ouser = uro.findById(cus.getEmail());

		if (!ouser.isPresent())
			throw new UserException("no user present ");

		User existingUser = ouser.get();

		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMobileNumber(user.getMobileNumber());
		existingUser.setPassword(user.getPassword());

		uro.save(existingUser);

		return "updated successfully....";

	}


}
