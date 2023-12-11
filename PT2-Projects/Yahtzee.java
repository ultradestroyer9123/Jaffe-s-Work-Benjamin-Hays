import java.util.Random;

public class Yahtzee
{   
    private Die6[] dice;
    
    public Yahtzee() {
        this.dice = {
            new Die6(),
            new Die6(),
            new Die6(),
            new Die6(),
            new Die6(),
        };
    }
    
    public void roll() {
        for (int i = 0; i < this.dice.length; i++) {
            this.dice[i].roll();
        }
    }
    
    public void roll(int dieNumber) {
        dice[dieNumber].roll();        
    }
    
    public String summarize() {
        String summary = "";
        for (int die = 0; die < 6; die++) {
            int instanceCount = 0;
            for (int count = 0; count < this.dice.length; count++) {
                instanceCount += die==this.dice[count].getValue()?1:0;
            }
            summary += Integer.toString(die+1) + "-" + Integer.toString(instanceCount) + (die!=5?"; ":"");
        }
        return summary;
    }
    
    public String toString() {
        String strOfDice = "";
        for (int values = 0; values < this.dice.length; values++) {
            strOfDice += Integer.toString(this.dice[values].getValue()) + " ";
        }
        return "Dice values: " + strOfDice;
    }
}




