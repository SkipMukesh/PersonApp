package com.project.work.getset;

public class Person {

	private int psnId;
	private String psnName;
	private int psnAge;
	private String psnMail;

	public Person() {
	}

	public Person(int psnId, String psnName, int psnAge, String psnMail) {
		super();
		this.psnId = psnId;
		this.psnName = psnName;
		this.psnAge = psnAge;
		this.psnMail = psnMail;
	}

	public int getPsnId() {
		return psnId;
	}

	public void setPsnId(int psnId) {
		this.psnId = psnId;
	}

	public String getPsnName() {
		return psnName;
	}

	public void setPsnName(String psnName) {
		this.psnName = psnName;
	}

	public int getPsnAge() {
		return psnAge;
	}

	public void setPsnAge(int psnAge) {
		this.psnAge = psnAge;
	}

	public String getPsnMail() {
		return psnMail;
	}

	public void setPsnMail(String psnMail) {
		this.psnMail = psnMail;
	}

}
