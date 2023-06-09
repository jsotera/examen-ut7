package com.mariaanasanz.examen.ut7;

public class Zombie {

    public int vida;
    public int danoDeAtaque;

    public Zombie() {
        this.vida = 25;
        this.danoDeAtaque = 4;

    }

    public boolean atacar(Object objetivo) {
        boolean esDerrotado = false;
        if(objetivo instanceof Jugador) {
            System.out.println(this.getNombre() + " ataca a " + ((Jugador)objetivo).getNombre() + " con " + this.danoDeAtaque);
            esDerrotado = ((Jugador)objetivo).recibirAtaque(this.danoDeAtaque);
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
        return 15;
    }
}
