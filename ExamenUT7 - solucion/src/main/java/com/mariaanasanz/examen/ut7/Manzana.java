package com.mariaanasanz.examen.ut7;

public class Manzana extends Item {

    public Manzana(int cantidad){
        super(cantidad);
    }

    @Override
    public void usar(Entidad objetivo) {
        if(cantidad>0){
            System.out.println(objetivo.getNombre()+" ha usado "+this.getNombre()+"["+cantidad+"]");
            objetivo.sanar(10);
            cantidad--;
        }
    }
}
