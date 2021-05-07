package Models;

import Shared.Components.Panel;
import Shared.Components.PanelClone;

import java.util.ArrayList;

public interface Model {
    ArrayList<PanelClone> run(int arr[], int x);
}
