package org.academiadecodigo.speedTyper.View.Impl;

import org.academiadecodigo.speedTyper.View.AbstractView;
import org.academiadecodigo.speedTyper.Waiter;

public class InstructionsView extends AbstractView {

    //private Text[] instructions;

    public InstructionsView(){
        super();
        super.setBackground("backgrounds/InstructionsWithTextEmbedded.png");
        //super.setBackground("InstructionsBackground.png");

       /* String[] instructionsText=Instructions.INSTRUCTIONS.split("\n");
        instructions=new Text[instructionsText.length];

        for (int i=0; i< instructions.length; i++){
            instructions[i]=new Text(PADDING+300, 400+(i*50),instructionsText[i]);
        }*/
    }

    /*@Override
    public void show(){
        super.show();
        for(Text instruction:instructions){
            instruction.draw();
            instruction.grow(100,15);

    } }*/

    @Override
    public void show(){
        super.show();
        Waiter.wait(10000);
        super.setMoveNext(true);
        //Though about movind with a click on right button. Then thought it would make more sense if the transition between slides as all made this way. Didn't work.
    }
}