package org.academiadecodigo.speedTyper.Controllers.Impl;

import org.academiadecodigo.speedTyper.Controllers.AbstractController;

public class PresentationController extends AbstractController {

    @Override
    public void init() {
        while(!super.getView().getMoveNext()){
            super.init();
        }
        super.next();
    }

}
