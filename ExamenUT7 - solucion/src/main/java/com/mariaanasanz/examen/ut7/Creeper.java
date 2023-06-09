package com.mariaanasanz.examen.ut7;

public class Creeper extends Mob {

    boolean haExplotado;
    public Creeper() {
        super(20, 5);
        haExplotado = false;
    }

    @Override
    public boolean recibirAtaque(int dano){
        boolean heMuerto = super.recibirAtaque(dano);
        if(!heMuerto){
            explotar();
            heMuerto = true;
        }
        return heMuerto;
    }

    @Override
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
