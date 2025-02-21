import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardCollection {
    private static Map<String, List<Card>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySuit();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Card Suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();
        System.out.print("Enter Card Rank (e.g., Ace, King, 10, 5): ");
        String rank = scanner.nextLine();

        Card newCard = new Card(suit, rank);
        cardMap.putIfAbsent(suit, new ArrayList<>());
        cardMap.get(suit).add(newCard);

        System.out.println("Card added successfully!");
    }

    private static void findCardsBySuit() {
        System.out.print("Enter Suit to find (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();

        if (cardMap.containsKey(suit)) {
            System.out.println("Cards in " + suit + ": " + cardMap.get(suit));
        } else {
            System.out.println("No cards found for the given suit.");
        }
    }

    private static void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
