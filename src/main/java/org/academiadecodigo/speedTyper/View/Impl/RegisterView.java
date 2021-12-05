package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.speedTyper.Server.Server;
import org.academiadecodigo.speedTyper.View.AbstractView;

public class RegisterView extends AbstractView {

    private Server server;

    public RegisterView(Server server){
        super.setMoveNext(false);
        super.setBackground("backgrounds/RegistrationBackground.png");
        this.server=server;
    }

    @Override
    public void show() {
        while(!server.checkPlayersState()){
            super.show();
        }
        setMoveNext(true);
    }


}