/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-04-06
 * Time: 21:53
 */
public class test {
    public static void main(String[] args) {
        String input = "-- 你好       吗 Ends Time 14:16:56 Elapsed Time (ms): 40 Evaluations: 3081 Improvements: 0";
        String startTag = "";
        if (input.startsWith("--")) {
            startTag = "--";
        } else if (input.startsWith("-")) {
            startTag = "-";
        }

        String endTag = " ends";

        // Convert both input string and tags to lowercase for case-insensitive comparison
        String lowercaseInput = input.toLowerCase();

        int startIndex = lowercaseInput.indexOf(startTag) + startTag.length();
        int endIndex = lowercaseInput.indexOf(endTag);


        String result = input.substring(startIndex, endIndex).trim(); // Remove leading and trailing spaces
        System.out.println(result);
    }
}
