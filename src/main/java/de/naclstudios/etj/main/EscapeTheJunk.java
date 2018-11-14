package de.naclstudios.etj.main;

import de.edgelord.saltyengine.audio.AudioSystem;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.scene.SceneManager;
import de.naclstudios.etj.scenes.EndScene;
import de.naclstudios.etj.scenes.GameScene;
import de.naclstudios.etj.scenes.MenuScreen;

import java.lang.reflect.InvocationTargetException;

public class EscapeTheJunk extends Game {

    public static float currentWallDelta = 177f;
    public static boolean lastGameWon = false;
    public static AudioSystem sounds = new AudioSystem();

    public EscapeTheJunk(long fixedTickMillis) {
        super(1600, 950, "Escape the Junk", fixedTickMillis);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        new EscapeTheJunk(1);

        start(60);

        SceneManager.addScene("game", GameScene.class);
        SceneManager.addScene("menu", MenuScreen.class);
        SceneManager.addScene("end", EndScene.class);

        SceneManager.setCurrentScene("menu");

        sounds.loadNewAudio("rat_dies", "audio/sound/rat_dies.wav");
        sounds.loadNewAudio("junk_destroyed", "audio/sound/junk_destroyed.wav");
        sounds.loadNewAudio("key_collected", "audio/sound/key_collected.wav");
        sounds.loadNewAudio("shot", "audio/sound/shot.wav");
    }
}
