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

        ⚠️ Tipo non presente nelle possibilità, prego inserire i seguenti valori:

            1 → per id

            2 → per nome

            3 → per quantità maggiore

            4 → per quantità minore

            5 → per quantità uguale

            6 → per prezzo maggiore

            7 → per prezzo minore

            8 → per prezzo uguale

            9 → per lotto

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

