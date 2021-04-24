package Models.SortingAlgorithms;

import Models.Model;
import Shared.DataAccess;
import SharedComponents.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BinarySearchModel implements Model {

    public static JPanel Panels = new JPanel(new CardLayout());

    public BinarySearchModel() {
        DataAccess dataAccess = new DataAccess();
        int[] data = dataAccess.GetSortedData();
        int searchValue = dataAccess.GetSearchValue();
        ArrayList<Panel> panels = run(data, searchValue);

        for (int i = 0; i < panels.size(); i++) {
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    public ArrayList<Panel> run(int arr[], int x) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel("Binary Search", arr, null, "");
        output.add(firstPanel);

        while (l <= r) {

            int m = l + (r - l) / 2;
            Integer [] indices = {m};

            Panel newPanel = new Panel("Binary Search", arr, indices, "");
            output.add(newPanel);

            // Check if x is present at mid
            if (arr[m] == x) {
                output.add(new Panel("Binary Search", arr, indices, "found"));
                return output;
            }

            // If x greater, ignore left half
            if (arr[m] < x) {
                l = m + 1;
            }


            // If x is smaller, ignore right half
            else
                r = m - 1;

        }

        // if we reach here, then element was
        // not present
        return output;
    }

}
