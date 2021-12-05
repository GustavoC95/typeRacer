package org.academiadecodigo.speedTyper.View;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractView implements View{

    public final static int PADDING=10;

    private boolean moveNext;

    private Picture background;

    private Keyboard keyboard;

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
