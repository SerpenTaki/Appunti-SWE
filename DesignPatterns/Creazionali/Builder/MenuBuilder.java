package Creazionali.Builder;

import java.util.Objects;

public class MenuBuilder {
    private String primo;
    private String secondo;
    private String bibita;
    private String dolce;

    public MenuBuilder withPrimo(String primo){
        this.primo = primo;
        return primo;
    }

    public MenuBuilder withSecondo(String secondo){
        this.secondo = secondo;
        return secondo;
    }

    public MenuBuilder withBibita(String bibita){
        this.bibita = bibita;
        return bibita;
    }

    public MenuBuilder withDolce(String dolce){
        this.dolce = dolce;
        return dolce;
    }

    public Menu build(){ //possiamo costruire gli oggetti senza che ci sia un secondo o una bibita
        Object.nonNull(primo);
        Object.nonNull(bibita);
        return new Menu(primo, secondo, bibita, dolce);
    }
}
