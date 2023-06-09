package com.mariaanasanz.examen.ut7;

public abstract class Item {

    protected int cantidad;

    public Item(int cantidad){
        this.cantidad = cantidad;
    }

    public abstract void usar(Entidad objetivo);

    public String getNombre() {
        return this.getClass().getSimpleName();
    }
}
