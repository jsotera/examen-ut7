package com.mariaanasanz.examen.ut7;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Entidad {
    private String nombre;
    private List<Item> inventario;
    private int vida;
    private int nivel;
    private int puntosExperiencia;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = 20;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
        this.puntosExperiencia = 0;
    }

    @Override
    public String getNombre() {
        return "\033[32m"+nombre+"["+vida+"]\033[30m";
    }

    @Override
    public boolean atacar(Entidad objetivo) {
        int dano = 5; // en funcion de herramienta
        System.out.println(this.getNombre() + " ataca a "+objetivo.getNombre()+" con "+dano);
        if(objetivo instanceof Mob) {
            sumarPuntosExperiencia(((Mob) objetivo).getPuntosExperiencia());
        }
        return objetivo.recibirAtaque(dano);
    }

    @Override
    public boolean recibirAtaque(int dano) {
        this.vida = this.vida - dano;
        if(this.vida<=0){
            return true;
        }
        if(this.vida<10 && inventario.size()>0){
            int randomItem = (int) (Math.random() * inventario.size());
            Item item = inventario.get(randomItem);
            item.usar(this);
        }
        return false;
    }

    @Override
    public void sanar(int vida) {
        this.vida = this.vida + vida;
    }

    public void sumarPuntosExperiencia(int puntosExperiencia){
        this.puntosExperiencia = this.puntosExperiencia + puntosExperiencia;
        if(this.puntosExperiencia>30){
            this.puntosExperiencia = 0;
            this.nivel++;
            System.out.println(getNombre()+" ha subido al nivel "+this.nivel);
        }
    }

    public void introducirItemAInventario(Item item){
        this.inventario.add(item);
    }

}
