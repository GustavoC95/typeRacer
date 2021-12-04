package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.speedTyper.View.AbstractView;
import org.academiadecodigo.speedTyper.Waiter;

public class PresentationView extends AbstractView {

    public PresentationView(){
        super();
        super.setBackground("backgrounds/PresentationBackground.png");
    }

    @Override
    public void show(){
        super.show();
        Waiter.wait(5000);
        setMoveNext(true);
    }
}
