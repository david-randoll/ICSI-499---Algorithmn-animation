package Models.SortingAlgorithms;

import Shared.Components.Panel;
import Shared.DataAccess;
import Shared.RectangleElement;
import Shared.res.Styles;

import java.awt.*;
import java.util.ArrayList;

public class QuickSortModel extends SorterModel implements ISorterModel {

    RectangleElement[] dataSetRectangle;

    public QuickSortModel() {
        super();
        setTitle("Quick Sort");
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

        for (int i = 0; i < panels.size(); i++) {
            super.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[]) {
        dataSetRectangle = InitializeRectangleElements(arr);
        ArrayList<Panel> output = new ArrayList<>();

        output.add( new Panel(getTitle(), dataSetRectangle,  ""));

        sort(arr,0,arr.length - 1,output);

        for(int i =0; i < arr.length;i++){
            updateBackgroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_BACKGROUND_COLOR);
            updateForegroundColor(dataSetRectangle, new int[]{i}, Styles.SORTED_DATA_COLOR);
        }

        output.add( new Panel(getTitle(), dataSetRectangle,  "Sorted"));

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


        DrawOutlineColor(end, Styles.PIVOT_COLOR);
        DrawOutlineColor(boundary, Styles.BOUNDARY_COLOR);
        output.add(new Panel(getTitle(),dataSetRectangle,"pivot: "+pivot +", boundary index: "+boundary));
        DrawOutlineColor(end, null);
        DrawOutlineColor(boundary, null);

        for (var i = start; i <= end; i++){
            DrawOutlineColor(end, Styles.PIVOT_COLOR);
            DrawOutlineColor(boundary, Styles.BOUNDARY_COLOR);
            UpdateBorderColorAndAddToOutput(dataSetRectangle,output, new int[]{i},"Is "+array[i]+" <= pivot: "+pivot+"?", Styles.OUTLINE_COLOR);
            DrawOutlineColor(end, null);
            DrawOutlineColor(boundary, null);
            if(array[i] <= pivot){
                boundary++;
                //telling the user we need to increment the boundary
                DrawOutlineColor(end, Styles.PIVOT_COLOR);
                DrawOutlineColor(boundary, Styles.BOUNDARY_COLOR);
                UpdateBorderColorAndAddToOutput(dataSetRectangle,output, new int[]{i},"Increment boundary (index: "+boundary+")", Styles.OUTLINE_COLOR);
                DrawOutlineColor(end, null);
                DrawOutlineColor(boundary, null);

                swap(dataSetRectangle, array, i, boundary);
                if(i == end){
                    updateBackgroundColor(dataSetRectangle, new int[]{boundary}, Styles.SORTED_BACKGROUND_COLOR);
                    updateForegroundColor(dataSetRectangle, new int[]{boundary}, Styles.SORTED_DATA_COLOR);
                }
                UpdateBorderColorAndAddToOutput(dataSetRectangle,output, new int[]{i,boundary},"Swap", Styles.SWAP_COLOR);
                DrawOutlineColor(end, null);
                DrawOutlineColor(boundary, null);
            }else {
                DrawOutlineColor(end, Styles.PIVOT_COLOR);
                DrawOutlineColor(boundary, Styles.BOUNDARY_COLOR);
                UpdateBorderColorAndAddToOutput(dataSetRectangle,output, new int[]{i},"Nope", Styles.OUTLINE_COLOR);
                DrawOutlineColor(end, null);
                DrawOutlineColor(boundary, null);
            }
        }
        return boundary;
    }

    private void DrawOutlineColor(int index, Color color) {
        updateBorderColor(dataSetRectangle, new int[]{index}, color);
    }
}
