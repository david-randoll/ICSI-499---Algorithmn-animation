package Shared;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataAccess {
    private static int[] data;
    private static String dataString;

    //this is for testing purposes until home can give us data
    public static void InitDefaultDataSet() {
        SetData(RandomData(15, 100));
        SetData(new int[]{5,50,52,3,70, 2, 7,46,4,8,436,8});
    }

    public static void SetData(int[] dataset) {
        data = dataset.clone();
        dataString = commaSeparateArray(data);
    }
    public static boolean SetData(String elements){
        final Pattern pattern = Pattern.compile("^([0-9]+\\s*,?\\s*)+$");
        Matcher matcher = pattern.matcher(elements);
        boolean isValid = matcher.matches();
        if(isValid == false || elements == ""){
            return false;
        }

        String[] arr = elements.split("[\\s]*[,][\\s]*");
        int[] dataSet = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            try{
                dataSet[i] = Integer.parseInt(arr[i]);
            }catch (Exception ex){
                return false;
            }

        }
        SetData(dataSet);
        return true;
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
        return data.clone();
    }

    public static String GetCommaSeparatedData() {
        return dataString;
    }

    public static int[] GetSortedData() {
        int[] tempData = data.clone();
        Arrays.sort(tempData);
        return tempData;
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
