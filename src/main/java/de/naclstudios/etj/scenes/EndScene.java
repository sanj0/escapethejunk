package de.naclstudios.etj.scenes;


import de.edgelord.saltyengine.io.serialization.Serializer;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.ui.UISystem;
import de.naclstudios.etj.HighscoreAgent;
import de.naclstudios.etj.gameObjects.HighScoreScreen;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.io.IOException;

public class EndScene extends Scene {

    public EndScene(Boolean won) {

        if (EscapeTheJunk.highScore == 0) {
            EscapeTheJunk.highScore = HighscoreAgent.getCurrentTime();
        } else {
            EscapeTheJunk.highScore = Math.min(EscapeTheJunk.highScore, HighscoreAgent.getCurrentTime());
        }

        HighscoreAgent.stopStopwatch();

        addDrawingRoutine(new EndScreen());

        if (won) {
            addGameObject(new EndSceneTextPanel("You escaped the junk! Thanks for playing!"));
        } else {
            addGameObject(new EndSceneTextPanel("Unfortunately, you died! Try it again!"));
        }

        setUI(new UISystem());

        getUI().addElement(new StartOverButton());

        addDrawingRoutine(new HighScoreScreen());

        try {
            Serializer.doSerialization();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
