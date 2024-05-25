import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-12
 * Time: 22:03
 */
class AlgorithmicInformation {
    //Used to store Algorithmic Information
    public int Iteration;
    public int Phase;
    public String Algorithm;
    public long ElapsedTime;
    public int Evaluations;
    public int Improvements;

    /**
     * Constructs that cover all the information
     */
    public AlgorithmicInformation(int iteration, int phase, String algorithm, long elapsedTime, int evaluations, int improvements) {
        Iteration = iteration;
        Phase = phase;
        Algorithm = algorithm;
        ElapsedTime = elapsedTime;
        Evaluations = evaluations;
        Improvements = improvements;
    }

    /**
     * This constructor is used to generate summary information
     */
    public AlgorithmicInformation() {
        Iteration = -1;
        Phase = -1;
        Algorithm = "All";
    }

    @Override
    public int hashCode() {
        //Identifies the uniqueness of an object
        Integer integer1 = Iteration;
        Integer integer2 = Phase;
        return Algorithm.hashCode() | integer1.hashCode() | integer2.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // Checks whether the parameter object is the same reference as the current object
        if (this == obj) return true;

        //Checks whether the parameter object is null or belongs to a different class than the current object
        if (obj == null || getClass() != obj.getClass()) return false;

        //Converts the parameter object to the AlgorithmicInformation type
        AlgorithmicInformation other = (AlgorithmicInformation) obj;
        return Algorithm.equals(other.Algorithm) && Iteration == other.Iteration && Phase == other.Phase;
    }

    @Override
    public String toString() {
        //For printing
        return
                Iteration +
                        "," + Phase +
                        "," + Algorithm +
                        "," + ElapsedTime +
                        "," + Evaluations +
                        "," + Improvements;
    }

    public void update(AlgorithmicInformation newNode) {
        //Statistics for the same Algorithmic information in the same phrase
        this.ElapsedTime += newNode.ElapsedTime;
        this.Evaluations += newNode.Evaluations;
        this.Improvements += newNode.Improvements;
    }
}

