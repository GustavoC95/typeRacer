package org.academiadecodigo.speedTyper.Views.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.Views.AbstractView;

public class PresentationView extends AbstractView {

    private Picture background;

    public PresentationView(){
        background=new Picture(PADDING,PADDING,"PresentationBackground.png");
    }

    @Override
    public void show() {
        background.draw();
    }
}
