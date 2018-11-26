package cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        List<String> givenCards = new ArrayList<>();
        String highestCardForFirstPlayer = "";
        int highestScoreForTheFirstPlayer = 0;
        String highestCardForSecondPlayer = "";
        int highestScoreForTheSecondPlayer = 0;
        int counter = 0;
        while (counter < 10) {
            String[] arg = reader.readLine().split(" ");
            if(Arrays.stream(Ranks.values()).anyMatch(x -> x.toString().equals(arg[0]))
                    && Arrays.stream(Suits.values())
                    .anyMatch(x -> x.toString().equals(arg[2]))) {
                if(!givenCards.contains(Arrays.toString(arg))) {
                    givenCards.add(Arrays.toString(arg));
                    int currentPower = Enum.valueOf(Ranks.class, arg[0])
                            .getValue() + Enum.valueOf(Suits.class, arg[2]).getValue();
                    if(counter <= 5) {
                        if(highestScoreForTheFirstPlayer < currentPower) {
                            highestScoreForTheFirstPlayer = currentPower;
                            highestCardForFirstPlayer = String.join(" ", arg);
                        }
                    }
                    else {
                        if(highestScoreForTheSecondPlayer < currentPower) {
                            highestScoreForTheSecondPlayer = currentPower;
                            highestCardForSecondPlayer = String.join(" ", arg);
                        }
                    }
                    counter++;
                } else {
                    System.out.println("Card is not in the deck.");
                }
            } else {
                System.out.println("No such card exists.");
            }
        }
        if(highestScoreForTheFirstPlayer > highestScoreForTheSecondPlayer) {
            System.out.println(String.format("%s wins with %s.",
                    firstName, highestCardForFirstPlayer));
        } else {
            System.out.println(String.format("%s wins with %s.",
                    secondName, highestCardForSecondPlayer));
        }

    }
}
