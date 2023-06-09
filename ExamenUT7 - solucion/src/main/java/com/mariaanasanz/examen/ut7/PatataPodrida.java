package com.mariaanasanz.examen.ut7;

public class PatataPodrida extends Item {

    public PatataPodrida(int cantidad){
        super(cantidad);
    }

    @Override
    public void usar(Entidad objetivo) {
        if(cantidad>0){
            System.out.println(objetivo.getNombre()+" ha usado "+this.getNombre()+"["+cantidad+"]");
            objetivo.recibirAtaque(5);
            cantidad--;
        }
    }
}
