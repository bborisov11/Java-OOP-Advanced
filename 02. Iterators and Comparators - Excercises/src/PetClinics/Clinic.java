package PetClinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Pet> {
    private String name;
    private int rooms;
    private List<Pet> pets;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        this.pets = new ArrayList<>(rooms);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public int getRooms() {
        return rooms;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new PetIterator();
    }
    private class PetIterator implements Iterator<Pet> {
        int counter = 0;
        int position = pets.size() / 2;
        int move = 0;

        @Override
        public boolean hasNext() {
            return this.counter < pets.size();
        }

        @Override
        public Pet next() {
            this.counter++;
            if(this.counter%2==0) {
                return pets.get(this.position + this.move);
            }
            else {
                return pets.get(this.position - ++this.move);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Pet pet : this.pets) {
            if(pet == null) {
                builder.append("Room empty").append(System.lineSeparator());
            } else {
                builder.append(pet.toString());
            }
        }
        return builder.toString();
    }
}
