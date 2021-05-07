package Views.SortingAlgorithms;

import Models.SortingAlgorithms.SelectionSortModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class SelectionSortView extends SorterView {
    SelectionSortModel model;
    public SelectionSortView(SelectionSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}