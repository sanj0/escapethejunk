package de.naclstudios.etj.scenes;


import de.edgelord.sjgl.scene.Scene;
import de.edgelord.sjgl.ui.UISystem;
import de.naclstudios.etj.gameObjects.DrawBackground;

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
