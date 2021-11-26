package org.academiadecodigo.speedTyper.Controllers;

import org.academiadecodigo.speedTyper.Views.View;

public interface Controller {

    View getView();

    void setView(View view);

    Controller getNextController();

    void setNextController(Controller nextController);

    void init();

    void next();
}
