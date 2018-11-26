package PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Pet> pets;
    private Map<String, Clinic> clinics;

    public Manager() {
        this.pets = new HashMap<>();
        this.clinics = new HashMap<>();
    }

    public void createPet(String name, int age, String kind) {
        if(!this.pets.containsKey(name)) {
            this.pets.put(name, new Pet(name,age,kind));
        }
    }
    public void createClinic(String name, int rooms) {
        if(rooms%2==0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        if(!this.clinics.containsKey(name)) {
            this.clinics.put(name, new Clinic(name,rooms));
        }
    }

    public boolean add(String petsName, String clinicsName) {
        if(!this.pets.containsKey(petsName)) {
            //return false;
            throw new IllegalArgumentException("Invalid Operation!");
        }
        if(!this.clinics.containsKey(clinicsName)) {
            return false;
        }

        this.clinics.get(clinicsName).getPets().add(this.pets.get(petsName));
        return true;
    }

    public boolean release(String clinicsName) {
        for (Object o : clinics.get(clinicsName).Iterate) {

        }
        if(this.clinics.containsKey(clinicsName)) {
            this.clinics.remove(clinicsName); //TODO
            return true;
        }
        return false;
    }

    public boolean hasEmptyRooms(String clinicsName) {
       return this.clinics.get(clinicsName).getPets().size()
                < this.clinics.get(clinicsName).getRooms();
    }
    public void print(String clinicsName) {
        System.out.println(this.clinics.get(clinicsName).toString());
    }

    public void print(String clinicsName, int room) {
        System.out.println(this.clinics.get(clinicsName).getPets().get(room));
    }
}
