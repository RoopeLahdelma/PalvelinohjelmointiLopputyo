package com.example.PalvelinohjelmointiProjekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface KuukausiRepository extends CrudRepository<Kuukausi, Long> {

	List<Kuukausi> findByKuukausi(String kuukausi);

}
