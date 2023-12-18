package com.example;

public class Consumidor extends Thread{

    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        do{

            try {

                //llamamos a atender clientes
                cola.atenderCliente();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }while (true);

    }
}
