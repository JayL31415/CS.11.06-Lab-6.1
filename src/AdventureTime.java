import java.io.*;
import java.util.Scanner;

public class AdventureTime {




    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {

            int result = challengeOne("inputOneTwo.txt");
            System.out.println("Result: " + result);
            int result2 = challengeTwo("inputOneTwo.txt");
            System.out.println("Result: " + result2);
            int result3 = challengeThree("inputThreeFour.txt");
            System.out.println("Result: " + result3);
            int result4 = challengeFour("inputThreeFour.txt");
            System.out.println("Result: " + result4);
            writeFileAllAnswers("Answers",result,result2,result3,result4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */

    public static int challengeOne(String fileName) throws IOException {
        int[] fileContents = readFile(fileName);
        int highercounter=0;

        for (int i = 0; i < fileContents.length-1; i++ ){
            if (fileContents[i] < fileContents[i+1]) {
                highercounter++;
            }
        }
        return highercounter;
    }


    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] fileContents = readFile(fileName);

        int higherCounter2 = 0;

        for (int i = 3; i < fileContents.length; i++) {
            int currentSum = fileContents[i] + fileContents[i-1] + fileContents[i-2];
            int previousSum = fileContents[i-1] + fileContents[i-2] + fileContents[i-3];

            if (currentSum > previousSum) {
                higherCounter2++;
            }
        }

        return higherCounter2;
    }



    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName2
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName2) throws FileNotFoundException {
        String[] fileContents = readTextFile(fileName2);
        int horipos = 0;
        int depth = 0;

        for (int i = 0; i < fileContents.length; i++) {
            if (fileContents[i].contains("forward")) {
                int horivalue = Integer.parseInt(fileContents[i].split(" ")[1]);
                horipos += horivalue;
            }
            if (fileContents[i].contains("up")) {
                int depthvalue1 = Integer.parseInt(fileContents[i].split(" ")[1]);
                depth -= depthvalue1;
            }
            if (fileContents[i].contains("down")) {
                int depthvalue2 = Integer.parseInt(fileContents[i].split(" ")[1]);
                depth += depthvalue2;
            }
        }
        return depth*horipos;


    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName2
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName2) throws FileNotFoundException {
        String[] fileContents = readTextFile(fileName2);
        int horipos = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < fileContents.length; i++) {
            if (fileContents[i].contains("forward")) {
                int horivalue = Integer.parseInt(fileContents[i].split(" ")[1]);
                horipos += horivalue;
                depth += aim * horivalue;
            }
            if (fileContents[i].contains("up")) {
                int depthvalue1 = Integer.parseInt(fileContents[i].split(" ")[1]);
                aim -= depthvalue1;
            }
            if (fileContents[i].contains("down")) {
                int depthvalue2 = Integer.parseInt(fileContents[i].split(" ")[1]);
                aim += depthvalue2;
            }
        }
        return depth * horipos;
    }






    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }



    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
    private static String[] readTextFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

}