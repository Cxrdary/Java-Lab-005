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
    private int sideFacingUp;
    private int sides;
    private Random randomGenerator;
    Dice d1 = new Dice(6);
    Dice d2 = new Dice(20);

    public void Roll(int side) {
        sideFacingUp = randomGenerator.nextInt(1, sides);
    }

    public void view() {
        System.out.println(sideFacingUp);
    }

    public Dice(int sides) {
        this.sides = sides;
    }

    class Player {
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
            Roll(die.sides);
            score = sideFacingUp;
        }
    }

    public class Game {
        Player p1;
        Player p2;
        Dice die;
      public Game(Player pa1, Player pa2, Dice daie) {
          p1 = pa1;
          p2 = pa2;
          die = daie;
      }
        public void play() {
            Player current = this.p1;
            takeTurn(current);
            nextPlayer(current);
            takeTurn(current);
            announceWinner();
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
            int p1score = p2.getScore();
            int p2score = p1.getScore();
            System.out.println("Player 1 had a score of " + p1score);
            System.out.println("Player 2 had a score of " + p2score);
            if (p1score > p2score) {
                System.out.println("This means that player 1 is our winner!");
            } else if (p2score > p1score) {
                System.out.println("This means that player 2 is our winner!");
            } else {
                System.out.println("it looks like we have a tie!");
            }
            return null;
        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many sides should the die have?");
            int diceSides = scanner.nextInt();
            Dice gameDie = new Dice(diceSides);
            Player p1;
            Player p2;
            Game(p1, p2, gameDie);
            play();

            }
        }

