import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Player> players;
    private Deck deck;
    private List<Card> playedCardsDeck;

    public Table() {
        players = new ArrayList<>();
        deck = new Deck();
        playedCardsDeck = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (players.size() >= 9) {
            throw new IllegalStateException("Table is full");
        }
        players.add(player);
    }

    public void giveCard(Player player) {
        Card card = deck.drawCard();
        player.receiveCard(card);
    }

    public void receiveCard(Player player, Card card) {
        player.giveCard(card);
        playedCardsDeck.add(card);
    }

    public void printPlayedCards() {
      System.out.println("Played cards:");
      for (Card card : playedCardsDeck) {
          System.out.println(card.getRank() + " of " + card.getSuit());
      }
  }

}