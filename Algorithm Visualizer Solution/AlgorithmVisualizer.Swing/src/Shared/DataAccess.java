package Shared;

import java.util.Arrays;
import java.util.Random;

public class DataAccess {
    private int[] data;
    private int SEARCH_VALUE;
    private String dataString;

    //this is for testing purposes until home can give us data
    public DataAccess() {
        SetData(new int[] {5,2,7,3,5});
        SetData(RandomData(15,100));
        this.SEARCH_VALUE = 30;
    }
    public void SetData(int[] data){
        this.data = data;
        this.dataString = commaSeparateArray(data);
    }
    private String commaSeparateArray(int [] data){
        StringBuilder result = new StringBuilder();

        String SEPARATOR = "";
        for(int i=0;i<data.length;i++)
        {
            // Some processing
            result.append(SEPARATOR);
            result.append(data[i]);
            SEPARATOR = ",";
        }
        return result.toString();

    }

    public int[] GetData(){
        return data;
    }

    public String GetCommaSeparatedData(){
        return dataString;
    }

    public int GetSearchValue(){
        return SEARCH_VALUE;
    }

    public int[] GetSortedData(){
        int[] temp = data;
        Arrays.sort(data);

        return temp;
    }

    private static int[] RandomData(int inputSize, int upperBound){
        Random rand = new Random();
        int[] output = new int[inputSize];
        for(int i = 0; i < output.length; i++){
            output[i] = rand.nextInt(upperBound);
        }
        return output;
    }
}
