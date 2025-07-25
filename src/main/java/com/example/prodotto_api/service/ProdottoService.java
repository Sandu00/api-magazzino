package com.example.prodotto_api.service;
/*
metti qui la logica dell’applicazione (es. ProdottoService.java) chiamato da controller
*/

import com.example.prodotto_api.model.Prodotto;
import com.example.prodotto_api.repository.ProdottoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    private final ProdottoRepository repo;

    public ProdottoService(ProdottoRepository repo) {
        this.repo = repo;
    }

    public List<Prodotto> getProdotti(){
        return repo.findAll();
    }

    public boolean insertProdotto(Prodotto p){
        try{
            repo.save(p);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean removeProdotto(Prodotto p){
        Optional<Prodotto> prodotto = repo.findById(p.getId());
        if(prodotto.isPresent()){
            repo.delete(p);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateProdotto(Prodotto p){
        Optional<Prodotto> prodotto = repo.findById(p.getId());
        if(prodotto.isPresent()){
            repo.save(p);
            return true;
        }else{
            return false;
        }
    }

}
