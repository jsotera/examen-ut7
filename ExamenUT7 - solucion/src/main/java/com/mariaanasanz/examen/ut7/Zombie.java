package com.mariaanasanz.examen.ut7;

public class Zombie extends Mob {
    public Zombie() {
        super(25, 4);
    }

    @Override
    public int getPuntosExperiencia() {
        return 15;
    }
}
