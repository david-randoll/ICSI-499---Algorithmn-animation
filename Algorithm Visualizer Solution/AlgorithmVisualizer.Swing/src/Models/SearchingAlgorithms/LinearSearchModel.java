package Models.SearchingAlgorithms;

import Models.Model;
import Shared.DataAccess;
import Shared.Components.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LinearSearchModel extends SearchModel implements Model {

    final String TITLE = "Linear Search";

    public LinearSearchModel() {
        int[] data = DataAccess.GetSortedData();
        int searchValue = getSearchValue();
        ArrayList<Panel> panels = run(data, searchValue);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[], int x) {

        ArrayList<Panel> output = new ArrayList<>();

        Panel firstPanel = new Panel(TITLE, arr, null, "start");
        output.add(firstPanel);

        for(int i = 0; i < arr.length; i++){

            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i; j < arr.length; j++) {
                list.add(j);
            }
            Integer[] enabledIndices = new Integer[list.size()];
            enabledIndices = list.toArray(enabledIndices);

            output.add(new Panel(TITLE, arr, enabledIndices, new Integer[]{i}, String.valueOf(x)));
            if (arr[i] == x) {
                Integer[] found = {i};
                output.add(new Panel(TITLE, arr, found, new Integer[]{i}, String.format("%d was found!", x)));
                return output;
            }
        }
        // if we reach here, then element was
        // not present
        output.add(new Panel(TITLE, arr, new Integer[]{}, new Integer[]{}, String.format("%d not found.", x)));
        return output;
    }

}
