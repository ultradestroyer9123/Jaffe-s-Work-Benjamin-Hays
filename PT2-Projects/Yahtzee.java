import java.util.Random;

public class Yahtzee
{
    int[] dices = new int[]{-1,-1,-1,-1,-1};
    
    public int randDieVal() {
        return new Random().nextInt(6) + 1;
    }
    
    public void rollAll() {
        for (int die = 0; die < 5; die++) {
            dices[die] = randDieVal();
        }
    }
    
    public void rollSpecific(int diePos) {
        dices[diePos] = randDieVal();
    }
    
    public String summarize() {
        String summary = "";
        for (int die = 0; die < 5; die++) {
            int instanceCount = 0;
            for (int countingDie = 0; countingDie < dices.length; countingDie++) {
                if (countingDie == die) {
                    instanceCount += 1;
                }
            }
            summary += Integer.toString(die+1) + ": " + Integer.toString(instanceCount) + "; ";
        }
        return summary;
    }
    
    public String toString() {
        String strOfDice = "";
        for (int values = 0; values < dices.length; values++) {
            strOfDice += Integer.toString(dices[values]);
        }
        return "Dice values: " + strOfDice;
    }
}




