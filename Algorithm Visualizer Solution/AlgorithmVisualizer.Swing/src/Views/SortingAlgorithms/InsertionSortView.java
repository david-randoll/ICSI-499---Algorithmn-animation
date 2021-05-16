package Views.SortingAlgorithms;

import Models.SortingAlgorithms.InsertionSortModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class InsertionSortView extends SorterView {
    InsertionSortModel model;

    public InsertionSortView(InsertionSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}