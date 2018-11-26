package cardsWithPower;

import java.util.Comparator;
public class Card {
    private Ranks rank;
    private Suits suit;
    private int cardPower;
    public final static Comparator<Card> BY_VALUE = compareByValue();

    private static Comparator<Card> compareByValue() {
        return (r1, r2) -> r2.cardPower - r1.cardPower;
    }

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(Ranks.class, rank);
        this.suit = Enum.valueOf(Suits.class, suit);
        this.cardPower = this.rank.getValue() + this.suit.getValue();
    }

    @Override
    public String toString() {
        return "Card name: " + this.rank.name() + " of " + this.suit.name()+"; " +
                "Card power: " + (this.rank.getValue() + this.suit.getValue());
    }
}
