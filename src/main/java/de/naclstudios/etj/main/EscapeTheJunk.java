package de.naclstudios.etj.main;

import de.edgelord.sjgl.audio.AudioSystem;
import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.MenuScreen;

public class EscapeTheJunk extends Game {

    public static float currentWallDelta = 177f;
    public static AudioSystem sounds = new AudioSystem();

    public EscapeTheJunk(long fixedTickMillis) {
        super(1600, 950, "Escape the Junk", fixedTickMillis);
    }

    public static void main(String[] args) {
        EscapeTheJunk escapeTheJunk = new EscapeTheJunk(1);

        start(60);
        StaticSystem.drawFPS = false;
        StaticSystem.currentScene = new MenuScreen();

        sounds.loadNewAudio("rat_dies", "audio/sound/rat_dies.wav");
        sounds.loadNewAudio("junk_destroyed", "audio/sound/junk_destroyed.wav");
        sounds.loadNewAudio("key_collected", "audio/sound/key_collected.wav");
        sounds.loadNewAudio("shot", "audio/sound/shot.wav");
    }
}
