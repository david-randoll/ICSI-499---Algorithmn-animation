package Views.Algorithms.SortingAlgorithms;

import Models.Algorithms.SortingAlgorithms.InsertionSortModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class InsertionSortView extends BaseSorterView {
    InsertionSortModel model;

    public InsertionSortView(InsertionSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}