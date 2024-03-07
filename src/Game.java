import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private List<Table> tables;

    public Game() {
        tables = new ArrayList<>();
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public void printTables() {
        if (tables.isEmpty()) {
            System.out.println("No tables to print.");
        } else {
            System.out.println("Tables:");
            for (Table table : tables) {
                System.out.println(table);
            }
        }
    }

    public void printCards(List<Card> cards) {
      if (cards.isEmpty()) {
          System.out.println("No cards to print.");
      } else {
          System.out.println("Cards:");
          for (Card card : cards) {
              System.out.println(card.getRank() + " of " + card.getSuit());
          }
      }
  }

   public HandRank evaluateHand(List<Card> cards) {
        if (cards.size() != 5) {
            return null;
        }

        // Sort the cards by rank
        cards.sort(Comparator.comparing(Card::getRank));

        // Check for a flush (all cards the same suit)
        boolean isFlush = cards.stream().allMatch(card -> card.getSuit() == cards.get(0).getSuit());

        // Check for a straight (all cards in sequence)
        boolean isStraight = IntStream.range(0, cards.size() - 1)
            .allMatch(i -> cards.get(i).getRank().ordinal() + 1 == cards.get(i + 1).getRank().ordinal());

        // Count occurrences of each rank
        Map<Rank, Long> rankCounts = cards.stream()
            .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));

        // Check for four of a kind, three of a kind, and pairs
        boolean isFourOfAKind = rankCounts.values().contains(4L);
        boolean isThreeOfAKind = rankCounts.values().contains(3L);
        boolean isPair = rankCounts.values().contains(2L);

        // Determine the type of hand
        if (isFlush && isStraight && cards.get(4).getRank() == Rank.ACE) {
          return HandRank.ROYAL_FLUSH;
      } else if (isFlush && isStraight) {
          return HandRank.STRAIGHT_FLUSH;
      } else if (isFourOfAKind) {
          return HandRank.FOUR_OF_A_KIND;
      } else if (isThreeOfAKind && isPair) {
          return HandRank.FULL_HOUSE;
      } else if (isFlush) {
          return HandRank.FLUSH;
      } else if (isStraight) {
          return HandRank.STRAIGHT;
      } else if (isThreeOfAKind) {
          return HandRank.THREE_OF_A_KIND;
      } else if (rankCounts.values().stream().filter(count -> count == 2).count() == 2) {
          return HandRank.TWO_PAIR;
      } else if (isPair) {
          return HandRank.ONE_PAIR;
      } else {
          return HandRank.HIGH_CARD;
      }
    }

    public void win(List<Player> players) {
      Player bestPlayer = null;
      HandRank bestRank = null;

      for (Player player : players) {
          HandRank playerRank = evaluateHand(player.getMain());
          if (bestRank == null || playerRank.ordinal() > bestRank.ordinal()) {
              bestPlayer = player;
              bestRank = playerRank;
          }
      }

      int winnerIndex = players.indexOf(bestPlayer);
      System.out.println("The winner is: Player " + (winnerIndex + 1));
      System.out.println("Winning rank: " + bestRank);
      System.out.println("Winning hand: \n" + bestPlayer);
  }
    public static void main(String[] args) {
        Game game = new Game();
        Table table = new Table();
        game.addTable(table);
        game.printTables();
        game.removeTable(table);
        game.printTables();
    }

    public enum HandRank {
      HIGH_CARD,
      ONE_PAIR,
      TWO_PAIR,
      THREE_OF_A_KIND,
      STRAIGHT,
      FLUSH,
      FULL_HOUSE,
      FOUR_OF_A_KIND,
      STRAIGHT_FLUSH,
      ROYAL_FLUSH
  }
}