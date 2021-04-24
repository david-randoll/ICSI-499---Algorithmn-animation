package Shared;

import java.util.Arrays;
import java.util.Random;

public class DataAccess {
    private int[] data;
    private int SEARCH_VALUE;

    //this is for testing purposes until home can give us data
    public DataAccess() {
        this.data = new int[] {5,2,7,3,5};
        this.data = RandomData(15,100);
        this.SEARCH_VALUE = 30;
    }
    public void SetData(int[] data){
        this.data = data;
    }

    public int[] GetData(){
        return data;
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
