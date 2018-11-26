package PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new Manager();
        int counter = Integer.parseInt(reader.readLine());

        for (int i = 0; i < counter; i++) {
            String[] arr = reader.readLine().split(" ");
            String command = arr[0];
            if ((arr[0] + " " + arr[1]).equals("Create Pet")) {
                command = "Create Pet";
            } else if ((arr[0] + " " + arr[1]).equals("Create Clinic")) {
                command = "Create Clinic";
            }
            switch (command) {
                case "Create Pet":
                    manager.createPet(arr[2], Integer.parseInt(arr[3]), arr[4]);
                    break;
                case "Create Clinic":
                    try {
                        manager.createClinic(arr[2], Integer.parseInt(arr[3]));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Add":
                    try {
                        System.out.println(manager.add(arr[1], arr[2]));
                    }catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Release":
                    System.out.println(manager.release(arr[1]));
                    break;
                case "HasEmptyRooms":
                    System.out.println(manager.hasEmptyRooms(arr[1]));
                    break;
                case "Print":
                    if (arr.length == 2) {
                        manager.print(arr[1]);
                    } else {
                        manager.print(arr[1], Integer.parseInt(arr[2]));
                    }
                    break;
            }
        }
    }
}
