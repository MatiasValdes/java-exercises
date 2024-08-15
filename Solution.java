import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(int candlesCount, List<Integer> candles) {
        
        int candlesQuantity = 0;
        
        if(candles.isEmpty()){
            return candlesQuantity;
        }
        
        Collections.sort(candles);
        Collections.reverse(candles);
        candlesCount = (candles.get(0) > candlesCount ||candles.get(0) < candlesCount) ? candles.get(0) : candlesCount;
        
        for(Integer candle: candles) {
            if(candlesCount == candle) {
                candlesQuantity++;
            }
        }
        
        return candlesQuantity;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.birthdayCakeCandles(candlesCount, candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
