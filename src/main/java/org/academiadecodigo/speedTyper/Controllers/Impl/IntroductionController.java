package org.academiadecodigo.speedTyper.Controllers.Impl;

import org.academiadecodigo.speedTyper.Controllers.AbstractController;

public class IntroductionController extends AbstractController {

    @Override
    public void init() {
        while(!super.getView().getMoveNext()){
            super.init();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.next();
    }
}
