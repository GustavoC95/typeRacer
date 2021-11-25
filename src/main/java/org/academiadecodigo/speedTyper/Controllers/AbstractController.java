package org.academiadecodigo.speedTyper.Controllers;

import org.academiadecodigo.speedTyper.Views.View;

public class AbstractController implements Controller {

    protected View view;
    private Controller nextController;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Controller getNextController() {
        return nextController;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    @Override
    public void init() {
        view.show();
    }

    //public to be invoked outside or private to be invoked inside another when it's finished?
    @Override
    public void next() {
        nextController.init();
    }

}
