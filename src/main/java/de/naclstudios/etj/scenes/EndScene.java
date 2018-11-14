package de.naclstudios.etj.scenes;


import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.ui.UISystem;
import de.naclstudios.etj.main.EscapeTheJunk;

public class EndScene extends Scene {

    public EndScene() {

        addDrawingRoutine(new EndScreen());

        if (EscapeTheJunk.lastGameWon) {
            addGameObject(new EndSceneTextPanel("You escaped the junk! Thanks for playing!"));
        } else {
            addGameObject(new EndSceneTextPanel("Unfortunately, you died! Try it again!"));
        }

        setUI(new UISystem());

        getUI().addElement(new StartOverButton());
    }
}
