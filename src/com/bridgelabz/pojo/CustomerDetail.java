package com.bridgelabz.pojo;

public class CustomerDetail {
	private String id,name,email,accountno,city,inputby;

	
	public String getInputby() {
		return inputby;
	}

	public void setInputby(String inputby) {
		this.inputby = inputby;
	}

	@Override
	public String toString() {
		return "HomeDAO [id=" + id + ", name=" + name + ", email=" + email + ", accountno=" + accountno + ", city="
				+ city + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
