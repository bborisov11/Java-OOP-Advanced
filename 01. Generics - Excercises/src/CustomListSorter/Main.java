package CustomListSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        CustomList<String> list = new CustomList<String>();
        while (!(input = reader.readLine()).equals("END")) {
            String[] inputArgs = input.split(" ");

            String command = inputArgs[0];

            switch (command) {
                case "Add":
                        list.add(inputArgs[1]);
                        break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThat(inputArgs[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(inputArgs[1]),Integer.parseInt(inputArgs[2]));
                    break;
                case "Contains":
                    System.out.println(list.contains(inputArgs[1]));
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(inputArgs[1]));
                    break;
                case "Sort":
                    ListSorter.sort(list);
                    break;
                case "Print":
                    System.out.print(list.toString());
                    break;
            }
        }
    }
}
