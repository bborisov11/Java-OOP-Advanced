package cardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // List<Card> cards = new ArrayList<>();
       // String firstCardRank = reader.readLine();
       // String firstCardSuit = reader.readLine();
       // Card firstCard = new Card(firstCardRank, firstCardSuit);
       // String secondCardRank = reader.readLine();
       // String secondCardSuit = reader.readLine();
       // Card secondCard = new Card(secondCardRank, secondCardSuit);
       // cards.add(firstCard);
       // cards.add(secondCard);
       // cards.sort(Card.BY_VALUE);
       // System.out.println(cards.stream().findFirst().get());

      //  String annotation = reader.readLine();
//
      //  if(annotation.equals("Rank")) {
      //      Class rank = Ranks.class;
      //      EnumAnnotation enumRankAnnotation =
      //              (EnumAnnotation)rank.getAnnotation(EnumAnnotation.class);
      //      System.out.println(String.format(
      //              "Type = Enumeration, Description = Provides %s constants for a Card class."
      //      , enumRankAnnotation.category().toLowerCase()));
      //  } else if(annotation.equals("Suit")) {
      //      Class suit = Suits.class;
      //      EnumAnnotation enumSuitAnnotation =
      //              (EnumAnnotation)suit.getAnnotation(EnumAnnotation.class);
      //      System.out.println(String.format(
      //              "Type = Enumeration, Description = Provides %s constants for a Card class."
      //      ,enumSuitAnnotation.category().toLowerCase()));
      //  }

        for (Suits suits : Suits.values()) {
            for (Ranks ranks : Ranks.values()) {
                System.out.println(ranks + " of " + suits);
            }
        }
    }
}
