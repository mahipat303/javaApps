package com.masai.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.FIR;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.FIRRepo;
import com.masai.repository.UserRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uro;

	@Autowired
	private FIRRepo fro;

	@Autowired
	private CurrentUserSessionRepo cro;

	@Override
	public User registerUser(User user) throws UserException, ValidationException {

		User u = uro.findByMobileNumber(user.getMobileNumber());

		if (u != null) {
			throw new UserException("User is already registerd...");
		}

		return uro.save(user);

	}

	@Override
	public CurrentUserSession userLogin(LoginDTO dto) throws UserException {

		User existingUser = uro.findByMobileNumber(dto.getMobile());

		if (existingUser == null) {
			throw new UserException("User not exist with this mobile no. plz create Account");
		}

		Optional<CurrentUserSession> validSession = Optional
				.ofNullable(cro.findByMobile(existingUser.getMobileNumber()));

		if (validSession.isPresent()) {
			throw new UserException("User already logged in with this Number");

		}

		if (existingUser.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(8);

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getMobileNumber(), key,
					LocalDateTime.now());

			return cro.save(currentUserSession);

		} else {

			throw new UserException("Please enter valid password");
		}

	}

	@Override
	public List<FIR> getAllFIR(String id) throws UserException, FIRException {

		CurrentUserSession cus = cro.findByUuid(id);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		User user = uro.findByMobileNumber(cus.getMobile());

		List<FIR> FIRList = user.getFirList();

		if (FIRList.isEmpty()) {
			throw new FIRException("No FIR filled by this user till now...");
		}

		return FIRList;

	}

	@Override
	public String withdrawFir(String Uid, Integer fId) throws UserException, FIRException {

		CurrentUserSession cus = cro.findByUuid(Uid);

		if (cus == null) {
			throw new UserException("enter valid key");
		}

		User user = uro.findByMobileNumber(cus.getMobile());

		List<FIR> FIRList = user.getFirList();

		if (FIRList.isEmpty()) {
			throw new FIRException("No FIR filled by this user till now...");
		}

		Optional<FIR> fir = fro.findById(fId);

		if (!fir.isPresent()) {
			throw new FIRException("no fir available with this id...");

		}

		FIR f = fir.get();

		long noOfHours = f.getTimeStamp().until(LocalDateTime.now(), ChronoUnit.HOURS);

		if (noOfHours > 24) {
			throw new FIRException("can't withdraw Fir after 24 Hours...");
		}

		fro.deleteById(fId);

		uro.save(user);

		return "deleted successfuly...";
	}

}
