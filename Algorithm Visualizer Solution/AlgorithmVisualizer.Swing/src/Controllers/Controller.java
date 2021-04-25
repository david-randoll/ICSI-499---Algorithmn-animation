package Controllers;

import Shared.DataAccess;

public interface Controller {

    public void InitController(DataAccess dataAccess);
    public void InitView();

}
