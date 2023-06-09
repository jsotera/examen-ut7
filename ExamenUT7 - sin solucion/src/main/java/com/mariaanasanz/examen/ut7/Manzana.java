package com.mariaanasanz.examen.ut7;

public class Manzana {

    public int cantidad;

    public Manzana(int cantidad){
        this.cantidad = cantidad;
    }

    public void usar(Object objetivo) {
        if(cantidad>0 && objetivo instanceof Jugador){
            System.out.println(((Jugador)objetivo).getNombre()+" ha usado 1 "+this.getNombre()+"["+cantidad+"]");
            ((Jugador) objetivo).sanar(10);
            cantidad--;
        }
    }

    public String getNombre() {
        return this.getClass().getSimpleName();
    }
}
