package com.example.PalvelinohjelmointiProjekti.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;



public interface BudjettiRepository extends CrudRepository<Budjetti, Long> {

	List<Budjetti> findByBudjetti(double budjetti);
}
