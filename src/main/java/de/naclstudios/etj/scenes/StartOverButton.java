package de.naclstudios.etj.scenes;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.ui.elements.Button;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StartOverButton extends Button {

    public StartOverButton() {
        super("Try again!", Game.getDisplayManager().getCenter(300, 100), 300, 100);


        setFont(getFont().deriveFont(30f));

        setBackgroundColor(new Color(108, 54, 22));
    }

    public void onClick(MouseEvent mouseEvent) {

        StaticSystem.currentScene = new GameScene();
    }
}
