package com.mariaanasanz.examen.ut7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxxx xxxx xxxx
 */
public class Partida {
    public static void main(String[] args) {
        // Crear jugadores
        List<Object> jugadores = new ArrayList<>();
        Jugador steve = new Jugador("Steve");
        steve.introducirItemAInventario(new Manzana(10));
        steve.introducirItemAInventario(new PatataPodrida(1));
        jugadores.add(steve);
        // TODO: Steve se siente solo, clonalo e incluye a su hermano gemelo (Alex) a la lista de jugadores

        // Crear mobs
        List<Object> mobs = new ArrayList<>();
        mobs.add(new Zombie());
        mobs.add(new Creeper());
        mobs.add(new Esqueleto());
        mobs.add(new Zombie());
        mobs.add(new Creeper());
        mobs.add(new Esqueleto());

        // Los jugadores interactúan con los mobs
        while(mobs.size()>0 && jugadores.size()>0){
            // TODO: Obtener el mob que mas dano haga en vez de uno aleatorio
            int randomMobIndex = (int) (Math.random()*mobs.size());
            Object randomMob = mobs.get(randomMobIndex);

            // TODO: Obtener el jugador con mas vida en vez de uno aleatorio
            int randomPlayerIndex = (int) (Math.random()*jugadores.size());
            Object randomPlayer = jugadores.get(randomPlayerIndex);
            double randomOrder = Math.random();
            boolean esDerrotado = false;
            if(randomOrder<0.5){
                if(randomPlayer instanceof Jugador) {
                    esDerrotado = ((Jugador) randomPlayer).atacar(randomMob);
                    if (esDerrotado) {
                        mobs.remove(randomMob);
                        if(randomMob instanceof Creeper){
                            System.out.println(((Creeper)randomMob).getNombre() + " HA MUERTO");
                        } else if (randomMob instanceof Esqueleto) {
                            System.out.println(((Esqueleto)randomMob).getNombre() + " HA MUERTO");
                        } else if (randomMob instanceof Zombie) {
                            System.out.println(((Zombie)randomMob).getNombre() + " HA MUERTO");
                        }
                    }
                }
            } else {
                if(randomMob instanceof Creeper){
                    esDerrotado = ((Creeper)randomMob).atacar(randomPlayer);
                    if (esDerrotado) {
                        jugadores.remove(randomPlayer);
                        if(randomPlayer instanceof Jugador){
                            System.out.println(((Jugador)randomPlayer).getNombre() + " HA MUERTO");
                        }
                    }
                } else if (randomMob instanceof Esqueleto) {
                    esDerrotado = ((Esqueleto)randomMob).atacar(randomPlayer);
                    if (esDerrotado) {
                        jugadores.remove(randomPlayer);
                        if(randomPlayer instanceof Jugador){
                            System.out.println(((Jugador)randomPlayer).getNombre() + " HA MUERTO");
                        }
                    }
                } else if (randomMob instanceof Zombie) {
                    esDerrotado = ((Zombie)randomMob).atacar(randomPlayer);
                    if (esDerrotado) {
                        jugadores.remove(randomPlayer);
                        if(randomPlayer instanceof Jugador){
                            System.out.println(((Jugador)randomPlayer).getNombre() + " HA MUERTO");
                        }
                    }
                }
            }
        }

        // TODO: Mostrar un listado de jugadores ordenados por nivel y experiencia
    }
}











