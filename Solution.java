import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        
        List<Long> miniMaxSum = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            long sum = 0, index = 0;
            for(Integer value: arr){
                if(i != index) {
                    sum = sum + value;
                }
                index ++;
            }
            miniMaxSum.add(sum);
        }
        Collections.sort(miniMaxSum);
        System.out.println(miniMaxSum.get(0) + " " + miniMaxSum.get(miniMaxSum.size() - 1));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
