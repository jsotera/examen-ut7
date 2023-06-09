package com.mariaanasanz.examen.ut7;

public class Esqueleto {

    public int numFlechas;
    public int vida;
    public int danoDeAtaque;

    public Esqueleto() {
        this.vida = 15;
        this.danoDeAtaque = 2;
        numFlechas = 3;
    }

    public boolean disparar(Jugador objetivo){
        System.out.println(this.getNombre()+" ha disparado a "+objetivo.getNombre()+" con "+danoDeAtaque*2);
        boolean esDerrotado = objetivo.recibirAtaque(danoDeAtaque*2);
        numFlechas--;
        return esDerrotado;
    }

    public boolean atacar(Object objetivo) {
        boolean esDerrotado = false;
        if(objetivo instanceof Jugador) {
            if (numFlechas > 0) {
                esDerrotado = disparar((Jugador)objetivo);
            } else {
                System.out.println(this.getNombre() + " ataca a " + ((Jugador)objetivo).getNombre() + " con " + this.danoDeAtaque);
                esDerrotado = ((Jugador)objetivo).recibirAtaque(this.danoDeAtaque);
            }
        }
        return esDerrotado;
    }

    public boolean recibirAtaque(int dano){
        this.vida = this.vida - dano;
        if(this.vida<=0){
            return true;
        }
        return false;
    }

    public void sanar(int vida) {
        this.vida = this.vida + vida;
    }

    public String getNombre() {
        return "\033[31m" + this.getClass().getSimpleName()+"["+vida+"]\033[30m";
    }

    public int getPuntosExperiencia() {
        return 5;
    }
}
