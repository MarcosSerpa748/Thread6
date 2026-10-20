package org.example;
import java.util.List;
import java.util.concurrent.*;
public class Main {
    public static void main(String[] args){

        ExecutorService executores = Executors.newFixedThreadPool(2);

        try {
        List<Future<Double>> futurasRespostas = executores.invokeAll(List.of(
                () ->{
                    Thread.sleep(1000);
                    return 80.0;
                },
                () ->{
                    Thread.sleep(2000);
                    return 130.0;
                },
                () ->{
                    Thread.sleep(12000);
                    return 10.0;
                },
                () ->{
                    Thread.sleep(11000);
                    return 250.0;
                }
        ));


            for (Future<Double> i:futurasRespostas){
                Double valorProcessado = i.get();
                System.out.println("Valor processado:"+valorProcessado);

            }
        }catch (InterruptedException e){
            System.err.println("Thread principal interrompida!");
        }catch (ExecutionException e){
            System.err.println("Erro no processamento:"+e.getCause().getMessage());
        }finally {
            Utilitarios.fecharThreadPool(executores);
        }

    }
}