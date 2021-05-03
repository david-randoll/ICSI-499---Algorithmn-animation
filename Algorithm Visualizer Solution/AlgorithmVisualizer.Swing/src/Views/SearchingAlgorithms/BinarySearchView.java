package Views.SearchingAlgorithms;

import Models.SearchingAlgorithms.BinarySearchModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class BinarySearchView extends SearchView {
    BinarySearchModel model;

    public BinarySearchView(BinarySearchModel model) {
        super(model, 1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }

}