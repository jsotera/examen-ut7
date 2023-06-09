package com.mariaanasanz.examen.ut7;

public class Esqueleto extends Mob {

    int numFlechas;

    public Esqueleto() {
        super(15, 2);
        numFlechas = 3;
    }

    public boolean disparar(Entidad objetivo){
        System.out.println(this.getNombre()+" ha disparado a "+objetivo.getNombre()+" con "+danoDeAtaque*2);
        boolean esDerrotado = objetivo.recibirAtaque(danoDeAtaque*2);
        numFlechas--;
        return esDerrotado;
    }

    @Override
    public boolean atacar(Entidad objetivo) {
        boolean esDerrotado = false;
        if(numFlechas>0){
            esDerrotado = disparar(objetivo);
        } else {
            esDerrotado = super.atacar(objetivo);
        }
        return esDerrotado;
    }

    @Override
    public int getPuntosExperiencia() {
        return 5;
    }
}
