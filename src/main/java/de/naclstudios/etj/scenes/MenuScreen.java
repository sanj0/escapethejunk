package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.audio.AudioSystem;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.components.gfx.SceneFade;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.ui.UISystem;
import de.edgelord.saltyengine.ui.elements.TexturedButton;
import de.edgelord.saltyengine.utils.StaticSystem;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MenuScreen extends Scene {

    private UISystem ui;
    private AudioSystem audioSystem = new AudioSystem();
    private ImageFactory imageFactory = new ImageFactory(new InnerResource());
    private BufferedImage playButtonTexture = imageFactory.getImageResource("pictures/play-button.png");
    private BufferedImage exitButtonTexture = imageFactory.getImageResource("pictures/exit-button.png");

    public MenuScreen() {

        ui = new UISystem();
        addUI();
        setUI(ui);

        addAudio();

        addDrawingRoutin(new MenuBackGround());

        audioSystem.setClipVolume("de.naclstudios.etj.music.menuMusic", 0.75f);

        audioSystem.loop("de.naclstudios.etj.music.menuMusic");
    }

    private void addAudio() {
        audioSystem.loadNewAudio("de.naclstudios.etj.music.menuMusic", "audio/music/Junk Theme.wav");
    }

    private void addUI() {

        TexturedButton playButton = new TexturedButton("play", new Vector2f(Game.getHost().getHorizontalCentrePosition(450), 200), 450, 276, playButtonTexture) {
            @Override
            public void onClick(MouseEvent mouseEvent) {

                SceneFade sceneFade = new SceneFade(this, "fadeOut", SceneFade.Mode.FADE_OUT, Color.white) {
                    @Override
                    public void onFadeFinish() {
                        StaticSystem.currentScene = new GameScene();
                    }
                };
                sceneFade.setDuration(350);
                this.addComponent(sceneFade);

                sceneFade.fadeInit();
                sceneFade.startGFX();
            }
        };

        TexturedButton exitutton = new TexturedButton("exit", new Vector2f(Game.getHost().getHorizontalCentrePosition(280), 600), 280, 156, exitButtonTexture) {
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
        exitutton.setDrawText(false);

        ui.addElement(playButton);
        ui.addElement(exitutton);
    }
}
