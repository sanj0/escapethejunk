package de.naclstudios.etj.main;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.MenuScreen;

import java.awt.*;

public class EscapeTheJunk extends Game {

    public EscapeTheJunk(long fixedTickMillis) {
        super(1600, 950, "Escape the Junk", fixedTickMillis);
    }

    public static void main(String[] args) {
        EscapeTheJunk escapeTheJunk = new EscapeTheJunk(1);

        getDisplayManager().getStage().setBackground(new Color(49, 51, 49));

        start(60);
        StaticSystem.drawFPS = false;
        StaticSystem.currentScene = new MenuScreen();
    }
}
