package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lights = reader.readLine().split(" ");
        int countOfRepeating = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countOfRepeating; i++) {
           String last = lights[lights.length - 1];
            lights[lights.length - 1] = lights[1];
            lights[1] = lights[0];
            lights[0] = last;

            for (int j = 0; j < lights.length; j++) {
                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