public class PGP {
    /**
     * To enter information into the terminal, store the lines of the keywords "Iteration"," Phrase ", and "-" and return them as a Queue with a String
     *
     * @return Returns the Queue form of String
     */
    public static Queue<String> input() {
        Queue<String> queue = new ArrayDeque<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //Store lines with the keys "Iteration"," Phrase ", and "-" in action units
            String temp = scanner.nextLine();
            if (isValid(temp)) {
                queue.add(temp);
            }
        }
        scanner.close();
        return queue;
    }

    /**
     * Check whether keywords "Iteration"," Phrase ","-" are available.
     *
     * @param str
     */

    private static boolean isValid(String str) {
        return str.contains("Iteration") || str.contains("Phase") || str.contains("-");
    }

    /**
     * The queue containing the String is removed one by one, the different types of information are counted,
     * the AlgorithmicInformation object is constructed, and the queue is stored in another queue
     *
     * @param queue，A queue storing with a string
     * @return A queue that holds an AlgorithmicInformation object
     */
    public static Queue<AlgorithmicInformation> process(Queue<String> queue) {
        HashSet<AlgorithmicInformation> hashSet = new HashSet<>();//Used to determine whether an AlgorithmicInformation object has occurred
        Queue<AlgorithmicInformation> nodeQueue = new ArrayDeque<>();//Stores AlgorithmicInformation objects
        int iterationCounter = 0;
        int phaseCounter = 0;
        //According to the key lines, the key information is extracted and calculated
        while (!queue.isEmpty()) {
            String cur = queue.poll();//Top of the stack element, in units of behavior
            String[] splitCur = cur.split("\\s+");//An expression that determines one or more parentheses to separate a line separated by one or more Spaces
            if (cur.contains("Iteration")) {
                if (isStart(cur)) {
                    iterationCounter = Integer.valueOf(splitCur[1]);//According to the text information law, after the keyword "Iteration", the current Iteration is the next one
                }
                if (isEnd(cur)) {
                    iterationCounter = 0;//The current Iteration resets to zero to prevent future impacts
                }
            }
            if (cur.contains("Phase")) {
                if (isStart(cur)) {
                    phaseCounter = Integer.valueOf(splitCur[1].charAt(0) - 48);//In the Phase string, remove the number before the colon
                }
                if (isEnd(cur)) {
                    phaseCounter = 0;//The current Iteration resets to zero to prevent future impacts
                }
            }
            if (cur.contains("-") && (cur.toLowerCase().contains("ends"))) {
                //It's the key information for the algorithm
                AlgorithmicInformation newAlgorithmicInformation = createAlgorithmicInformation(iterationCounter, phaseCounter, splitCur, cur);
                //Find out if it has appeared
                if (hashSet.contains(newAlgorithmicInformation)) {
                    Iterator<AlgorithmicInformation> iterator = hashSet.iterator();
                    while (iterator.hasNext()) {
                        //Iterate to find the current object
                        AlgorithmicInformation curAlgorithmicInformation = iterator.next();
                        if (curAlgorithmicInformation.equals(newAlgorithmicInformation)) {
                            //refresh data
                            curAlgorithmicInformation.update(newAlgorithmicInformation);
                        }
                    }
                } else {
                    //Never appear
                    hashSet.add(newAlgorithmicInformation);
                    nodeQueue.add(newAlgorithmicInformation);
                }

            }
        }
        return nodeQueue;
    }

    /**
     * Determine it is "Starts" which are not case-sensitive
     *
     * @param str
     */
    private static boolean isStart(String str) {
        return str.toLowerCase().contains("starts");
    }

    /**
     * Determine it is "ends" which are not case-sensitive
     */
    private static boolean isEnd(String str) {
        return str.toLowerCase().contains("ends");
    }

    /**
     * Based on the current iterationCounter, phaseCounter, and segmented string, extract the information and construct the node
     *
     * @param iterationCounter Current iteration number
     * @param phaseCounter     Current phase number
     * @param splitCur         The segmented string
     * @return An AlgorithmicInformation object with information
     */

    public static AlgorithmicInformation createAlgorithmicInformation(int iterationCounter, int phaseCounter, String[] splitCur, String curString) {
        int elapsedTime = 0;
        int evaluation = 0;
        int improvement = 0;
        int i = 0;
        String algorithm = getAlgorithm(curString);
        while (i < splitCur.length) {
            //Find the corresponding information and store it
            if (splitCur[i].compareTo("Elapsed") == 0) {
                elapsedTime = Integer.valueOf(splitCur[i + 3]);
            }
            if (splitCur[i].compareTo("Evaluations:") == 0) {
                evaluation = Integer.valueOf(splitCur[i + 1]);
            }
            if (splitCur[i].compareTo("Improvements:") == 0) {
                improvement = Integer.valueOf(splitCur[i + 1]);
            }
            i++;
        }
        //Synthesize the obtained information
        AlgorithmicInformation newAlgorithmicInformation = new AlgorithmicInformation(iterationCounter, phaseCounter, algorithm, elapsedTime, evaluation, improvement);
        return newAlgorithmicInformation;
    }

    /**
     * Iterate over the key lines to get the algorithm name in a way that preserves multiple Spaces in the algorithm name
     * @param input Key line
     * @return Algorithm name
     */
    private static String getAlgorithm(String input) {
        // Find the end position of the first tag and the start position of the second tag
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
        return result;
    }

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        Queue<String> queue = input();
        Queue<AlgorithmicInformation> informationQueue = process(queue);
        System.out.println("Iteration,Phase,Algorithm,Elapsed Time (ms),Evaluations,Improvements");
        AlgorithmicInformation all = new AlgorithmicInformation();
        while (!informationQueue.isEmpty()) {
            AlgorithmicInformation curInformation = informationQueue.poll();
            System.out.println(curInformation);
            all.update(curInformation);
        }
        System.out.println(all);
        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
    }
}
