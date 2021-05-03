package Views.SearchingAlgorithms;

import Models.SearchingAlgorithms.SearchModel;
import Views.SortingAlgorithms.SorterView;

import javax.swing.*;
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

        searchTextBox = new JTextField();
        searchTextBox.setText(Integer.toString(model.getSearchValue()));
        searchTextBox.setPreferredSize(new Dimension(30, 20));
        toolBarPanel.add(searchTextBox);
        toolBarPanel.add(searchValueSubmit);
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchValueSubmit.addActionListener(listener);
    }

    public JTextField getSearchTextBox() {
        return searchTextBox;
    }
}
