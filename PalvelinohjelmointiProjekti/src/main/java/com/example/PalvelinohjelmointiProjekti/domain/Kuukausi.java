package com.example.PalvelinohjelmointiProjekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Kuukausi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kuukausiId;
	private String kuukausi;
	private String vuosi;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kuukausi")
	private List<Budjetti> budjetti;
	
	public Kuukausi() {
		
	}
	
	public Kuukausi(String kuukausi, String vuosi) {
		super();
		this.vuosi = vuosi;
		this.kuukausi = kuukausi;
	}

	
	public String getVuosi() {
		return vuosi;
	}

	public void setVuosi(String vuosi) {
		this.vuosi = vuosi;
	}

	public Long getKuukausiId() {
		return kuukausiId;
	}

	public void setKuukausiId(Long kuukausiId) {
		this.kuukausiId = kuukausiId;
	}

	public String getKuukausi() {
		return kuukausi;
	}

	public void setKuukausi(String kuukausi) {
		this.kuukausi = kuukausi;
	}

	public List<Budjetti> getBudjetti() {
		return budjetti;
	}

	public void setBudjetti(List<Budjetti> budjetti) {
		this.budjetti = budjetti;
	}
	
}
