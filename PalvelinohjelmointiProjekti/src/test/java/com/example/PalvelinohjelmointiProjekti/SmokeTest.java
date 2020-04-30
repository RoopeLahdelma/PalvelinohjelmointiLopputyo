package com.example.PalvelinohjelmointiProjekti;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.PalvelinohjelmointiProjekti.controller.ProjektiController;
import com.example.PalvelinohjelmointiProjekti.controller.UserDetailServiceImpl;
import com.example.PalvelinohjelmointiProjekti.domain.UserRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Test
	void contextLoadsOther() {
	}
	@Autowired
    private ProjektiController projektiController;
	@Autowired
	private UserRepository usrepository;
	@Autowired
	private UserDetailServiceImpl udsi;
	

    @Test
    public void contexLoads() throws Exception {
        assertThat(projektiController).isNotNull();
    }
    
    @Test
    public void contexLoads1() throws Exception {
        assertThat(usrepository).isNotNull();
    }	
    
    @Test
    public void contexLoads2() throws Exception {
        assertThat(udsi).isNotNull();
    }	
}
