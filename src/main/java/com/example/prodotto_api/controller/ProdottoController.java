package com.example.prodotto_api.controller;

import com.example.prodotto_api.model.Prodotto;
import com.example.prodotto_api.service.ProdottoService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
metti qui le classi che gestiscono le richieste HTTP (es. ProdottoController.java) dove arrivano le richieste
 */
@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

    private final ProdottoService service;

    public ProdottoController(ProdottoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prodotto> getProdotto(@RequestParam(required = false) Integer tipo, @RequestParam(required = false) Integer id, @RequestParam(required = false) String nome, @RequestParam(required = false) Integer quantita , @RequestParam(required = false) String lotto, @RequestParam(required = false) Double prezzo) throws IOException {
        List<Prodotto> prodotti = service.getProdotti();
        if(tipo == null || tipo == 0){
            return prodotti;
        }

        switch (tipo) {
            case 1:
                if (id != null) {
                    return prodotti.stream()
                            .filter(p -> p.getId() == id)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Id non presente nella richiesta");
                }

            case 2:
                if (nome != null && !nome.isEmpty()) {
                    return prodotti.stream()
                            .filter(p -> p.getNome().equalsIgnoreCase(nome))
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Nome non presente nella richiesta");
                }

            case 3:
                if(quantita != null){
                    return prodotti.stream()
                            .filter(p -> p.getQuantita() > quantita)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Quantità non presente nella richiesta");
                }

            case 4:
                if(quantita != null){
                    return prodotti.stream()
                            .filter(p -> p.getQuantita() < quantita)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Quantità non presente nella richiesta");
                }

            case 5:
                if(quantita != null){
                    return prodotti.stream()
                            .filter(p -> p.getQuantita() == quantita)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Quantità non presente nella richiesta");
                }

            case 6:
                if(prezzo != null){
                    return prodotti.stream()
                            .filter(p -> p.getPrezzo() > prezzo)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Prezzo non presente nella richiesta");
                }
            case 7:
                if(prezzo != null){
                    return prodotti.stream()
                            .filter(p -> p.getPrezzo() < prezzo)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Prezzo non presente nella richiesta");
                }

            case 8:
                if(prezzo != null){
                    return prodotti.stream()
                            .filter(p -> p.getPrezzo() == prezzo)
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Prezzo non presente nella richiesta");
                }

            case 9:
                if(lotto != null && !lotto.equals("")){
                    return prodotti.stream()
                            .filter(p -> p.getLotto().equalsIgnoreCase(lotto))
                            .collect(Collectors.toList());
                }else{
                    return service.errore("Lotto non presente nella richiesta");
                }

            default:
                return service.errore("Tipo non presente nelle possibilità, prego inserire i seguenti:" + "  " + "1->per id" + "  " + "2->per nome" + "  " + "3->per quantita maggiore" +"  " + "4->per quantita minore" +"  " + "5->per quantita uguale" +"  " + "6->per prezzo maggiore" +"  " + "7->per prezzo minore" +"  " + "8->per prezzo uguale" +"  " + "9->per lotto");
        }
    }

    @PostMapping
    public String insertProdotto(@RequestParam String nome, @RequestParam int quantita, @RequestParam String lotto, @RequestParam double prezzo){
        Prodotto p = new Prodotto(nome, quantita, lotto, service.getProdotti().get(service.getProdotti().toArray().length - 1).getId() + 1, prezzo);
        return service.insertProdotto(p) ?  "Prodotto inserito correttamente" : "Errore durante l'inserimento";
    }

    @DeleteMapping
    public String removeProdotto(@RequestParam String nome, @RequestParam int quantita, @RequestParam String lotto, @RequestParam int id, @RequestParam double prezzo){
        Prodotto p = new Prodotto(nome, quantita, lotto, id, prezzo);
        return service.removeProdotto(p) ?  "Prodotto rimosso correttamente" : "Errore durante la rimozione";
    }

    @PutMapping
    public String updateProdotto(@RequestParam String nome, @RequestParam int quantita, @RequestParam String lotto, @RequestParam int id, @RequestParam double prezzo){
        Prodotto p = new Prodotto(nome, quantita, lotto, id, prezzo);
        return service.updateProdotto(p) ? "Prodotto aggiornato correttamente" : "Errore durante l'aggiornamento";
    }
    
}
