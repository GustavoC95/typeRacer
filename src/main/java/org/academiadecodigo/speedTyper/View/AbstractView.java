package org.academiadecodigo.speedTyper.View;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractView implements View {

    public final static int PADDING=10;

    private Picture background;

    private boolean moveNext;

    public AbstractView(){
        moveNext=false;
    }

    public boolean getMoveNext() {
        return moveNext;
    }

    public void setMoveNext(boolean choice){
        moveNext=choice;
    }

    public Picture getBackground() {
        return background;
    }

    public void setBackground(String path){
        background=new Picture(PADDING, PADDING, path);
    }

    @Override
    public void show(){
        background.draw();
    }

}
