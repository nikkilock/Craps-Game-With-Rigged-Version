// Author Nikki Lockwood

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Craps {

    private final ArrayList<Integer> winList = new ArrayList<>(Arrays.asList(7, 11));
    private final ArrayList<Integer> loseList = new ArrayList<>(Arrays.asList(2, 3, 12));
    private int roll = 1;

    public Craps() {
        System.out.println("Welcome to Craps");
    }

    public void play(int type) {
        if (type == 0) {
            playNotRigged();
        } else {
            playRigged();
        }
    }

    private void playNotRigged() {
        Random rand = new Random();
        int a = rand.nextInt(6) + 1;
        int b = rand.nextInt(6) + 1;
        int sum = a + b;
        System.out.println("Your roll is: " + sum);
        if (this.winList.contains(sum)) {
            System.out.println("You have won!");
        } else if (this.loseList.contains(sum)) {
            System.out.println("You have lost!");
        } else {
            if (this.roll == 1) {
                this.winList.clear();
                this.loseList.clear();
                this.winList.add(sum);
                this.loseList.add(7);
            }
            this.roll++;
            playNotRigged();
        }
    }

    private void playRigged() {
        Random rand = new Random();
        int a = rand.nextInt(10) + 1;
        int b = rand.nextInt(10) + 1;
        if (a <= 5) {
            a = 1;
        } else {
            a -= 4;
        }
        if (b <= 5) {
            b = 1;
        } else {
            b -= 4;
        }
        int sum = a + b;
        System.out.println("Your roll is: " + sum);
        if (this.winList.contains(sum)) {
            System.out.println("You have won!");
        } else if (this.loseList.contains(sum)) {
            System.out.println("You have lost!");
        } else {
            if (this.roll == 1) {
                this.winList.clear();
                this.loseList.clear();
                this.winList.add(sum);
                this.loseList.add(7);
            }
            this.roll++;
            playRigged();
        }
    }

    public static void main(String[] args) {
        Craps crap = new Craps();
        crap.play(1);
    }
}


