package org.main;

import java.util.ArrayList;
import java.util.HashMap;
import org.javatuples.Pair;

public class Barn {

    private HashMap<Integer, Pair<Horse, Client>> barn;

    public Barn() {
        this.barn = new HashMap<Integer, Pair<Horse, Client>>();
    }

    public void addHorse(Horse horse) {
        barn.put(horse.getHorseID(), Pair<horse, horse.getOwner()>;
    }

    public ArrayList<Horse> sortByClient(Client client) {
        return null; // TODO: implement this method
    }

}