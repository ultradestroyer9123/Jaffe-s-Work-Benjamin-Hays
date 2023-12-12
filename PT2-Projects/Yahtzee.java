import java.util.Random;

public class Yahtzee
{   
    private Die6 die1;
    private Die6 die2;
    private Die6 die3;
    private Die6 die4;
    private Die6 die5;

    public Yahtzee() {
        this.die1 = new Die6();
        this.die2 = new Die6();
        this.die3 = new Die6();
        this.die4 = new Die6();
        this.die5 = new Die6();
        roll();
    }
    
    public void roll() {
        this.die1.roll();
        this.die2.roll();
        this.die3.roll();
        this.die4.roll();
        this.die5.roll();
    }
    
    public void roll(int dieNumber) {
        if (dieNumber == 1) {
            this.die1.roll();
        } else if (dieNumber == 2) {
            this.die2.roll();
        } else if (dieNumber == 3) {
            this.die3.roll();
        } else if (dieNumber == 4) {
            this.die4.roll();
        } else if (dieNumber == 5) {
            this.die5.roll();
        }
    }
    
    public String summarize() {
        String summary = "";
        int[] dice = {this.die1.getValue(),
                    this.die2.getValue(),
                    this.die3.getValue(),
                    this.die4.getValue(),
                    this.die5.getValue()};
        for (int index = 0; index < 6; index++) {
            int count = 0;
            for(int value:dice){

        	if (value == index+1) { 
                    count++; 
                }
            }
            String ending = index+1 != 6?";":"";
            summary += Integer.toString(index+1) + "-" + Integer.toString(count) + ending;

        }
        return summary;
    }
    
    public String toString() {
        String strOfDice = "";
        int[] dice = {this.die1.getValue(),
                    this.die2.getValue(),
                    this.die3.getValue(),
                    this.die4.getValue(),
                    this.die5.getValue()};
        for (int values = 0; values < dice.length; values++) {
            strOfDice += Integer.toString(dice[values]) + " ";
        }
        return "Dice values: " + strOfDice.substring(0,strOfDice.length()-1);
    }
}




