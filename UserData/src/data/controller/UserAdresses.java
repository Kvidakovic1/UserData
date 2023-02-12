package data.controller;

import java.util.ArrayList;
import java.util.List;

import data.MetodeUnosa;
import data.Start;
import data.model.User;
import data.model.UserAdress;

public class UserAdresses {
	
	private List<UserAdress> useradresses;
	private Start start;
	private User user;
	
	
	
	
	
	
	public void izbornik() {
		System.out.println("");
		System.out.println("*User Adress izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih adresa");
		System.out.println("2. Unos nove adrese");
		System.out.println("3. Povratak na glavni izbornik");
		odabirIzbornika();
	}
	
	
	
	private void odabirIzbornika() {
		switch(MetodeUnosa.unosBrojRaspon("Odaberite opciju: ", 1, 3)) {
		case 1:
			pregled(true);
			break;
		case 2:	
			unosNove();
			break;
		case 3:
			start.glavniIzbornik();
			break;
		}
		
			
		
	}



	private void unosNove() {
		UserAdress ua = new UserAdress();
		 
		
		ua.setId(MetodeUnosa.unosBrojRaspon("Unesite id adrese: ", 1, Integer.MAX_VALUE));
		ua.setCity(MetodeUnosa.unosStringa("Unesite grad: "));
		ua.setStreet(MetodeUnosa.unosStringa("Unesite ulicu: "));
		ua.setNumber(MetodeUnosa.unosStringa("Unesite kucni broj: "));
		while(true) {
			start.getUsers().pregled(false);
			int i = MetodeUnosa.unosBrojRaspon("Odaberite usera za dodavanje na adresu: ", 1, start.getUsers().getUsers().size());
			ua.getUsers().add(start.getUsers().getUsers().get(i-1));
			if(MetodeUnosa.unosBrojRaspon("0 za kraj dodavanja polaznika", 0, Integer.MAX_VALUE) == 0) {
				break;
			}
		}
		
		useradresses.add(ua);
		izbornik();
		
	}



	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Trenutne adrese ");
		System.out.println("-------------");
		int i = 1;
		for(UserAdress ua : useradresses) {
			System.out.println(i++ + ". " + ua);
		}
		System.out.println("-------------");
		if(prikaziIzbornik) {
			izbornik();
		}
		
	}



	public List<UserAdress> getUserAdresses() {
		return useradresses;
	}
	public void setUserAdresses(List<UserAdress> userAdresses) {
		useradresses = userAdresses;
	}
	
	
	public UserAdresses(List<UserAdress> userAdresses, Start start) {
		super();
		this.useradresses = userAdresses;
		this.start = start;
		testData();
	}
	private void testData() {
		useradresses.add(new UserAdress(1, "Chicago", "Michigan Avenue", "55",null));
		useradresses.add(new UserAdress(2, "Miamai", "Ocean Drive", "198",null));
	}



	public UserAdresses(Start start) {
		super();
		this.start = start;
		useradresses = new ArrayList<>();
		testData();
	}
	
	
	
	
	
}
