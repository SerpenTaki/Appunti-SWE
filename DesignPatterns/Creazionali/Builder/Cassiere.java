package Creazionali.Builder;

//Questa classe corrisponde al Director. Espone i metodi convenienti per costruire i diversi
// tipi di oggetto usando il builder
public class Cassiere { 
    
    public Menu RiccardoChoise(){
        return new MenuBuilder().withPrimo("Insalatona di mare").withBibita("acquaFrizzante");
    }

    public Menu FatChoise(){
        return new MenuBuilder().withPrimo("pasta al sugo")
                                .withSecondo("Tagliata di Carne")
                                .withBibita("Coca Cola")
                                .withDolce("Kinder pinguì");
    }

}
