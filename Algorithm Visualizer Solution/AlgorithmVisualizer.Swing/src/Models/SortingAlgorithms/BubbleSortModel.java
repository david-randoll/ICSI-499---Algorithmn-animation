package Models.SortingAlgorithms;

<<<<<<< Updated upstream
import Shared.DataAccess;
import SharedComponents.Panel;
import Views.SortingAlgorithms.BinarySearchView;
import Views.SortingAlgorithms.BubbleSortView;
import res.Styles;
=======
import Shared.Components.Panel;
import Shared.DataAccess;
>>>>>>> Stashed changes

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortModel {

    public static JPanel Panels = new JPanel(new CardLayout());

    String TITLE = "Bubble Sort";

    public BubbleSortModel() {
        int[] data = DataAccess.GetData();
        ArrayList<Panel> panels = run(data);

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
        backToHome.addActionListener(BubbleSortView.homePage());
    }

    public ArrayList<Panel> run(int arr[]) {

        ArrayList<SharedComponents.Panel> output = new ArrayList<>();

        int l = 0, r = arr.length - 1;

        SharedComponents.Panel firstPanel = new SharedComponents.Panel(TITLE, arr, null, "");
        output.add(firstPanel);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                Integer[] indices = {j, j + 1};

                ArrayList<Integer> list = new ArrayList<>();

                for (int index = arr.length - i; index < arr.length; index++) {
                    list.add(index);
                }
                Integer[] sortedIndices = new Integer[list.size()];
                sortedIndices = list.toArray(sortedIndices);

<<<<<<< Updated upstream
                SharedComponents.Panel newPanel = new Panel(TITLE, arr, sortedIndices , indices, "none");
=======
                Panel newPanel = new Panel(TITLE, arr, sortedIndices, indices, "Is " + arr[j] + " greater than " + arr[j + 1] + "?");
>>>>>>> Stashed changes
                output.add(newPanel);

                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Integer[] swapIndices = {j + 1, j};
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    SharedComponents.Panel swapPanel = new Panel(TITLE, arr, sortedIndices, swapIndices, "swap");
                    output.add(swapPanel);
<<<<<<< Updated upstream
=======
                } else {
                    Panel noSwapPanel = new Panel(TITLE, arr, sortedIndices, indices, "Nope");
                    output.add(noSwapPanel);
>>>>>>> Stashed changes
                }
            }
        }

        Integer[] sortedIndices = new Integer[arr.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            sortedIndices[i] = i;
        }

<<<<<<< Updated upstream
        SharedComponents.Panel lastPanel = new SharedComponents.Panel(TITLE, arr, sortedIndices,null, "");
=======
        Panel lastPanel = new Panel(TITLE, arr, sortedIndices, null, "Sorted");
>>>>>>> Stashed changes
        output.add(lastPanel);

        return output;
    }
}