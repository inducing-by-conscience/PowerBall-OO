package Terminal;
import java.util.Arrays;
import java.util.Random;

/**
 * @author jinjiantan
 * @version 0.1.0
 */
public class Play {
    private int[] whiteballs = {0, 0, 0, 0, 0};
    private int powerball;

    /**
     * Generate one play with five whiteballs and one powerball
     */
    private void generatePlay(){
        Random generator = new Random();
        int counter = 0;
        while(counter < 5){
            var aBall = generator.nextInt(69) + 1;
            if(isNotDuplicate(aBall,counter)){
                whiteballs[counter] = aBall;
                counter++;
            }
        }
        Arrays.sort(whiteballs);
        powerball = generator.nextInt(26) + 1;
    }

    /**
     * default constructor
     */
    public Play(){
        generatePlay();
    }

    /**
     *The function to check whether the ball is already in the play
     * @param whiteball the number to check whether it is duplicate
     * @param currentNumberOfBalls the number of the balls already pick
     * @return true for not duplicate, false for duplicate.
     */
    private boolean isNotDuplicate(int whiteball, int currentNumberOfBalls){
        var result = true;
        for(int counter = 0 ; counter < currentNumberOfBalls; counter++){
            if(whiteball == whiteballs[counter])
                result = false;
        }
        return result;
    }

    /**
     * toString method
     * @return the string to represent the play.
     */
    public String toString(){
        var stringBuilder = new StringBuilder();
        stringBuilder.append("Whiteballs : ");
        stringBuilder.append(Arrays.toString(whiteballs));
        stringBuilder.append(" PowerBall: ");
        stringBuilder.append(powerball);
        return stringBuilder.toString();
    }
}
