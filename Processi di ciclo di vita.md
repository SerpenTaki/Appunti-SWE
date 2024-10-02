> Un prodotto SoftWare è tanto più *buono* quanto più resta in uso
> \- Tullio

**Sistema**: aggregazione di parti, ovvero parti che stanno insieme con un compito per produrre un effetto produttivo
Quindi un prodotto è buono perchè lo usano in tanti per tanto tempo. Quindi un prodotto buono è tenuto in vita. 
Più lunga è la vita di un prodotto, maggiore necessità di **manutenzione**.
Ciò che è sotto manutenzione ha una *storia*.
- Memoria di ciò che funziona (*ora*)
- O ha funzionato in certo momento
- O è ancora in lavorazione (*da sistemare o fare*)
Un prodotto SW <u>non</u> è mai un monolite un pezzo unico ma invece un insieme di parti collegate tra loro, ciò aiuta alla comprensione, sviluppo e manutenzione delle singole parti.
-> Ciò richiede anche una chiara specifica di come queste siano collegate tra loro. In questo modo si semplifica la *comprensione, sviluppo e manutenzione delle singole parti*
- Ogni sistema fatto di parti viene gestito con un **controllo di configurazione**
Qualunque prodotto software è fatta di 3 parti altrimenti il SW è **Inutile**
- Persistenza Dati (*Basi di dati*)
- User Experience (*interfaccia utente*)
- Configurazione (*collante tra persistenza dati e esperienza utente*)
La storia individuale viene gestita tramite **controllo di versione**:
- Il **controllo di versione** aiuta a non perdere traccia di questa storia
- A poter avanzare o retrocedere, componente per componente, con precisione, rispetto ad essa
La storia di un prodotto SW (*nel suo insieme*) attraversa **stati**, il suo insieme è detto **ciclo di vita**
- Concezione (*opportunity + stakeholders*) -> sviluppo (*work*) -> Utilizzo e manutenzione -> ritiro (*da non usare più* **deprecato**)
La vita di un prodotto software può essere descritto come un automa a stati finiti
- Stato = il grado di maturazione raggiunto attualmente dal prodotto SW
- Arco (*transizione di stato*) = le attività svolte sul prodotto SW per farne avanzare lo stato
Gli stati e le regole di attivazione degli archi (*pre- post- condizioni*)
- obblighi (*requirements*), metodo (*way of working*), opportunità

---
**Ciclo di vita**
- Gli stati che il prodotto SW richiesto assume dal concepimento (*bisogni -> needs*) all'uso e poi eventualmente al ritiro
**Processi di ciclo di vita**
- Raggruppano e codificano (secondo *best pratice*) le attività da svolgere per effettuare corrette transizioni di stato nel ciclo di vita di un prodotto software
**Modelli di ciclo di vita**
- Descrivono quali stati e quali transizioni privilegiare in un ciclo di vita e quindi quali processi attivare in esso
Aderire ad un modello di ciclo di vita consente di determinare quali processi serva attuare
- pianificare, organizzare, eseguire e controllare lo svolgimento delle corrispondenti attività
---
# Il concetto di processo
**Processo**: insieme di attività *correlate* e *coese* che trasformano ingressi (*bisogni*) in uscite (*prodotti*) secondo regole date, consumando risorse nel farlo
![[Screenshot 2024-10-02 alle 13.52.59.png]]
- Un insieme di attività è **efficace** quando raggiunge gli obiettivi attesi
	- Metrica: grado di raggiungimento di obiettivi interni (*del fornitore*) o esterni (*gradimento del cliente/degli utenti*)
- Un insieme di attività è **efficiente** quando raggiunge gli obiettivi senza sprecare risorse
	- Metrica: **produttività**: rapporto tra quantità di prodotto realizzato e risorse utilizzate
- La combinazione di efficienza ed efficacia si chiama **economicità**

