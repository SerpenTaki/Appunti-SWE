> In che modo un oggetto svolge la sua funzione?
> In che modo diversi oggetti collaborano tra loro?

## Command
**Scopo**
- *Incapsulare* una *richiesta* in un oggetto cosicchè i client sia indipendenti dalle richieste
**Motivazione**
- Necessità di gestire richieste di cui non si conoscono i particolari
	- Toolkit associano ai propri elementi, richieste da eseguire
- Una classe astratta, *Command*, definisce l'*interfaccia per eseguire* la richiesta
	- La richiesta è un semplice oggetto
**Applicabilità**
- *Parametrizzazione* di oggetti sull'azione da eseguire
	- *Callback function*
- Specificare, accodare ed eseguire richieste molteplici volte
- *Supporto* ad operazione `Undo` e `Redo`
- Supporto a *transazione*
	- Un comando equivale ad una operazione atomica
![[Screenshot 2025-01-15 alle 14.30.51.png]]
![[Screenshot 2025-01-15 alle 14.31.25.png]]**Conseguenze**
- *Accoppiamento "lasco"* tra oggetto invocante e quello che porta a termine l'operazione
- I *command* possono essere estesi
- I comandi possono essere composti e innestati
- E' facile aggiungere nuovi comandi
	- Le classi esistenti non devono essere modificate
![[Screenshot 2025-01-15 alle 14.38.09.png]]
![[Screenshot 2025-01-15 alle 14.38.22.png]]
![[Screenshot 2025-01-15 alle 14.38.30.png]]
![[Screenshot 2025-01-15 alle 14.38.40.png]]
**Implementazione**
