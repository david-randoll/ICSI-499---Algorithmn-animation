package Models;

public class HomeModel {
    private int[] inputtedElementsList;

    public int[] getInputtedElementsList() {
        return inputtedElementsList;
    }

    public void setInputtedElementsList(String elements) {
        String[] arr = elements.split(",");
        int[] data = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = Integer.parseInt(arr[i]);
        }
        this.inputtedElementsList = data;
    }
}
