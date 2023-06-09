package com.mariaanasanz.examen.ut7;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    public static void main(String[] args) {
        // Crear jugadores
        // todo: aqui hacer clonable
        List<Entidad> jugadores = new ArrayList<>();
        Jugador steve = new Jugador("Steve");
        steve.introducirItemAInventario(new Manzana(10));
        steve.introducirItemAInventario(new PatataPodrida(1));
        jugadores.add(steve);
        jugadores.add(new Jugador("Alex"));

        // Crear mobs
        List<Entidad> mobs = new ArrayList<>();
        mobs.add(new Zombie());
        mobs.add(new Creeper());
        mobs.add(new Esqueleto());
        mobs.add(new Zombie());
        mobs.add(new Creeper());
        mobs.add(new Esqueleto());

        // Los jugadores interactúan con los mobs
        while(mobs.size()>0 && jugadores.size()>0){
            int randomMobIndex = (int) (Math.random()*mobs.size());
            // todo: aqui coger el mob que mas dano o mas vida tenga, con un comparator
            Entidad randomMob = mobs.get(randomMobIndex);

            // Entidad randomPlayer = seleccionarJugador();
            int randomPlayerIndex = (int) (Math.random()*jugadores.size());
            Entidad randomPlayer = jugadores.get(randomPlayerIndex);
            double randomOrder = Math.random();
            boolean esDerrotado = false;
            if(randomOrder<0.5){
                // todo: Aquí que ataque el jugador que mas vida tenga o dano, comparable
                esDerrotado = randomPlayer.atacar(randomMob);
                if(esDerrotado){
                    mobs.remove(randomMob);
                    System.out.println(randomMob.getNombre() + " HA MUERTO");
                }
            } else {
                esDerrotado = randomMob.atacar(randomPlayer);
                if(esDerrotado){
                    jugadores.remove(randomPlayer);
                    System.out.println(randomPlayer.getNombre() + " HA MUERTO");
                }
            }
        }

        // TODO: los que mas dano hacen son

        // TODO: los que mas vida tienen son

        // TODO: El jugador con mas items

        // TODO: El jugador con mayor nivel y experiencia
    }
}











