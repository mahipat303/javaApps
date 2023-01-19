package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.model.MailListDTO;

@Service
public interface MailService {

	public Mail sendMailToOne(String key, String mailId, Mail mail) throws MailException, UserException;
	
	public Mail sendMailToMany(String key, MailListDTO mailIds, Mail mail) throws MailException, UserException;
	
	public Mail starAMail(String key, Integer id) throws MailException, UserException;
	
	public String deleteMail(String key, Integer id) throws MailException, UserException;

}
