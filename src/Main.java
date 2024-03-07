import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    // Create a game, a table, and players
    Game game = new Game();
    Table table = new Table();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();

    // Add the table to the game
    game.addTable(table);

    // Add players to the table
    table.addPlayer(player1);
    table.addPlayer(player2);
    table.addPlayer(player3);

    // Give each player a full hand
    for (int i = 0; i < 5; i++) {
      table.giveCard(player1);
      table.giveCard(player2);
      table.giveCard(player3);
    }

    // Print "Turn one" and the hands of each player
    System.out.println("Turn one");
    player1.orderCards();
    player2.orderCards();
    player3.orderCards();

    System.out.println("Player 1: " + "\n" + player1 );
    System.out.println("Player 2: " + "\n" + player2 );
    System.out.println("Player 3: " + "\n" + player3 );

    // Players exchange cards
    player1.giveCard(player1.getMain().get(0));
    table.giveCard(player1);
    player2.giveCard(player2.getMain().get(0));
    player2.giveCard(player2.getMain().get(1));
    table.giveCard(player2);
    table.giveCard(player2);
    player3.giveCard(player3.getMain().get(0));
    player3.giveCard(player3.getMain().get(1));
    player3.giveCard(player3.getMain().get(2));
    table.giveCard(player3);
    table.giveCard(player3);
    table.giveCard(player3);

    System.out.println("Turn Two");
    player1.orderCards();
    player2.orderCards();
    player3.orderCards();

    System.out.println("Player 1: " + "\n" + player1 );
    System.out.println("Player 2: " + "\n" + player2 );
    System.out.println("Player 3: " + "\n" + player3 );

    // Players exchange cards
    player1.giveCard(player1.getMain().get(0));
    table.giveCard(player1);
    player2.giveCard(player2.getMain().get(0));
    player2.giveCard(player2.getMain().get(1));
    table.giveCard(player2);
    table.giveCard(player2);
    player3.giveCard(player3.getMain().get(0));
    player3.giveCard(player3.getMain().get(1));
    player3.giveCard(player3.getMain().get(2));
    table.giveCard(player3);
    table.giveCard(player3);
    table.giveCard(player3);

    System.out.println("Gane over");
    player1.orderCards();
    player2.orderCards();
    player3.orderCards();

    System.out.println("Player 1: " + "\n" + player1 );
    System.out.println("Player 2: " + "\n" + player2 );
    System.out.println("Player 3: " + "\n" + player3 );

    game.win(Arrays.asList(player1, player2, player3));
  }
}