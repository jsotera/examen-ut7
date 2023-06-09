package com.mariaanasanz.examen.ut7;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    public String nombre;
    public List<Object> inventario;
    public int vida;
    public int nivel;
    public int puntosExperiencia;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = 20;
        this.nivel = 1;
        this.inventario = new ArrayList<>();
        this.puntosExperiencia = 0;
    }

    public String getNombre() {
        return "\033[32m"+nombre+"["+vida+"]\033[30m";
    }

    public boolean atacar(Object objetivo) {
        int dano = 5; // en funcion de herramienta
        if(objetivo instanceof Esqueleto){
            System.out.println(this.getNombre() + " ataca a "+((Esqueleto)objetivo).getNombre()+" con "+dano);
            sumarPuntosExperiencia(((Esqueleto) objetivo).getPuntosExperiencia());
            return ((Esqueleto) objetivo).recibirAtaque(dano);
        } else if (objetivo instanceof Creeper) {
            System.out.println(this.getNombre() + " ataca a "+((Creeper)objetivo).getNombre()+" con "+dano);
            sumarPuntosExperiencia(((Creeper) objetivo).getPuntosExperiencia());
            return ((Creeper) objetivo).recibirAtaque(dano);
        } else if (objetivo instanceof Zombie) {
            System.out.println(this.getNombre() + " ataca a "+((Zombie)objetivo).getNombre()+" con "+dano);
            sumarPuntosExperiencia(((Zombie) objetivo).getPuntosExperiencia());
            return ((Zombie) objetivo).recibirAtaque(dano);
        }
        return false;
    }

    public boolean recibirAtaque(int dano) {
        this.vida = this.vida - dano;
        if(this.vida<=0){
            return true;
        }
        if(this.vida<10 && inventario.size()>0){
            int randomItem = (int) (Math.random() * inventario.size());
            Object item = inventario.get(randomItem);
            if(item instanceof Manzana){
                ((Manzana)item).usar(this);
            }
            if(item instanceof PatataPodrida){
                ((PatataPodrida)item).usar(this);
            }
        }
        return false;
    }

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

    public void introducirItemAInventario(Object item){
        this.inventario.add(item);
    }

}
