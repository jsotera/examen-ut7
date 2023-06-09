package com.mariaanasanz.examen.ut7;

public class PatataPodrida {

    public int cantidad;

    public PatataPodrida(int cantidad){
        this.cantidad = cantidad;
    }

    public void usar(Object objetivo) {
        if(cantidad>0 && objetivo instanceof Jugador){
            System.out.println(((Jugador)objetivo).getNombre()+" ha usado "+this.getNombre()+"["+cantidad+"]");
            ((Jugador) objetivo).recibirAtaque(5);
            cantidad--;
        }
    }

    public String getNombre() {
        return this.getClass().getSimpleName();
    }
}
