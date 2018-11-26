package cardSuit;


public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        for (Suits suits : Suits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s",suits.ordinal(), suits.name());
            System.out.println();
        }
    }
}
