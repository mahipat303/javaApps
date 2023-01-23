package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.FIR;
import com.masai.service.FIRService;

@RestController
public class FIRController {

	@Autowired
	private FIRService fService;

	@PostMapping("/masaifir/user/fir/{key}")
	public ResponseEntity<FIR> fileAnFIRHandler(@PathVariable("key") String key, @Valid @RequestBody FIR fir) {

		FIR rFir = fService.fileAnFIR(fir, key);

		return new ResponseEntity<FIR>(rFir, HttpStatus.CREATED);

	}

}
