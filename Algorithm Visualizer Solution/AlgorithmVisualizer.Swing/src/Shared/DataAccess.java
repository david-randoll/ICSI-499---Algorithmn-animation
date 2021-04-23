package Shared;

import java.util.Random;

public class DataAccess {
    private int[] data;

    //this is for testing purposes until home can give us data
    public DataAccess() {
        this.data = new int[] {5,2,7,3,5};
//        this.data = RandomData(5,100);
    }

    public int[] GetData(){
        return data;
    }

    public void SetData(int[] data){
        this.data = data;
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
