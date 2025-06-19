package Creazionali.Builder;

// Questa classe possiede gli attributi del nostro menù che verranno poi utilizzati dal costruttore
// L'uso del pattern Builder evita il telescoping.

public class Menu {
    private final String primo;
    private final String secondo;
    private final String bibita;
    private final String dolce;

    public Menu(String primo, String secondo, String bibita, String dolce){
        this.primo = primo;
        this.secondo = secondo;
        this.bibita = bibita;
        this.dolce = dolce;
    }
}
