import java.util.Random;

public class Yahtzee
{   
    private int[] dices;
    
    public Yahtzee() {
        this.dices = new int[]{-1,-1,-1,-1,-1};
    }
    
    public void roll() {
        for (int die = 0; die < this.dices.length; die++) {
            dices[die] = new Random().nextInt(6) + 1;
        }
    }
    
    public void roll(int dieNumber) {
        if (!(dieNumber < 1 || dieNumber > 5)) {
            this.dices[dieNumber] = new Random().nextInt(6) + 1;
        }
    }
    
    public String summarize() {
        String summary = "";
        for (int die = 0; die < 6; die++) {
            int instanceCount = 0;
            for (int count = 0; count < this.dices.length; count++) {
                instanceCount += die==this.dices[count]?1:0;
            }
            summary += Integer.toString(die+1) + "-" + Integer.toString(instanceCount) + (die!=5?"; ":"");
        }
        return summary;
    }
    
    public String toString() {
        String strOfDice = "";
        for (int values = 0; values < this.dices.length; values++) {
            strOfDice += Integer.toString(this.dices[values]) + " ";
        }
        return "Dice values: " + strOfDice;
    }
}




