import java.io.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String  pm_am = s.substring(s.length() - 2),
                hour = s.substring(0,2),
                timeConvertion = "";
        int     intHour;
        
        if(pm_am.equalsIgnoreCase("AM")) {
            if(hour.equals("12")) {
                timeConvertion = "00" + s.substring(2, s.length() - 2);
            } else {
                timeConvertion = hour + s.substring(2, s.length() - 2);
            }
        } else {
            intHour = Integer.parseInt(hour);
            if(intHour >= 12) {
                timeConvertion = s.substring(0, s.length() - 2);
            } else {
                intHour = intHour + 12;
                timeConvertion = String.valueOf(intHour) + s.substring(2, s.length() - 2);
            }
        }
        
        return timeConvertion;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
