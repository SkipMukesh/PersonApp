package com.project.work.getset;

public class Person { 

	private int PsnId;
	private String PsnName;
	private int PsnAge;
	private String PsnMail;

	public Person() { 
	}

	public Person(int PsnId, String PsnName, int PsnAge, String PsnMail) { 
		this.PsnId = PsnId;
		this.PsnName = PsnName;
		this.PsnAge = PsnAge;
		this.PsnMail = PsnMail;
	}

	public int getPsnId() {
		return PsnId;
	}

	public void setPsnId(int psnId) {
		PsnId = psnId;
	}

	public String getPsnName() {
		return PsnName;
	}

	public void setPsnName(String psnName) {
		PsnName = psnName;
	}

	public int getPsnAge() {
		return PsnAge;
	}

	public void setPsnAge(int psnAge) {
		PsnAge = psnAge;
	}

	public String getPsnMail() {
		return PsnMail;
	}

	public void setPsnMail(String psnMail) {
		PsnMail = psnMail;
	}

}
