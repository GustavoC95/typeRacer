package org.academiadecodigo.speedTyper;

import org.academiadecodigo.speedTyper.Controllers.Controller;
import org.academiadecodigo.speedTyper.Controllers.Impl.IntroductionController;
import org.academiadecodigo.speedTyper.Controllers.Impl.PresentationController;
import org.academiadecodigo.speedTyper.Views.Impl.IntroductionView;
import org.academiadecodigo.speedTyper.Views.Impl.PresentationView;
import org.academiadecodigo.speedTyper.Views.View;

public class Bootstrap {

    public Controller wireObjects(){

        Controller introductionController =new IntroductionController();
        Controller presentationController=new PresentationController();

        View introductionView=new IntroductionView();
        View presentationView=new PresentationView();

        introductionController.setView(introductionView);
        introductionController.setNextController(presentationController);
        presentationController.setView(presentationView);

        return introductionController;
    }

}
