package me.victar.zlpkrw.lambda;

import java.time.LocalDate;

public class Person {
	public enum Sex {
		MALE, FEMALE
	}

	String name;
	String emailAddress;
	LocalDate birthday;
	Sex gender;
	
	
	public Person(String name, String emailAddress, LocalDate birthday,
			Sex gender) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.birthday = birthday;
		this.gender = gender;
	}

	public int getAge() {
		return LocalDate.now().getYear() - birthday.getYear();
		//return 42;
	}

	public void printPerson() {
		System.out.println(this);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", emailAddress=" + emailAddress
				+ ", birthday=" + birthday + ", gender=" + gender + "]";
	}
}
