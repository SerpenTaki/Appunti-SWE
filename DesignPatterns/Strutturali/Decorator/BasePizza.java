package Strutturali.Decorator;

import java.util.Collections;
import java.util.List;

public class BasePizza implements Pizza{ //La pizza non è altro che pasta cotta questo è il nostro oggetto da decorare
    public List<String> ingredients(){
        return Collections.singletonList("Pasta");
    }

    @Override
    public int cookingTime(){
        return 3;
    }

}
