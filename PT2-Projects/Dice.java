
/**
 * Write a description of class Dice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dice
{
    private DieN die1;
    private DieN die2;
    
    public Dice() {
        die1 = new DieN(6);
        die2 = new DieN(6);
    }
    
    public void roll() {
        die1.roll();
        die2.roll();
    }
    
    public int getValue() {
        return die1.getValue()+die2.getValue();
    }
    
    public int rollAndGetValue() {
        roll();
        return getValue();
    }
}
