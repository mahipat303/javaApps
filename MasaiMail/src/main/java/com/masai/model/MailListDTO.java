package com.masai.model;

import java.util.List;

public class MailListDTO {

	private List<String> mails;

	public MailListDTO(List<String> mails) {
		super();
		this.mails = mails;
	}

	public List<String> getMails() {
		return mails;
	}

	public void setMails(List<String> mails) {
		this.mails = mails;
	}

}
