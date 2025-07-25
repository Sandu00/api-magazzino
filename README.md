# API Magazzino 📦

API REST per la gestione di un magazzino con operazioni CRUD sui prodotti.

## Avvio rapido

```bash
git clone https://github.com/Sandu00/api-magazzino.git
cd api-magazzino
./mvnw spring-boot:run
```

Applicazione disponibile su: `http://localhost:8080`

## API Endpoints

**Base URL:** `http://localhost:8080/api/prodotti`

- `GET` - Ottieni prodotti (filtri: `tipo`, `id`, `nome`, `quantita`)
- `POST` - Crea prodotto (`nome`, `quantita`, `lotto`, `prezzo`)
- `PUT` - Aggiorna prodotto
- `DELETE` - Elimina prodotto

## Modello Prodotto

```json
{
  "id": 1,
  "nome": "Smartphone",
  "quantita": 50,
  "lotto": "LOT001",
  "prezzo": 299.99
}
```