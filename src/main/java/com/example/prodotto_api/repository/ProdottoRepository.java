package com.example.prodotto_api.repository;

/*
metti qui le interfacce per l’accesso al database (es. ProdottoRepository.java) chiamato da service
 */

import com.example.prodotto_api.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{
}
