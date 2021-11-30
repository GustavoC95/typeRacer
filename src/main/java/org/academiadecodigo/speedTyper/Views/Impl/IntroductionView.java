package org.academiadecodigo.speedTyper.Views.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.Views.AbstractView;
import org.academiadecodigo.speedTyper.Views.View;

public class IntroductionView extends AbstractView {

    private Picture background;
    private Picture Gustavo;
    private Picture Joana;

    private final int GUS_SIZE=378;
    private final int JOANA_SIZE=369;

    public IntroductionView(){
        super();
        super.setBackground( "IntroductionBackground.png");
        background=super.getBackground();
        Gustavo=new Picture(background.getMaxX()- GUS_SIZE, background.getMaxY()-GUS_SIZE, "Gustavo.png");
        Joana=new Picture(PADDING, background.getMaxY()-JOANA_SIZE, "Joana.png");
    }

    @Override
    public void show(){
        super.show();
        Gustavo.draw();
        Joana.draw();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        move();
    }

    private void move(){
        int moved=0;

        while(moved!=150){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Joana.translate(0, -1);
            Gustavo.translate(0,-1);
            moved++;
        }
        //drum roll as our photos ascend
        super.setMoveNext(true);
    }

    @Override
    public boolean getMoveNext() {
        return super.getMoveNext();
    }

}
