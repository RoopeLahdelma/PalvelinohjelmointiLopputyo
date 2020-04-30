package com.example.PalvelinohjelmointiProjekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.PalvelinohjelmointiProjekti.domain.*;






@SpringBootApplication
public class PalvelinohjelmointiProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalvelinohjelmointiProjektiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner palvelinohjelmointiprojektiDemo(BudjettiRepository brepository,KuukausiRepository krepository, UserRepository urepository) {
		return (args) -> {

			brepository.deleteAll();
			
			//Lisätään kaikki kuukaudet valmiiksi tietokantaan.
			krepository.save(new Kuukausi("Tammikuu", "2020"));
			krepository.save(new Kuukausi("Helmikuu", "2020"));
			krepository.save(new Kuukausi("Maaliskuu", "2020"));
			krepository.save(new Kuukausi("Huhtikuu", "2020"));
			krepository.save(new Kuukausi("Toukokuu", "2020"));
			krepository.save(new Kuukausi("Kesäkuu", "2020"));
			krepository.save(new Kuukausi("Heinäkuu", "2020"));
			krepository.save(new Kuukausi("Elokuu", "2020"));
			krepository.save(new Kuukausi("Syyskuu", "2020"));
			krepository.save(new Kuukausi("Lokakuu", "2020"));
			krepository.save(new Kuukausi("Marraskuu", "2020"));
			krepository.save(new Kuukausi("Joulukuu", "2020"));

			
			
			//Lisätään Budjetti
			brepository.save(new Budjetti("Uusi pelitietokone",2524.50, 500, 200, krepository.findByKuukausi("Tammikuu").get(0)));
			
			
			//Lisätään Käyttäjät
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("roope", "$2a$09$rEZhs8tHagppqnLCT8MVCO269aoySVhUUEA3ufy4lafDaRjM0bnEi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
	
		};
}
}
