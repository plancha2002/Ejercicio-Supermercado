package com.example;

public class Main {
    public static void main(String[] args) {

        /*Como funciona?

        Tenemos primero unos objetos que seran nuestro cajero y nuestro cliente, los hacemos para tener una baje
        tenemos una clase Cola, sera buffer, contendra la cola y formara parte del productor y del consumidor
        Productor: sera el que represente a los clientes, que van llegando a la cola produciendo elemento que deben ser consumidos
        Consumidor: sera el cajero, que debera consumir los elemento creados

         */

        //Si quisieramos mas colas, creariamos mas objetos. Una cola completa se compone de
        //una cola que sera nuestro buffer, un productor, que sera nuestros clientes y
        //un consumidor que seran nuestros cajeros.
        Cola cola1 = new Cola();
        Productor p1 = new Productor(cola1);
        Consumidor c1 = new Consumidor(cola1);

        p1.start();
        c1.start();
    }
}
