package org.academiadecodigo.speedTyper;


import org.academiadecodigo.speedTyper.Server.Server;
import org.academiadecodigo.speedTyper.View.Impl.*;

public class Main {

    public static void main(String[] args) {

        Server myServer=new Server(8080);
        myServer.start();

        //IntroductionView intro=new IntroductionView();
        //intro.show();
        //PresentationView presentation=new PresentationView();
        //presentation.show();
        //RegisterView registration=new RegisterView();
        //registration.show();
        //InstructionsView instructions=new InstructionsView();
        //instructions.show();
        //GameView game=new GameView();
        //game.show();
        //EndView end=new EndView();
        //end.show();
    }

}
