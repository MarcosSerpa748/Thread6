package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Utilitarios {

    public static void fecharThreadPool(ExecutorService executores){
        executores.shutdown();

        try {

            if (!executores.awaitTermination(3, TimeUnit.SECONDS)){
                executores.shutdownNow();
            }

        }catch (InterruptedException e){
            System.err.println("A Thread principal foi interrompida!");
            executores.shutdownNow();
        }
    }
}
