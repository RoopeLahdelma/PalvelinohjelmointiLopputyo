package com.example.PalvelinohjelmointiProjekti;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.PalvelinohjelmointiProjekti.domain.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PalvelinOhjelmointiRepositoryTest {
	
	@Autowired
	private BudjettiRepository brepository;
	@Autowired
	private KuukausiRepository krepository;
	@Autowired
	private UserRepository usrepository;
	
	@Test
	public void findBynameShouldReturnBudjetti() {
	List<Budjetti> budjetti = brepository.findByBudjetti(2524.50);
	assertThat(budjetti).hasSize(1);
	assertThat(budjetti.get(0).getBudjetti()).isEqualTo(2524.50);
	}
	@Test
	public void createNewBudjetti() {
	Budjetti budjetti = new Budjetti("Uusi pelitietokone",2524.50, 500, 200, new Kuukausi("Maaliskuu", "2019") );
	brepository.save(budjetti);
	assertThat(budjetti.getId()).isNotNull();
	}
	
@Test
public void deleteNewBudjetti() {
Budjetti budjetti = new Budjetti("Uusi pöytä",3920.50, 200, 300, krepository.findByKuukausi("Tammikuu").get(0));
brepository.save(budjetti);

brepository.deleteAll();  
assertThat(brepository.count()).isEqualTo(0);

}  

@Test
public void findByNameCategoryTest() {
	List<Kuukausi> kuukaudet = krepository.findByKuukausi("Tammikuu");
	assertThat(kuukaudet).hasSize(1);
    assertThat(kuukaudet.get(0).getKuukausi()).isEqualTo("Tammikuu");
}

@Test
public void createNewKuukausiTest() {
   	Kuukausi kuukausi = new Kuukausi("Joulukuu", "1997");
	krepository.save(kuukausi);
	assertThat(kuukausi.getKuukausiId()).isNotNull();
}

@Test
public void deleteKuukausiTests() {
	Kuukausi kuukausi = new Kuukausi("Kesäkuu", "2010");
	krepository.save(kuukausi);
	krepository.deleteAll();
	assertThat(krepository.count()).isEqualTo(0); 
}   

@Test
public void findByUsernameUserTest() {
    User user = usrepository.findByUsername("admin");
    assertThat(user.getUsername()).isNotNull();
    assertThat(user.getRole()).isEqualTo("ADMIN");
}

@Test
public void createNewUserTest() {
	User user = new User("Roope", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	usrepository.save(user);
	assertThat(user.getId()).isNotNull();
}  

@Test
public void deleteAllUsersTest() {
	User user = new User("Roope B", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	usrepository.save(user);
	usrepository.deleteAll();
	assertThat(usrepository.count()).isEqualTo(0); 
}   

}
