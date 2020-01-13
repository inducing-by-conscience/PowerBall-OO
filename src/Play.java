import java.util.Arrays;
import java.util.Random;

public class Play {
    private int[] whiteballs = {0, 0, 0, 0, 0};
    private int powerball;

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
    public Play(){
        generatePlay();
    }

    private boolean isNotDuplicate(int whiteball, int currentNumberOfBalls){
        var result = true;
        for(int counter = 0 ; counter < currentNumberOfBalls; counter++){
            if(whiteball == whiteballs[counter])
                result = false;
        }
        return result;
    }
    public String toString(){
        var stringBuilder = new StringBuilder();
        stringBuilder.append("Whiteballs : ");
        stringBuilder.append(Arrays.toString(whiteballs));
        stringBuilder.append(" PowerBall: ");
        stringBuilder.append(powerball);
        return stringBuilder.toString();
    }
}
