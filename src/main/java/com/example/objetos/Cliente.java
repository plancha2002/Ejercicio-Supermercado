package com.example.objetos;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cliente {
    private int id;
    private Boolean atendido;
    private LocalDateTime creacion;
    private LocalDateTime finalizacion;
    private String tiempoDeEspera;


    public Cliente() {
        creacion = LocalDateTime.now();
    }

    public Cliente(int id, Boolean atendido) {
        this.id = id;
        this.atendido = atendido;
        creacion = LocalDateTime.now();
    }

    public Boolean getAtendido() {
        return atendido;
    }

    public void setAtendido(Boolean atendido) {
        this.atendido = atendido;
    }

    public LocalDateTime getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDateTime creacion) {
        this.creacion = creacion;
    }

    public LocalDateTime getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(LocalDateTime finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getTiempoDeEspera() {
        return tiempoDeEspera;
    }

    public void setTiempoDeEspera(String tiempoDeEspera) {
        this.tiempoDeEspera = tiempoDeEspera;
    }

    public void atendido(){
        atendido= true;
        finalizacion = LocalDateTime.now();

        Duration diferencia = Duration.between(creacion,finalizacion);

        long segundos = diferencia.toSecondsPart();
        long milisegundos = diferencia.toMillisPart();

        tiempoDeEspera = segundos + " : "+milisegundos;
        System.out.println("El tiempo de espera ha sido de "+ tiempoDeEspera);

    }




}
