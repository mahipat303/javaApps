package com.masai.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
//import com.masai.model.FIR;
import com.masai.model.LoginDTO;
import com.masai.model.Mail;
import com.masai.model.User;

@Service
public interface UserService {

	public User registerUser(User user) throws UserException;

	public CurrentUserSession userLogin(LoginDTO dto) throws UserException;

	public List<Mail> checkAllMail(String key) throws UserException, MailException;

	public List<Mail> checkAllStaredMail(String key) throws UserException, MailException;

	public String updateUser(String key, User user) throws UserException;


}
