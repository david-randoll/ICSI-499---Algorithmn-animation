package Views.SortingAlgorithms;

import Models.SortingAlgorithms.QuickSortModel;
import Models.SortingAlgorithms.SorterModel;
import Shared.AppFrame;
import Shared.res.Styles;

import java.awt.*;

public class QuickSortView extends SorterView {
    QuickSortModel model;

    public QuickSortView(QuickSortModel model) {
        super(model,1000);
        this.model = model;

        AppFrame.appFrame.add(model.Panels, BorderLayout.CENTER);
        AppFrame.appFrame.getContentPane().setBackground(Styles.APP_BACKGROUNDCOLOR);

        PaintNewPanelOnScreen();
    }
}