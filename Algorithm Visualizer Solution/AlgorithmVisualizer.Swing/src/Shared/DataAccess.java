package Shared;

import java.util.Arrays;
import java.util.Random;

public class DataAccess {
    private static int[] data;
    private static String dataString;

    //this is for testing purposes until home can give us data
    public static void Run() {
        SetData(RandomData(15, 100));
        SetData(new int[]{5,50,52,3,70, 2, 7,46,4,8,436,8});
    }

    public static void SetData(int[] dataset) {
        data = dataset;
        dataString = commaSeparateArray(data);
    }

    private static String commaSeparateArray(int[] data) {
        StringBuilder result = new StringBuilder();

        String SEPARATOR = "";
        for (int i = 0; i < data.length; i++) {
            // Some processing
            result.append(SEPARATOR);
            result.append(data[i]);
            SEPARATOR = ",";
        }
        return result.toString();

    }

    public static int[] GetData() {
        return data;
    }

    public static String GetCommaSeparatedData() {
        return dataString;
    }

    public static int[] GetSortedData() {
        int[] temp = data.clone();
        Arrays.sort(temp);
        return temp;
    }

    private static int[] RandomData(int inputSize, int upperBound) {
        Random rand = new Random();
        int[] output = new int[inputSize];
        for (int i = 0; i < output.length; i++) {
            output[i] = rand.nextInt(upperBound);
        }
        return output;
    }
}
