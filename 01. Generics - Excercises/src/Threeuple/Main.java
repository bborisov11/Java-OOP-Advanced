package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAdress = reader.readLine().split(" ");
        String firstElement = nameAdress[0];
        String secondElement = nameAdress[1];
        String thirdElement = nameAdress[2];
        String fourthElement = nameAdress[3];
        Treeuple<String> nameAndAdress = new Treeuple<>
                (firstElement + " " + secondElement, thirdElement, fourthElement);
        System.out.println(nameAndAdress.toString());

        String[] nameLittersOfBeer = reader.readLine().split(" ");
        boolean drunk = false;
        if(nameLittersOfBeer[2].equals("drunk")) {
            drunk = true;
        }
        Treeuple<Boolean> nameAndLittersOfBeer =
                new Treeuple<>(nameLittersOfBeer[0], Integer.parseInt(nameLittersOfBeer[1]), drunk);
        System.out.println(nameAndLittersOfBeer.toString());

        String[] integerDouble = reader.readLine().split(" ");
        Treeuple<String> integerAndDouble = new Treeuple<>
                (integerDouble[0],
                        Double.parseDouble(integerDouble[1])
                        , integerDouble[2]);
        System.out.println(integerAndDouble.toString());

    }
}
