package Views;

import Shared.Components.HomeSettingsLabel;
import Shared.Components.InputBox;
import Shared.Components.SubmitButton;
import Shared.DataAccess;
import Shared.res.Styles;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {
    private final HomeSettingsLabel title = new HomeSettingsLabel("Learning Algorithms");
    public SubmitButton settings = new SubmitButton("Settings");
    public SubmitButton LinearSearch = new SubmitButton("Linear Search");
    public SubmitButton BinarySearch = new SubmitButton("Binary Search");
    public SubmitButton BubbleSort = new SubmitButton("Bubble Sort");
    public SubmitButton InsertionSort = new SubmitButton("Insertion Sort");
    public SubmitButton SelectionSort = new SubmitButton("Selection Sort");
    public SubmitButton QuickSort = new SubmitButton("Quick Sort");
    public SubmitButton setData = new SubmitButton("Set DataSet");

    public JLabel gitHub = new JLabel("github");


    //Algorithm group Labels
    private final JLabel Searching = new JLabel();
    private final JLabel Sorting = new JLabel();
    private final JLabel PathFinding = new JLabel();
    public InputBox data = new InputBox(DataAccess.GetCommaSeparatedData());

    public HomeView() {
        super.setLayout(null);
        super.setBackground(Styles.APP_BACKGROUNDCOLOR);
        super.setSize(800, 700);

        gitHub.setBounds(750, 0, 100, 30);
        gitHub.setFont(new Font(this.getFont().getFamily(), Font.PLAIN, 10));
        gitHub.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);
        super.add(gitHub);

        title.setBounds(100, 0, 700, 200);
        super.add(title);

        settings.setBounds(675, 625, 100, 30);
        super.add(settings);

        LinearSearch.setBounds(125, 425, 150, 25);
        super.add(LinearSearch);

        BinarySearch.setBounds(125, 475, 150, 25);
        super.add(BinarySearch);

        BubbleSort.setBounds(325, 425, 150, 25);
        super.add(BubbleSort);

        InsertionSort.setBounds(325, 475, 150, 25);
        super.add(InsertionSort);

        SelectionSort.setBounds(325, 525, 150, 25);
        super.add(SelectionSort);

        QuickSort.setBounds(325, 575, 150, 25);
        super.add(QuickSort);

        data.setBounds(100, 200, 575, 25);
        super.add(data);

        setData.setBounds(100, 240, 150, 25);
        super.add(setData);

        //Algorithm button headers
        Searching.setText("Searching");
        Searching.setFont(new Font(this.getFont().getFamily(), Font.BOLD, 30));

        Searching.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);

        Searching.setBounds(125, 375, 150, 35);
        super.add(Searching);

        Sorting.setText("Sorting");
        Sorting.setFont(new Font(this.getFont().getFamily(), Font.BOLD, 30));

        Sorting.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);

        Sorting.setBounds(350, 375, 150, 35);
        super.add(Sorting);

        PathFinding.setText("Misc.");
        PathFinding.setFont(new Font(this.getFont().getFamily(), Font.BOLD, 30));

        PathFinding.setForeground(Styles.PAGE_TITLE_FOREGROUNGCOLOR);

        PathFinding.setBounds(525, 375, 250, 35);
        super.add(PathFinding);


    }


}