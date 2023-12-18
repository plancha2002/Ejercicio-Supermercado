package com.example;

import com.example.objetos.Cliente;

import java.util.Random;

public class Productor extends Thread{
    private Cola cola;

    private int contador;

    public Productor(Cola cola) {
        this.cola = cola;
        this.contador = 0;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        do{

            try {
                //asignamos un tiempo en que llegue un cliente
                Thread.sleep(new Random().nextInt(3500)+1);
                //este sera el contador de cliente se indepdiente opr cola, aqui es un contador para un id a cada cliente
                //se puede usar como contador de clientes atendidos
                contador++;
                //agregamos un cliente instanciando de manera anonima, poniendo como id el contado
                //y su estado de atendido a falso
                cola.agregarCliente(new Cliente(contador,false));
                //indicamos que el productor a agregador un elemento a la lista
                System.out.println("Se ha agregado un cliente con id "+ contador);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }while (true);

    }
}
