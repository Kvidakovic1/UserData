package data;

import java.util.Scanner;

import data.controller.UserAdresses;
import data.controller.Users;

public class Start {
	
	private Users users;
	private UserAdresses useradresses;
		
	
	public Start() {
		
		MetodeUnosa.ulaz = new Scanner(System.in);
		users = new Users(this);
		useradresses = new UserAdresses(this);
		glavniIzbornik();
		
	}

	public void glavniIzbornik() {
		System.out.println("");
		System.out.println("**GLAVNI IZBORNIK**");
		System.out.println("Dostupne opcije");
		System.out.println("1. User");
		System.out.println("2. User_adress");
		System.out.println("3. Izlaz iz programa");
		odabirGlavnogIzbornika();
		
	}

	private void odabirGlavnogIzbornika() {
		switch(MetodeUnosa.unosBrojRaspon("Odaberite opciju: ", 1, 3)) {
		case 1:
			users.izbornik();
			break;
		case 2:
			useradresses.izbornik();
			break;
		case 3:
			System.out.println("Izlaz iz programa!");
		}
		
	}
	
	
	public static void main(String[] args) {
		new Start();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UserAdresses getUseradresses() {
		return useradresses;
	}

	public void setUseradresses(UserAdresses useradresses) {
		this.useradresses = useradresses;
	}
	
	
}
