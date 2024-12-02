![[Screenshot 2024-12-02 alle 10.51.22.png]]![[Screenshot 2024-12-02 alle 10.51.33.png]]
![[Screenshot 2024-12-02 alle 10.51.47.png]]
# Diagrammi di Attività
> Descrivono la logica procedurale, i processi di business

- Aiutano a descrivere gli aspetti dinamici dei casi d'uso
- Supportano l'*elaborazione parallela*
- Un'*attività* è un insieme di *più azioni*
	- **Nodo iniziale:** dove inizia l'esecuzione del processo
	- **Fork:**
		- Elaborazione parallela
		- *Nessun ordine* fra le attività di processi differenti
	- **Join**: sincronizzazione fra processi paralleli
- Un'**attività** è un insieme di *più azioni*
	- Decisione (*branch*) `rombo`
		- Si può intraprendere solo uno dei percorsi
	- Nodo finale `cerchio con pallino grosso dentro`
		- Fine dell'attività
	- Token `circonferenza che circoscrive una X`
		- Vengono *prodotti* e *consumati*
			- Nodo iniziale genera *token*
			- Nodo finale consuma *token*
			- Fork produce un *token* per ogni processo
			- Join consuma i *token* in ingresso e ne genera solo uno
> immaginare il gioco del pachinco dove la palla scorre verso il basso passando per diversi slot

![[Screenshot 2024-12-02 alle 11.01.44.png]]
![[Screenshot 2024-12-02 alle 11.01.59.png]]
![[Screenshot 2024-12-02 alle 11.02.40.png]]
![[Screenshot 2024-12-02 alle 11.03.11.png]]
![[Screenshot 2024-12-02 alle 11.03.26.png]]
![[Screenshot 2024-12-02 alle 11.03.42.png]]
![[Screenshot 2024-12-02 alle 11.03.54.png]]
