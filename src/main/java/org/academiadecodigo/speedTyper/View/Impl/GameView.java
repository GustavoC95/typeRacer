package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.speedTyper.View.AbstractView;

public class GameView extends AbstractView {

    private Picture[] cars;

    public GameView(){
        super();
        super.setBackground("GameBackground.png");

        cars=new Picture[5];
        loadCars();
    }

    private void loadCars(){

        cars[0]=new Picture(PADDING, 300, "RedCar.png");
        cars[1]=new Picture(PADDING, 390, "YellowCar.png");
        cars[2]=new Picture(PADDING, 480, "BlueCar.png");
        cars[3]=new Picture(PADDING, 570, "GreenCar.png");
        cars[4]=new Picture(PADDING, 660, "PurpleCar.png");

    }

    @Override
    public void show() {
        super.show();
        for (Picture car:cars){
            car.draw();
        }
    }
}