**Premessa 1**: Compito di un progetto è spingere un prodotto SW attraverso un dato segmento del suo ciclo di vita
**Premessa 2**: I processi di ciclo di vita specificano quali attività svolgere per attuare corrette transizioni di stato in modo efficiente ed efficace
**Conseguenza**: Lo svolgimento di un progetto attua un insieme organico di processi
- **NON** un insieme casuale e disordinato di attività
### Standard di processo
**Adottare _standard_ di processo aiuta a raggiungere l'economicità**
- Standard Generali
	- ISO/IEC 12207:1995 e sue evoluzioni
	- Modello di riferimento del dominio SWE
- Modello di azione
	- Dice cosa fare, come, quando
	- Descrittivo o prescrittivo
- Modello di valutazione
	- Misura la distanza tra un particolare *way of working* e la *best practice* di riferimento
#### Il modello ISO/IEC 12207:1995
- Il modello più noto e riferito
	- Ha natura descrittiva
	- Ne esistono altri specializzati di dominio che sono prevalentemente prescrittivi
- È un modello "ad alto livello"
	- Identifica i processi di ciclo di vita del SW
	- Ha struttura modulare che richiede specializzazione
	- Specifica le responsabilità sui processi
	- Identifica i prodotti dei processi
![[Screenshot 2024-10-02 alle 14.05.14.png]]
### Processi primari
- **Acquisizione**
	- Gestione dei propri sotto-fornitori
- **Fornitura**
	- Gestione dei rapporti con il cliente
- **Sviluppo**
- **Gestione operativa (_utilizzo_)**
	- Installazione ed erogazione dei prodotti e/o servizi
- **Manutenzione**
	- Correzione, adattamento, evoluzione
### Processi di supporto
>I processi di supporto stanno ai processi primari come le procedure di programma stanno al _main_
>- Tullio
- **Documentazione**
- **Gestione della configurazione**
- **Accertamento della qualità**
- **Verifica** ------------------ Qualifica
- **Validazione**---------------- Qualifica
- **Revisioni congiunte con il cliente**
- **Verifiche ispettive interne**
- **Risoluzione dei problemi (_gestione dei cambiamenti_)**
### Processi organizzativi
> I processi organizzativi sono trasversali rispetto ai singoli progetti, come il S/O rispetto al programma
> - Tullio
- Gestione dei processi
	- *Debugging* dei processi
- Gestione delle infrastrutture (tecniche)
	- Organizzazione degli strumenti di supporto ai processi
- Miglioramento del processo
	- Manutenzione migliorativa dei processi
- Formazione del personale
	- Aiuto, stimolo e completamento all'auto-formazione
![[Screenshot 2024-10-02 alle 14.53.44.png]]
![[Screenshot 2024-10-02 alle 14.54.03.png]]
attività di processo : https://www.math.unipd.it/~tullio/IS-1/2024/Dispense/T02.pdf
### Specializzazione di processi
- Fattori di specializzazione
	- Dimensione e complessità del progetto
	- Tipo e intensità dei rischi di progetto
	- Competenza ed esperienza delle risorse umane
- Associare ai processi un **Sistema di qualità** aiuta a migliorarli e a garantire conformità
	- **Maturità** = qualità misurata delle prestazioni
	- **Conformità** = adesione alle aspettative e agli obblighi

![[Screenshot 2024-10-02 alle 14.59.16.png]]
### Organizzazione di processo
- Il <u>controllo di processo</u> consente di attuare manutenzione migliorativa al proprio *way of working*
	- **Principio del miglioramento continuo**
		- *Shewhart-Deming's Learning-and-Quality Cycle 1950*
- Ciclo a 4 stadi innescato per apportare specifiche migliorie a specifici processi

# Ciclio di miglioramento continuo
- **Pianificare (_plan_)**
	- Definire *attività, scadenze, responsabilità, risorse* <u>per raggiungere specifici obiettivi di miglioramento</u>
	- Non è pianificazione di progetto, ma pianificazione di miglioramento
- **Eseguire (_Do_)**
	- Eseguire le attività secondo P
	- Non è sviluppo, ma dispiegamento (*esplorativo*) di azioni di miglioramento
- **Valutare (_Check_)**
	- Verificare l'esito delle azioni di miglioramento rispetto alle attese
- **Agire (_Act_)**
	- Consolidare il buono - aggiornando il *way of working* - e cercare altri modi per migliorare il resto
