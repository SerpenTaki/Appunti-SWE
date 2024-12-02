Le applicazioni prive di un'architettura formale sono generalmente accoppiate, fragili, difficili da modificare.
- I moduli danno luogo a una collezione non organizzata.
- *Big ball of mud* Antipattern
- Problemi di distribuzione e manutenzione
	- L'architettura è scalabile? come risponde ai cambiamenti? Quali sono le caratteristiche di distribuzione?
*Modelli di architettura*
- Aiuta a gestire questi aspetti, conoscendone le caratteristiche, i punti di forza e di debolezza
# Layered Architecture
- La più comune
	- *N-tier* architecture pattern
	- Standard *de facto* per la maggior parte delle applicazioni JEE
		- Conosciuta dalla maggior parte degli architetti e sviluppatori
	- Riflette l'*organizzazione* e la struttura di molte aziende
- I componenti sono organizzati in *layer orizzontali*
	- Ogni livello svolge un ruolo singolo e specifico.
	- Di solito i livelli sono 4
		- *Presentation, Business, Persistence, Database*
![[Screenshot 2024-12-02 alle 11.14.46.png]]
## Separation of Concerns