package de.naclstudios.etj.main;

import de.edgelord.saltyengine.audio.AudioSystem;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.io.serialization.Serializer;
import de.edgelord.saltyengine.scene.SceneManager;
import de.naclstudios.etj.HighscoreAgent;
import de.naclstudios.etj.scenes.EndScene;
import de.naclstudios.etj.scenes.GameScene;
import de.naclstudios.etj.scenes.MenuScreen;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EscapeTheJunk extends Game {

    public static float currentWallDelta = 177f;
    public static boolean lastGameWon = false;
    public static AudioSystem sounds = new AudioSystem();

    public static long highScore = 0;

    public EscapeTheJunk(long fixedTickMillis) {
        super(1600, 950, "Escape the Junk", fixedTickMillis);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        new EscapeTheJunk(1);

        start(60);

        SceneManager.addScene("game", GameScene.class);
        SceneManager.addScene("menu", MenuScreen.class);
        SceneManager.addScene("end", EndScene.class);

        SceneManager.setCurrentScene("menu");

        float sfx = 0.05f;

        sounds.loadNewAudio("rat_dies", "audio/sound/rat_dies.wav");
        sounds.setClipVolume("rat_dies", sfx);
        sounds.loadNewAudio("junk_destroyed", "audio/sound/junk_destroyed.wav");
        sounds.setClipVolume("junk_destroyed", sfx);
        sounds.loadNewAudio("key_collected", "audio/sound/key_collected.wav");
        sounds.setClipVolume("key_collected", sfx);
        sounds.loadNewAudio("shot", "audio/sound/shot.wav");
        sounds.setClipVolume("shot", sfx);

        Serializer.add(new HighscoreAgent());
        Serializer.doDeserialization();
    }
}
