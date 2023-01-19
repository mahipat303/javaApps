package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Mail;
import com.masai.model.MailListDTO;
import com.masai.service.MailService;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaimail")
public class MailController {

	@Autowired
	private MailService mService;

	@PostMapping("/mail/{key}/{mailid}")
	public ResponseEntity<Mail> sendMailToOneHandler(@PathVariable("key") String key,
			@PathVariable("mailid") String mailId, @Valid @RequestBody Mail mail) {

		Mail maill = mService.sendMailToOne(key, mailId, mail);

		return new ResponseEntity<Mail>(maill, HttpStatus.OK);

	}

	@PostMapping("/mails/{key}/{mailid}")
	public ResponseEntity<Mail> sendMailToManyHandler(@PathVariable("key") String key,
			@RequestBody MailListDTO listOfEmails, @Valid @RequestBody Mail mail) {

		Mail maill = mService.sendMailToMany(key, listOfEmails, mail);

		return new ResponseEntity<Mail>(maill, HttpStatus.OK);

	}

	@PostMapping("/starred/{key}/{id}")
	public ResponseEntity<Mail> starAMailHandler(@PathVariable("key") String key, @PathVariable("id") Integer mailId) {

		Mail maill = mService.starAMail(key, mailId);

		return new ResponseEntity<Mail>(maill, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{key}/{id}")
	public ResponseEntity<String> deleteMailHandler(@PathVariable("key") String key,
			@PathVariable("id") Integer mailId) {

		String message = mService.deleteMail(key, mailId);

		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
}
