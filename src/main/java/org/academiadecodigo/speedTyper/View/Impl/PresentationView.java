package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
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
        Waiter.wait(3000);
        super.setMoveNext(true);
    }

}
