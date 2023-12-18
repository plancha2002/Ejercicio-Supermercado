package com.example.objetos;

import com.example.Cola;

public class Cajero {

    //tenemos la variable de numero de clientes hecha, aunque no se le da uso en esta solucion
    private int numeroDeClientesAtendidos;

    private Cola cola;

    public Cajero() {
    }

    public Cajero(int numeroDeClientesAtendidos, Cola cola) {
        this.numeroDeClientesAtendidos = numeroDeClientesAtendidos;
        this.cola = cola;
    }

    public int getNumeroDeClientesAtendidos() {
        return numeroDeClientesAtendidos;
    }

    public void setNumeroDeClientesAtendidos(int numeroDeClientesAtendidos) {
        this.numeroDeClientesAtendidos = numeroDeClientesAtendidos;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }
}
