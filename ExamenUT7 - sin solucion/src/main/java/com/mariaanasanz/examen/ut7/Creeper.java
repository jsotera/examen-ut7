package com.mariaanasanz.examen.ut7;

public class Creeper {

    public int vida;
    public int danoDeAtaque;
    public boolean haExplotado;

    public Creeper() {
        this.vida = 20;
        this.danoDeAtaque = 5;
        haExplotado = false;
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
        boolean heMuerto = false;
        this.vida = this.vida - dano;
        if(this.vida<=0){
            heMuerto = true;
        }
        if(!heMuerto){
            explotar();
            heMuerto = true;
        }
        return heMuerto;
    }

    public void sanar(int vida) {
        this.vida = this.vida + vida;
    }

    public String getNombre() {
        return "\033[31m" + this.getClass().getSimpleName()+"["+vida+"]\033[30m";
    }

    public int getPuntosExperiencia() {
        if(haExplotado){
            return 0;
        } else {
            return 10;
        }
    }

    public void explotar(){
        haExplotado = true;
        System.out.println("Creeper ha explotado");
    }

}
