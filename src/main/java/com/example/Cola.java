package com.example;

import com.example.objetos.Cliente;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cola {


//este array representa la cola de cliente pendientes
    private ArrayList<Cliente> clientes = new ArrayList<>();

    //lo useremos como un semamaforo
    private Semaphore semaforo = new Semaphore(1);

    public Cola() {
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) throws InterruptedException {
        //cerramos la seccion critica para evitar inconsistencias
        semaforo.acquire();
        //agregamos a la lista un cliente
        clientes.add(cliente);
        //indicamos por pantalla cuantos cliente hay en cola
        System.out.println("Ahora hay "+clientes.size() + " en la cola");
        //abrimos la seccion critica para permitir a otros hilos acceder
        semaforo.release();
    }

    public void  atenderCliente() throws InterruptedException {
        boolean disparador = true;
        //aqui paramos el hilo, podriamos decir que el tiempo que tarda el cajero en atender
        Thread.sleep(new Random()
                                .nextInt(4000)+1
        );

        //comprobamos que la lista tengo elementos, sino esta vacia
        if (!clientes.isEmpty()){
            //para atender clientes iremos por orden de llegada
            semaforo.acquire();

            //siempre atenderemos a quien se encuentre primero
            clientes.get(0).atendido();


            //quitamos el cliente atendido de la lista
            clientes.remove(0);
            //indicamos cuantos clientes quedan por antender
            System.out.println("Quedan " + clientes.size() + " clientes en la cola");

            semaforo.release();
            disparador = true;
        }else{
            //hacemos un pequeño control para evitar que si un tiempo no hay clientes se arme un stacktrace largo
            if (disparador){
                System.out.println("Cola vacia");
                disparador = false;
            }


        }


    }
}
