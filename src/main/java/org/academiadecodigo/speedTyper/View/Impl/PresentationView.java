package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.speedTyper.View.AbstractView;

public class PresentationView extends AbstractView {

    public PresentationView(){
        super();
        super.setBackground("backgrounds/PresentationBackground.png");
    }

    @Override
    public void show(){
        super.show();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoveNext(true);
    }
}
