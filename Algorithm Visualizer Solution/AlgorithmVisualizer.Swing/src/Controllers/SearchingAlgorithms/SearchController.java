package Controllers.SearchingAlgorithms;

import Controllers.SortingAlgorithms.SorterController;
import Models.Model;
import Models.SearchingAlgorithms.SearchModel;
import Shared.AppFrame;
import Shared.Components.Panel;
import Shared.Components.toast;
import Shared.DataAccess;
import Views.SearchingAlgorithms.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchController extends SorterController {

    private SearchView view;
    private SearchModel model;

    public void InitController(SearchModel model, SearchView view) {
        this.model = model;
        this.view = view;
        InitView();
        super.InitController(model, view);
    }

    private void InitView() {
        view.addSearchButtonListener(newSearchValueListener());

        //remove the event listener and add new listener
        view.getChangeDataSetButton().removeActionListener(super.updateDataSetActionListener());
        view.addDataSetButtonListener(updateDataSetActionListener());
    }

    private ActionListener newSearchValueListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();
                int newSearchValue = Integer.parseInt(view.getSearchTextBox().getText());
                model.Panels.removeAll();
                ArrayList<Panel> panels = ((Model) model).run(DataAccess.GetSortedData(), newSearchValue);
                model.setSearchValue(newSearchValue);

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                model.setCurrentIndex(0);
                view.UpdatePlayPauseButtonText("\u23F5");//play
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }

    protected ActionListener updateDataSetActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.getTimer().Stop();

                if (DataAccess.SetData(view.getDataSetTextBox().getText()) == false) {
                    toast t = new toast("Not valid input! Only comma separated numbers are valid", (int) (view.getScreenSize().width * 0.5), (int) (view.getScreenSize().height * 0.8));
                    t.showtoast();
                }
                model.Panels.removeAll();
                ArrayList<Panel> panels = ((Model) model).run(DataAccess.GetSortedData(), model.getSearchValue());

                for (int i = 0; i < panels.size(); i++) {
                    model.Panels.add(panels.get(i), Integer.toString(i));
                }//Add all cards to the card panel so we can transition panels easily

                model.setCurrentIndex(0);

                view.UpdatePlayPauseButtonText("\u23F5");
                AppFrame.appFrame.revalidate();
                AppFrame.appFrame.repaint();
            }
        };
    }
}
