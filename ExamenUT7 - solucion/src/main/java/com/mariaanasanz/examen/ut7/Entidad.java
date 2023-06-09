package com.mariaanasanz.examen.ut7;

public interface Entidad {

    public String getNombre();
    public boolean atacar(Entidad objetivo);
    public boolean recibirAtaque(int dano);
    public void sanar(int vida);

}
