package org.academiadecodigo.speedTyper.Views;

public abstract class AbstractView implements View {

    public final static int PADDING=10;

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

    @Override
    public abstract void show();
}
