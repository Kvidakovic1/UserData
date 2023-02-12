package data.model;

import java.util.ArrayList;
import java.util.List;

public class UserAdress extends Entitet {

	private String city;
	private String street;
	private String number;
	private List<User> users;

	public UserAdress() {
		super();
		users = new ArrayList<>();
	}

	public UserAdress(int id, String city, String street, String number, List<User> users) {
		super(id);
		this.city = city;
		this.street = street;
		this.number = number;
		this.users = users;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		
		if((getUsers() == null)) {
			return getCity() + ", " + getStreet() + ", " + getNumber();
		}
		return getCity() + ", " + getStreet() + ", " + getNumber() + ", "  + getUsers().toString();
	}

}
