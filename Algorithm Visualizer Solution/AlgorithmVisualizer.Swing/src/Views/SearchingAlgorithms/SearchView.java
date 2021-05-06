package Views.SearchingAlgorithms;

import Models.SearchingAlgorithms.SearchModel;
import Shared.res.Styles;
import Views.SortingAlgorithms.SorterView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchView extends SorterView {
    JTextField searchTextBox;
    JButton searchValueSubmit;

    SearchModel model;

    public SearchView(SearchModel model, int defaultSpeed) {
        super(model, defaultSpeed);
        this.model = model;
        InitializeToolBar();
    }

    private void InitializeToolBar() {
        JPanel toolBarPanel = super.getToolBarPanel();

        searchValueSubmit = new JButton("Submit");
        searchValueSubmit.setPreferredSize(new Dimension(100, 30));

        JLabel label = new JLabel("Search Value: ");
        label.setForeground(Styles.COLOR_WHITE);
        label.setBorder(new EmptyBorder(0, 50, 0, 0));
        label.setFont(Styles.APP_FONT);

        searchTextBox = new JTextField();
        searchTextBox.setText(Integer.toString(model.getSearchValue()));
        searchTextBox.setPreferredSize(new Dimension(60, 30));
        searchTextBox.setBorder(new EmptyBorder(5, 5, 5, 0));

        toolBarPanel.add(label);
        toolBarPanel.add(searchTextBox);
        toolBarPanel.add(searchValueSubmit);
    }

    public void addSearchButtonListener(ActionListener listener){
        searchValueSubmit.addActionListener(listener);
    }
    public JTextField getSearchTextBox(){
        return searchTextBox;
    }
}
