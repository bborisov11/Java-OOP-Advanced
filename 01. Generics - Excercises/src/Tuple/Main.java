package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAdress = reader.readLine().split(" ");
        String firstElement = nameAdress[0];
        String secondElement = nameAdress[1];
        String thirdElement = nameAdress[2];
        Tuple<String,String> nameAndAdress = new Tuple<>
                (firstElement + " " + secondElement, thirdElement);
        System.out.println(nameAndAdress.toString());

        String[] nameLittersOfBeer = reader.readLine().split(" ");
        Tuple<String,Integer> nameAndLittersOfBeer =
                new Tuple<>(nameLittersOfBeer[0], Integer.parseInt(nameLittersOfBeer[1]));
        System.out.println(nameAndLittersOfBeer.toString());

        String[] integerDouble = reader.readLine().split(" ");
        Tuple<Integer,Double> integerAndDouble = new Tuple<>
                (Integer.parseInt(integerDouble[0]), Double.parseDouble(integerDouble[1]));
        System.out.println(integerAndDouble.toString());

    }
}
