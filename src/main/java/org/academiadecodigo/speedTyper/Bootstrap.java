package org.academiadecodigo.speedTyper;

import org.academiadecodigo.speedTyper.Controllers.Controller;
import org.academiadecodigo.speedTyper.Controllers.Impl.InstructionController;
import org.academiadecodigo.speedTyper.Controllers.Impl.IntroductionController;
import org.academiadecodigo.speedTyper.Controllers.Impl.PresentationController;
import org.academiadecodigo.speedTyper.Controllers.Impl.RegisterController;
import org.academiadecodigo.speedTyper.Views.Impl.InstructionView;
import org.academiadecodigo.speedTyper.Views.Impl.IntroductionView;
import org.academiadecodigo.speedTyper.Views.Impl.PresentationView;
import org.academiadecodigo.speedTyper.Views.Impl.RegisterView;
import org.academiadecodigo.speedTyper.Views.View;

public class Bootstrap {

    public Controller wireObjects(){

        Controller introductionController =new IntroductionController();
        Controller presentationController=new PresentationController();
        Controller registrationController=new RegisterController();
        Controller instructionController=new InstructionController();

        View introductionView=new IntroductionView();
        View presentationView=new PresentationView();
        View registrationView=new RegisterView();
        View instructionView=new InstructionView();

        introductionController.setView(introductionView);
        introductionController.setNextController(presentationController);
        presentationController.setView(presentationView);
        presentationController.setNextController(registrationController);
        registrationController.setView(registrationView);
        registrationController.setNextController(instructionController);
        instructionController.setView(instructionView);
        //

        return introductionController;
    }

}
