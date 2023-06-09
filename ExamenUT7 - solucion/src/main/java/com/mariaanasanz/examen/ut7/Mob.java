package com.mariaanasanz.examen.ut7;

public abstract class Mob implements Entidad {

    protected int vida;
    protected int danoDeAtaque;

    public Mob(int vida, int danoDeAtaque) {
        this.vida = vida;
        this.danoDeAtaque = danoDeAtaque;
    }

    @Override
    public boolean atacar(Entidad objetivo) {
        System.out.println(this.getNombre() + " ataca a "+objetivo.getNombre()+" con "+this.danoDeAtaque);
        return objetivo.recibirAtaque(this.danoDeAtaque);
    }

    @Override
    public boolean recibirAtaque(int dano){
        this.vida = this.vida - dano;
        if(this.vida<=0){
            return true;
        }
        return false;
    }

    @Override
    public void sanar(int vida) {
        this.vida = this.vida + vida;
    }

    @Override
    public String getNombre() {
        return "\033[31m" + this.getClass().getSimpleName()+"["+vida+"]\033[30m";
    }

    public abstract int getPuntosExperiencia();

}
