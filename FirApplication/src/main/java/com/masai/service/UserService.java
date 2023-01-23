package com.masai.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.FIR;
import com.masai.model.LoginDTO;
import com.masai.model.User;

@Service
public interface UserService {

	public User registerUser(User user) throws UserException, ValidationException;

	public CurrentUserSession userLogin(LoginDTO dto) throws UserException;

	public List<FIR> getAllFIR(String Uid) throws UserException, FIRException;

	public String withdrawFir(String Uid, Integer fId) throws UserException, FIRException;

}
