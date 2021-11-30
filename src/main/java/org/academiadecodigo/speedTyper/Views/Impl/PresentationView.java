package org.academiadecodigo.speedTyper.Views.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.Views.AbstractView;

public class PresentationView extends AbstractView {

    public PresentationView(){
        super();
        super.setBackground("PresentationBackground.png");
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
