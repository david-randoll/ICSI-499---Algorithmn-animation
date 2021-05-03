package Views.SortingAlgorithms;

import Controllers.HomeController;
import Models.SortingAlgorithms.InsertionSortModel;
import Shared.AppFrame;
import Shared.DataAccess;
import Shared.Components.CustomJPanel;
import Shared.Components.Panel;
import Shared.Components.toast;
import Shared.res.Styles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

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