package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.FIRRepo;
import com.masai.repository.UserRepo;

@Service
public class FIRServiceImpl implements FIRService {

	@Autowired
	private UserRepo uro;

	@Autowired
	private FIRRepo fro;

	@Autowired
	private CurrentUserSessionRepo cro;

	@Override
	public FIR fileAnFIR(FIR fir, String uID) throws FIRException, UserException {

		CurrentUserSession cus = cro.findByUuid(uID);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		User user = uro.findByMobileNumber(cus.getMobile());

		user.getFirList().add(fir);

		uro.save(user);

		return fro.save(fir);

	}

}
