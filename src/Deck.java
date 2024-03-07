import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
  private List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    initializeDeck();
    shuffleDeck();
  }

  private void initializeDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(rank, suit));
      }
    }
  }

  private void shuffleDeck() {
    Collections.shuffle(cards);
  }

  public Card drawCard() {
    if (cards.isEmpty()) {
      throw new IllegalStateException("Deck is empty");
    }
    return cards.remove(0);
  }

  public List<Card> drawCards(int n) {
    if (cards.size() < n) {
      throw new IllegalStateException("Not enough cards in the deck");
    }
    List<Card> drawnCards = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      drawnCards.add(cards.remove(0));
    }
    return drawnCards;
  }

  public void sortByColor() {
    Collections.sort(cards, new Comparator<Card>() {
      @Override
      public int compare(Card card1, Card card2) {
        return card1.getSuit().compareTo(card2.getSuit());
      }
    });
  }

  public void sortByRank() {
    Collections.sort(cards, new Comparator<Card>() {
      @Override
      public int compare(Card card1, Card card2) {
        return card1.getRank().compareTo(card2.getRank());
      }
    });
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card.getRank()).append(" of ").append(card.getSuit()).append("\n");
    }
    return sb.toString();
  }
}