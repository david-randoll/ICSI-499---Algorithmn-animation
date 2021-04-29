package Models.SortingAlgorithms;

import Models.Model;
import Shared.DataAccess;
import SharedComponents.Panel;
import Views.SortingAlgorithms.BinarySearchView;
import res.Styles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearchModel implements Model {

    public static JPanel Panels = new JPanel(new CardLayout());
    private Random rand = new Random();
    private int SEARCH_VALUE = 4;

    public BinarySearchModel() {
        int[] data = DataAccess.GetSortedData();
        int searchValue = getSearchValue();
        ArrayList<Panel> panels = run(data, searchValue);

        for (int i = 0; i < panels.size(); i++) {
            drawBackButton(panels.get(i));
            this.Panels.add(panels.get(i), Integer.toString(i));
        }//Add all cards to the card panel so we can transition panels easily
    }

    void drawBackButton(JPanel panel) {
        JButton backToHome = new JButton("\uD83E\uDC44");
        backToHome.setFont(Styles.UNICODE_FONT);
        int buttonFontSize = Styles.UNICODE_FONT.getSize();
        panel.add(backToHome);
        backToHome.setBounds(25, 25, buttonFontSize * 3, buttonFontSize + 10);
        backToHome.addActionListener(BinarySearchView.homePage());
    }

    public int getSearchValue() {
        return SEARCH_VALUE;
    }

    public int getData() {
        return SEARCH_VALUE;
    }

    public void setSearchValue(int value) {
        this.SEARCH_VALUE = value;
    }

    public ArrayList<Panel> run(int arr[], int x) {

        ArrayList<Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        Panel firstPanel = new Panel("Binary Search", arr, null, "start");
        output.add(firstPanel);

        int index = 0;
        while (l <= r) {

            int m = l + (r - l) / 2;
            index = m;
            Integer[] indices = {m};

            // Check if x is present at mid
            if (arr[m] == x) {
                Integer[] found = {m};
                output.add(new Panel("Binary Search", arr, found, indices, "found"));
                return output;
            }

            // If x greater, ignore left half
            if (arr[m] < x) {
                l = m + 1;
                ArrayList<Integer> list = new ArrayList<>();

                for (int i = m; i < r + 1; i++) {
                    list.add(i);
                }
                Integer[] enabledIndices = new Integer[list.size()];
                enabledIndices = list.toArray(enabledIndices);

                Panel newPanel = new Panel("Binary Search", arr, enabledIndices, indices, String.valueOf(x));
                output.add(newPanel);
            }

            // If x is smaller, ignore right half
            else {
                r = m - 1;
                ArrayList<Integer> list = new ArrayList<>();

                for (int i = l; i < m + 1; i++) {
                    list.add(i);
                } //Arrays.copyOfRange(arr, l , m)

                Integer[] enabledIndices = new Integer[list.size()];
                enabledIndices = list.toArray(enabledIndices);

                Panel newPanel = new Panel("Binary Search", arr, enabledIndices, indices, String.valueOf(x));
                output.add(newPanel);
            }
        }
        // if we reach here, then element was
        // not present
        output.add(new Panel("Binary Search", arr, new Integer[]{}, new Integer[]{index}, "not found"));
        return output;
    }

}
