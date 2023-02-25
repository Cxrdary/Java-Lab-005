/**
 *
 * @Author Cxrdary
 * @Version 1.0
 * I don't know what I did wrong, Learning this way is insanely hard for me, I search and search and I can't find a correction and have nobody to ask about it so I give up. I did all the code I just can't get it to run at all.
 *
 */

import java.util.Random;
import java.util.Scanner;

class Dice {
    private static int sideFacingUp;
    private static int sides;
    private static Random randomGenerator;

    public void Roll() {
        this.sideFacingUp = randomGenerator.nextInt(this.sides) + 1;
    }

    public int view() {
        return this.sideFacingUp;
    }

    public Dice(int sides) {
        this.sides = sides;
        this.randomGenerator = new Random();
    }

    public static class Player {
        private String name;
        private int score;

        public Player(String playerName) {
            name = playerName;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void toss(Dice die) {
            die.Roll();
            this.score += die.view();
        }
    }

    public static class Game {
        Player p1;
        Player p2;
        Dice die;
      public Game(Player p1, Player p2, Dice die) {
          this.p1 = p1;
          this.p2 = p2;
          this.die = die;
      }
        public String play() {
            Player current = this.p1;
            takeTurn(current);
            nextPlayer(current);
            takeTurn(current);
            return this.announceWinner();
        }


        public Player nextPlayer (Player current){
            if (current == this.p1) {
                current = this.p2;
            } else {
                current = this.p1;
            }
            return current;
        }

        public void takeTurn (Player player){
            player.toss(this.die);
        }

        public String announceWinner () {
            System.out.printf("%s scored %d\n", this.p1.getName(), this.p1.getScore());
            System.out.printf("%s scored %d\n", this.p2.getName(), this.p2.getScore());
            if (this.p1.getScore() > this.p2.getScore()) {
                return this.p1.getName();
            } else {
                return this.p2.getName();
            }

        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of sides: ");
            int sides = scanner.nextInt();
            Dice die = new Dice(sides);
            Player p1 = new Player("Player 1");
            Player p2 = new Player("Player 2");
            Game game = new Game(p1, p2, die);
            String winner = game.play();
            System.out.printf("%s wins!\n", winner);
            }
        }

