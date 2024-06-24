import java.util.*;
public class DeckOfCards {
    public static void main(String[] args) {
        // Define arrays for suits and ranks of cards
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Create an array to hold all cards in the deck
        String[] deck = new String[52];

        // Fill the deck with cards by combining suits and ranks
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Shuffle the deck using the Fisher-Yates algorithm
        shuffleDeck(deck);

        // Create players and assign them cards
        Player[] players1 = new Player[4];
        for (int i = 0; i < players1.length; i++) {
            players1[i] = new Player("Player " + (i + 1));
            for (int j = 0; j < 9; j++) {
                players1[i].receiveCard(deck[i * 9 + j]);
            }
            players1[i].sortCardsByRank();
        }

        // Arrange players in a queue
        Queue<Player> playerQueue = new LinkedList<>();
        for (Player player : players1) {
            playerQueue.offer(player);
        }

        // Print the player and the cards received by each player
        while (!playerQueue.isEmpty()) {
            Player player = playerQueue.poll();
            System.out.println(player.getName() + " cards:");
            player.printCards();
            System.out.println();
        }
    }

    // Method to shuffle the deck using the Fisher-Yates algorithm
    private static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap deck[i] and deck[j]
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
}
class Player {
    private String name;
    private Queue<String> cards;

    public Player(String name) {
        this.name = name;
        cards = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void receiveCard(String card) {
        cards.offer(card);
    }

    public void sortCardsByRank() {
        List<String> sortedCards = new ArrayList<>(cards);
        sortedCards.sort(Comparator.comparing(this::getRankValue));
        cards.clear();
        cards.addAll(sortedCards);
    }

    private int getRankValue(String card) {
        String rank = card.split(" ")[0];
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "Jack": return 11;
            case "Queen": return 12;
            case "King": return 13;
            case "Ace": return 14;
            default: return 0; // Should not happen
        }
    }

    public void printCards() {
        for (String card : cards) {
            System.out.println(card);
        }
    }
}
