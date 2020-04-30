package com.example.PalvelinohjelmointiProjekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
public class Budjetti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double budjetti;
	private double tulot;
	private double menot;
	private String kuvaus;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kuukausiId")
	private Kuukausi kuukausi;

	
	public Budjetti() {
		
	}
	public Budjetti(String kuvaus, double budjetti, double tulot, double menot, Kuukausi kuukausi) {
		super();
		this.budjetti = budjetti;
		this.tulot = tulot;
		this.menot = menot;
		this.kuukausi = kuukausi;
		this.kuvaus = kuvaus;
		
	}

	
	



	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public double getTulot() {
		return tulot;
	}

	public void setTulot(double tulot) {
		this.tulot = tulot;
	}

	public double getMenot() {
		return menot;
	}

	public void setMenot(double menot) {
		this.menot = menot;
	}

	public Kuukausi getKuukausi() {
		return kuukausi;
	}

	public void setKuukausi(Kuukausi kuukausi) {
		this.kuukausi = kuukausi;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getBudjetti() {
		return budjetti;
	}
	public void setBudjetti(double budjetti) {
		this.budjetti = budjetti;
	}

	
	
	
	
	
}
