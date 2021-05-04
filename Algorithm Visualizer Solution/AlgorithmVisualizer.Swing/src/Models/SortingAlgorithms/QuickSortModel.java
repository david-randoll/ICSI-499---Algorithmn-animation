package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortModel extends SorterModel implements IGeneratePanel {

    String TITLE = "Quick Sort";
    ArrayList<Integer> sortedIndexList = new ArrayList<>();

    public QuickSortModel() {
        super();
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = runClone(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                Integer[] indices = {j, j + 1};

                ArrayList<Integer> list = new ArrayList<>();

                for (int index = arr.length - i ; index < arr.length; index++) {
                    list.add(index);
                }
                Integer[] sortedIndices = new Integer[list.size()];
                sortedIndices = list.toArray(sortedIndices);

                Panel newPanel = new Panel(TITLE, arr, sortedIndices , indices, "Is "+arr[j]+" greater than "+arr[j+1]+"?");
                output.add(newPanel);


                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Integer[] swapIndices = {j + 1, j};
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    Panel swapPanel = new Panel(TITLE, arr, sortedIndices, swapIndices, "Yes, so we swap!");
                    output.add(swapPanel);
                }else {
                    Panel noSwapPanel = new Panel(TITLE, arr, sortedIndices , indices, "Nope");
                    output.add(noSwapPanel);
                }
            }
        }

        Integer[] sortedIndices = new Integer[arr.length];
        for(int i =0; i < sortedIndices.length;i++){
            sortedIndices[i] = i;
        }

        Panel lastPanel = new Panel(TITLE, arr, sortedIndices,null, "Sorted");
        output.add(lastPanel);

        return output;
    }

    public ArrayList<Panel> runClone(int arr[]) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        sort(arr,0,arr.length - 1,output);

        Integer[] sortedIndices = new Integer[arr.length];
        for(int i =0; i < sortedIndices.length;i++){
            sortedIndices[i] = i;
        }
        Panel lastPanel = new Panel(TITLE, arr, sortedIndices,null, "Sorted");
        output.add(lastPanel);

        return output;
    }

    private void sort(int[] array,int start, int end,ArrayList<Panel> output){
        if(start >= end) return;

        var boundary = partition(array,start,end,output);

        sort(array,start,boundary-1,output);
        sort(array,boundary+1,end,output);

    }
    private int partition(int[] array,int start, int end,ArrayList<Panel> output){
        int pivot = array[end];
        int boundary = start - 1;

        Panel newPanel = new Panel(TITLE, array, sortedIndexList.toArray(new Integer[]{}) , new Integer[]{start-1, end,end}, "pivot: "+pivot +", boundary index: "+boundary);
        output.add(newPanel);

        for (var i = start; i <= end; i++){
            Panel partPanel = new Panel(TITLE, array, sortedIndexList.toArray(new Integer[]{}) , new Integer[]{i,boundary,end}, "Is "+array[i]+" <= pivot: "+pivot+"?");
            output.add(partPanel);
            if(array[i] <= pivot){
                boundary++;
                //telling the user we need to increment the boundary
                Panel beforeSwapPanel = new Panel(TITLE, array, sortedIndexList.toArray(new Integer[]{}) , new Integer[]{i,boundary,end}, "Increment boundary (index: "+boundary+")");
                output.add(beforeSwapPanel);

                if(i == end){
                    sortedIndexList.add(boundary);
                }
                swap(array, i, boundary);
                Panel swapPanel = new Panel(TITLE, array, sortedIndexList.toArray(new Integer[]{}) , new Integer[]{i,boundary}, "swap");
                output.add(swapPanel);
            }else {
                Panel noSwapPanel = new Panel(TITLE, array, sortedIndexList.toArray(new Integer[]{}) , new Integer[]{i,boundary,end}, "Nope");
                output.add(noSwapPanel);
            }
        }
        return boundary;
    }
    private void swap(int array[], int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
