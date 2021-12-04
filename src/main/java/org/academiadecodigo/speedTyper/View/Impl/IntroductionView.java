package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.View.AbstractView;
import org.academiadecodigo.speedTyper.Waiter;

public class IntroductionView extends AbstractView {

    private Picture background;
    private Picture Gustavo;
    private Picture Joana;

    private final int GUS_SIZE=378;
    private final int JOANA_SIZE=369;

    public IntroductionView(){
        super();
        super.setBackground("backgrounds/IntroductionBackground.png");
        background=super.getBackground();
        Gustavo=new Picture(background.getMaxX()- GUS_SIZE, background.getMaxY()-GUS_SIZE, "authors/Gustavo.png");
        Joana=new Picture(PADDING, background.getMaxY()-JOANA_SIZE, "authors/Joana.png");
    }

    @Override
    public void show(){
        super.show();
        Gustavo.draw();
        Joana.draw();
        Waiter.wait(2000);
        move();
    }

    private void move(){
        int moved=0;

        while(moved!=150){
            Waiter.wait(25);
            Joana.translate(0, -1);
            Gustavo.translate(0,-1);
            moved++;
        }
        Waiter.wait(1000);
        //drum roll as our photos ascend
        super.setMoveNext(true);
    }

    @Override
    public boolean getMoveNext() {
        return super.getMoveNext();
    }

}