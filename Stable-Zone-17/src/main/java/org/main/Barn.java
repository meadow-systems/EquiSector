package org.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Pair;

public class Barn {

    private HashMap<Integer, Pair<Horse, ArrayList<Client>>> barn;

    public Barn() {
        this.barn = new HashMap<Integer, Pair<Horse, ArrayList<Client>>>();
    }

    /**
     * Add horses to the Barn where a Barn element is a mapping from horse ID to a tuple Pair
     * of types Horse and ArrayList<Client>
     * @param horse the element to add to the Barn
     * @throws IllegalArgumentException if the passed in horse is null
     */
    public void addHorse(Horse horse) {
        if (horse == null) {
            throw new IllegalArgumentException("Null horse provided for Barn#addHorse(Horse)");
        }

        Pair<Horse, ArrayList<Client>> tuple = Pair.with(horse, horse.getOwner());
        barn.put(horse.getHorseID(), tuple);
    }


    /**
     * Filter the barn by a horses client 😀😀😀😀😀
     * filter the items in the map so that only horses with given client are in stream
     * maps the items in map to just being the horse and not the pair 🗺
     * returns a list of those horses 🐴🐴🐎🐎🏇🏇
     */
    public List<Object> filterByClient(Client client) {
        if(client == null){
            throw new IllegalArgumentException("You're dumb as rocks buddy :3");
        }
        return barn.entrySet().stream()
            .filter(x -> x.getValue().getValue1()
                .stream().anyMatch(y -> y.getClientID() == client.getClientID()))
            .map(z -> z.getValue().getValue0())
            .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Filter the Barn by a Horse's status as a thoroughbred.
     *
     * @param isThorough true if the horse is a thoroughbred, false otherwise
     * @return an ArrayList of Horses that are thoroughbreds if isThorough is true or an ArrayList
     * of Horses that are not thoroughbreds if isThorough is falsey walsey uwu >:3
     */
    public ArrayList<Horse> filterByThoroughbred(boolean isThorough) {
        return this.barn.values().stream()
            .filter(objects -> objects.getValue0().getHorseHealthInfo().isThoroughbred() == isThorough)
            .map(Pair::getValue0)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Filter the Barn by a Horse's sex.
     *
     * @param isMale if ya boy got a 🍆
     * @return a filtered list of speedy bois 🙌
     */
    public ArrayList<Horse> filterBySex(boolean isMale) {
        return this.barn.values().stream()
            .filter(objects -> objects.getValue0().getHorseHealthInfo().isMale() == isMale)
            .map(Pair::getValue0)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
