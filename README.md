API Magazzino 📦

API REST per la gestione di un magazzino con operazioni CRUD sui prodotti.
Avvio rapido

git clone https://github.com/Sandu00/api-magazzino.git
cd api-magazzino
./mvnw spring-boot:run

Applicazione disponibile su: http://localhost:8080
API Endpoints

Base URL: http://localhost:8080/api/prodotti

    GET - Ottieni prodotti (filtri: tipo, id, nome, quantita):
    Valori possibili per il parametro tipo:

    Tipo non presente nelle possibilità, prego inserire i seguenti:  
    1 -> per id  
    2 -> per nome  
    3 -> per quantita maggiore  
    4 -> per quantita minore  
    5 -> per quantita uguale  
    6 -> per prezzo maggiore  
    7 -> per prezzo minore  
    8 -> per prezzo uguale  
    9 -> per lotto

    POST - Crea prodotto (nome, quantita, lotto, prezzo)

    PUT - Aggiorna prodotto

    DELETE - Elimina prodotto

Modello Prodotto

{
  "id": 1,
  "nome": "Smartphone",
  "quantita": 50,
  "lotto": "LOT001",
  "prezzo": 299.99
}
