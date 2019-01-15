package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.audio.AudioPlayer;
import de.edgelord.saltyengine.components.gfx.scene.SceneFade;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.factory.AudioFactory;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.edgelord.saltyengine.ui.UISystem;
import de.edgelord.saltyengine.ui.elements.TexturedButton;
import de.edgelord.saltyengine.utils.SaltySystem;
import de.naclstudios.etj.gameObjects.HighScoreScreen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

public class MenuScreen extends Scene {

    private UISystem ui;
    private AudioPlayer audioSystem = new AudioPlayer(new AudioFactory(SaltySystem.defaultResource));
    private ImageFactory imageFactory = new ImageFactory(new InnerResource());
    private BufferedImage playButtonTexture = imageFactory.getImageResource("pictures/play-button.png");
    private BufferedImage exitButtonTexture = imageFactory.getImageResource("pictures/exit-button.png");

    public MenuScreen() {

        ui = new UISystem();
        addUI();
        setUI(ui);

        addAudio();

        addDrawingRoutine(new MenuBackGround());
        addDrawingRoutine(new HighScoreScreen());

        audioSystem.setClipVolume("de.naclstudios.etj.music.menuMusic", 0.085f);

        audioSystem.loop("de.naclstudios.etj.music.menuMusic");
    }

    private void addAudio() {
        audioSystem.loadNewAudio("de.naclstudios.etj.music.menuMusic", "audio/music/Junk Theme.wav");
    }

    private void addUI() {

        TexturedButton playButton = new TexturedButton("play", new Coordinates2f(Game.getHost().getHorizontalCentrePosition(450), 200), 450, 276, playButtonTexture) {
            @Override
            public void onClick(MouseEvent mouseEvent) {

                final SceneFade fadeIn = new SceneFade("fadeIn", SceneFade.Mode.FADE_IN, new Color(176, 100, 29));
                fadeIn.setDuration(750);

                Game.getDefaultGFXController().addComponent(fadeIn);
                fadeIn.fadeInit();

                SceneFade fadeOut = new SceneFade("fadeIn", SceneFade.Mode.FADE_OUT, new Color(176, 100, 29)) {
                    @Override
                    public void onFadeFinish() {
                        try {
                            SceneManager.setCurrentScene("game");
                        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        fadeIn.startGFX();
                    }
                };
                fadeOut.setDuration(750);

                Game.getDefaultGFXController().addComponent(fadeOut);
                fadeOut.fadeInit();
            }
        };

        TexturedButton exitButton = new TexturedButton("exit", new Coordinates2f(Game.getHost().getHorizontalCentrePosition(280), 600), 280, 156, exitButtonTexture) {
            @Override
            public void onClick(MouseEvent mouseEvent) {

                SceneFade sceneFade = new SceneFade(this, "fadeOut", SceneFade.Mode.FADE_OUT) {
                    @Override
                    public void onFadeFinish() {
                        System.exit(0);
                    }
                };
                sceneFade.setDuration(350);
                this.addComponent(sceneFade);

                sceneFade.fadeInit();
                sceneFade.startGFX();
            }
        };

        playButton.setDrawText(false);
        exitButton.setDrawText(false);

        ui.addElement(playButton);
        ui.addElement(exitButton);
    }
}
