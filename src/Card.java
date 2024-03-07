public class Card {
  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
      this.rank = rank;
      this.suit = suit;
  }

    public Rank getRank() {
      return rank;
    }

    public void setRank(Rank rank) {
      this.rank = rank;
    }

    public Suit getSuit() {
      return suit;
    }

    public void setSuit(Suit suit) {
      this.suit = suit;
    }
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}
