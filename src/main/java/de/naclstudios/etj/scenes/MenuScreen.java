package de.naclstudios.etj.scenes;

import de.edgelord.sjgl.audio.AudioSystem;
import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.scene.Scene;
import de.edgelord.sjgl.ui.UISystem;
import de.edgelord.sjgl.ui.elements.TexturedButton;
import de.edgelord.sjgl.utils.StaticSystem;

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

        audioSystem.loop("de.naclstudios.etj.music.menuMusic");
    }

    private void addAudio() {
        audioSystem.loadNewAudio("de.naclstudios.etj.music.menuMusic", "audio/music/menu_track.wav");
    }

    private void addUI() {

        TexturedButton playButton = new TexturedButton("play", new Coordinates(Game.getDisplayManager().getHorizontalCenter(450), 200), 450, 276, playButtonTexture) {
            @Override
            public void onClick(MouseEvent mouseEvent) {

                StaticSystem.currentScene = new GameScene();
            }
        };

        TexturedButton exitutton = new TexturedButton("exit", new Coordinates(Game.getDisplayManager().getHorizontalCenter(280), 600), 280, 156, exitButtonTexture) {
            @Override
            public void onClick(MouseEvent mouseEvent) {

                System.exit(0);
            }
        };

        playButton.setDrawText(false);
        exitutton.setDrawText(false);

        ui.addElement(playButton);
        ui.addElement(exitutton);
    }
}
