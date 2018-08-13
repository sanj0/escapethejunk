package de.naclstudios.etj.main;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.MenuScreen;

import java.awt.*;

public class EscapeTheJunk extends Game {

    public static float currentWallDelta = 177f;

    public EscapeTheJunk(long fixedTickMillis) {
        super(1600, 950, "Escape the Junk", fixedTickMillis);
    }

    public static void main(String[] args) {
        EscapeTheJunk escapeTheJunk = new EscapeTheJunk(1);

        start(60);
        StaticSystem.drawFPS = false;
        StaticSystem.currentScene = new MenuScreen();
    }
}
