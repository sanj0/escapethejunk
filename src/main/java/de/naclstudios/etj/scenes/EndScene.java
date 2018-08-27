package de.naclstudios.etj.scenes;


import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.ui.UISystem;

public class EndScene extends Scene {

    public EndScene(boolean won){

        addDrawingRoutin(new EndScreen());

        if (won){
            addGameObject(new EndSceneTextPanel("You escaped the junk! Thanks for playing!"));
        } else {
            addGameObject(new EndSceneTextPanel("Unfortunately, you died! Try it again!"));
        }

        setUI(new UISystem());

        getUI().addElement(new StartOverButton());
    }
}
