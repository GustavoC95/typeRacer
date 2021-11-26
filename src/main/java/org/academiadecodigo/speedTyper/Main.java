package org.academiadecodigo.speedTyper;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.speedTyper.Controllers.Controller;
import org.academiadecodigo.speedTyper.Controllers.Impl.IntroductionController;
import org.academiadecodigo.speedTyper.Controllers.Impl.PresentationController;
import org.academiadecodigo.speedTyper.Views.Impl.IntroductionView;
import org.academiadecodigo.speedTyper.Views.Impl.PresentationView;
import org.academiadecodigo.speedTyper.Views.View;

public class Main {

    public static void main(String[] args) {

        Bootstrap b=new Bootstrap();
        Controller c=b.wireObjects();
        c.init();
    }

}
