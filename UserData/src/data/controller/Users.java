package data.controller;

import java.util.ArrayList;
import java.util.List;

import data.MetodeUnosa;
import data.Start;
import data.model.User;

public class Users {

	private List<User> users;
	private Start start;

	public Users(Start start) {
		super();
		this.start = start;
		users = new ArrayList<>();
		testData();
	}

	public Users(List<User> users, Start start) {
		super();
		this.users = users;
		this.start = start;
		testData();
	}

	private void testData() {
		users.add(new User(1, "George", "Foley", "GFoley@gmail.com", "Gfoley", "12345"));
		users.add(new User(1, "Leona", "Marc", "Lmarc@gmail.com", "Lmarc", "54321"));

	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*User izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Registriraj novog usera");
		System.out.println("2. Prikazi podatke usera");
		System.out.println("3. Promjena postojećeg usera");
		System.out.println("4. Pretraga odredenog usera");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (MetodeUnosa.unosBrojRaspon("Odaberi opciju: ", 1, 5)) {
		case 1:
			unosNovog();
			break;
		case 2:
			pregled(true);
			break;
		case 3:
			if (users.size() == 0) {
				System.out.println("Trenutno nema registriranih usera");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (users.size() == 0) {
				System.out.println("Trenutno nema registriranih usera");
				izbornik();
			} else {
				pretraga();
			}
		case 5:
			start.glavniIzbornik();
			break;
		}

	}

	private void pretraga() {
		int i = 1;

		String s = MetodeUnosa.unosStringa("Unesite podatak za pretragu: ");
		for (User u : users) {
			if (u.getFirstname().toLowerCase().contains(s)) {
				System.out.println(u);
				izbornik();
			} else if ((u.getLastname().toLowerCase().contains(s))) {
				System.out.println(u);
				izbornik();
			} else {
				System.out.println("Nema trazenog usera.");
				izbornik();
			}

		}

	}

	private void promjena() {
		pregled(false);
		int i = MetodeUnosa.unosBrojRaspon("Odaberite usera kojeg zelite promijeniti:  ", 1, users.size());
		User u = users.get(i - 1);
		u.setFirstname(MetodeUnosa.unosStringa("Unesi first name"));
		u.setLastname(MetodeUnosa.unosStringa("Unesi last name"));
		u.setEmail(MetodeUnosa.unosStringa("Unesi email"));
		u.setUsername(MetodeUnosa.unosStringa("Unesi username"));
		u.setPassword(MetodeUnosa.unosStringa("Unesi password"));
		izbornik();

	}

	public void unosNovog() {
		users.add(unesiNovogUsera());
		izbornik();

	}

	public User unesiNovogUsera() {
		User u = new User();
		u.setId(MetodeUnosa.unosBrojRaspon("Unesi id usera", 1, Integer.MAX_VALUE));
		u.setFirstname(MetodeUnosa.unosStringa("Unesi first name"));
		u.setLastname(MetodeUnosa.unosStringa("Unesi last name"));
		u.setEmail(MetodeUnosa.unosStringa("Unesi email"));
		u.setUsername(MetodeUnosa.unosStringa("Unesi username"));
		u.setPassword(MetodeUnosa.unosStringa("Unesi password"));
		return u;
	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Trenutni useri");
		System.out.println("-------------");
		int i = 1;
		for (User u : users) {
			System.out.println(i++ + ". " + u);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
