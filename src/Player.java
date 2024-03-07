import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Player {
  private List<Card> Main;

  public Player() {
    Main = new ArrayList<>();
  }

  public void drawMain(Deck deck) {
    if (Main.size() > 5) {
      throw new IllegalStateException("can't draw more than 5 cards");
    }
    Main = deck.drawCards(5);
  }

  public List<Card> getMain() {
    return Main;
  }

  public void receiveCard(Card card) {
    if (Main.size() > 5) {
      throw new IllegalStateException("can't receive more than 5 cards");
    }
    Main.add(card);
  }

  public Card giveCard(Card card) {
    Main.remove(card);
    return card;
  }

    public void orderCards() {
    Main.sort(Comparator.comparing(Card::getRank));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : Main) {
      sb.append(card.getRank()).append(" of ").append(card.getSuit()).append("\n");
    }
    return sb.toString();
  }
}