package com.example.PalvelinohjelmointiProjekti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.PalvelinohjelmointiProjekti.domain.*;





@Controller
public class ProjektiController {

	@Autowired
	private BudjettiRepository brepository;
	@Autowired
	private KuukausiRepository krepository;
	
	//kirjautumissivun haku
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	//Haetaan kaikki budjetointiin liittyvä
	@RequestMapping(value= {"/", "/budjetti"})
	public String Budjetti(Model model) {
		model.addAttribute("budjetit", brepository.findAll());
		return "budjetti";
	}
	
	//Lisätään kuukaudelle budjetti ja tulot sekä menot
	@RequestMapping(value= {"/add"})
	public String addbudjetti(Model model) {
		model.addAttribute("budjetti", new Budjetti());
		model.addAttribute("kuukaudet", krepository.findAll());
		return "addbudjetti";
	}
	
	//Budjetin tallenus
	@RequestMapping(value= "/save", method=RequestMethod.POST)
	public String save(Budjetti budjetti) {
		brepository.save(budjetti);
		return "redirect:budjetti";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value= "/delete/{id}", method=RequestMethod.GET)
	public String DeleteBudjetti(@PathVariable("id")Long id, Model model) {
		brepository.deleteById(id);
		return "redirect:../budjetti";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBudjetti(@PathVariable("id") Long id, Model model) {
	    	
	    	model.addAttribute("budjetti", brepository.findById(id));
	    	model.addAttribute("kuukaudet", krepository.findAll());
	        return "editbudjetti";
	    } 
	
}
