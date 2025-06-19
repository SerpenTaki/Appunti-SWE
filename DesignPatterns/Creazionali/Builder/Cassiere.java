package Creazionali.Builder;

//Questa classe corrisponde al Director. Espone i metodi convenienti per costruire i diversi
// tipi di oggetto usando il builder
public class Cassiere { 
    
    public Menu RiccardoChoise(){
        return new MenuBuilder().withPrimo("Insalatona di mare").withBibita("acquaFrizzante").build();
    }

    public Menu FatChoise(){
        return new MenuBuilder().withPrimo("pasta al sugo")
                                .withSecondo("Tagliata di Carne")
                                .withBibita("Coca Cola")
                                .withDolce("Kinder pinguì").build();
    }


    public void stampaFatChoise() {
        Menu menu = FatChoise();
        System.out.println("Primo: " + menu.getPrimo());
        System.out.println("Secondo: " + menu.getSecondo());
        System.out.println("Bibita: " + menu.getBibita());
        System.out.println("Dolce: " + menu.getDolce());
    }

        public void stampaRiccardoChoise() {
        Menu menu = RiccardoChoise();
        System.out.println("Primo: " + menu.getPrimo());
        System.out.println("Secondo: " + menu.getSecondo());
        System.out.println("Bibita: " + menu.getBibita());
        System.out.println("Dolce: " + menu.getDolce());
    }


}
