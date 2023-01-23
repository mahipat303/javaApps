package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;

@Service
public interface FIRService {

	public FIR fileAnFIR(FIR fir, String uID) throws FIRException, UserException;

}
