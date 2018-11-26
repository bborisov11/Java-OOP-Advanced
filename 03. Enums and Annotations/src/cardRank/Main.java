package cardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        for (Suits ranks : Suits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s",ranks.ordinal(), ranks.name());
            System.out.println();
        }
    }
}
