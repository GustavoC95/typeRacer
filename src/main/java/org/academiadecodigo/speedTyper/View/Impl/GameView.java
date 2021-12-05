package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.Server.Server;
import org.academiadecodigo.speedTyper.View.AbstractView;

public class GameView extends AbstractView {

    private Picture[] cars;
    private String[] carsSrcs;

    public GameView(String[] carsSrcs){
        super();
        super.setBackground("backgrounds/GameBackground.png");

        cars=new Picture[5];
        this.carsSrcs=carsSrcs;
        loadCars();
    }

    private void loadCars(){
       for (int i=0; i< cars.length; i++){
           cars[i]=new Picture(PADDING, 300+(i*90), carsSrcs[i]);
       }
    }

    @Override
    public void show() {
        super.show();
        for (Picture car:cars){
            car.draw();
        }
    }
}
