package org.academiadecodigo.speedTyper.View.Cars;

public enum Cars {
    RED (1, "cars/RedCar.png"),
    BLUE (2, "cars/BlueCar.png"),
    GREEN (3,"cars/GreenCar.png"),
    YELLOW (4, "cars/GreenCar.png"),
    PURPLE (5, "cars/PurpleCar.png");

    int number;
    String carSrc;

    Cars(int number, String carSrc){
        this.number=number;
        this.carSrc=carSrc;
    }

    public int getNumber() {
        return number;
    }

    public String getCarSrc() {
        return carSrc;
    }
}