package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.graphics.SaltyGraphics;

import java.awt.*;

public class EndSceneTextPanel extends GameObject {

    private String message;

    public EndSceneTextPanel(String message) {
        super(0,0, 0, 0, "text");

        this.message = message;
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(SaltyGraphics graphics) {

        graphics.setFont(new Font("Serif", 0, 75));

        FontMetrics fontMetrics = graphics.getFontMetrics();

        int width = fontMetrics.stringWidth(message);

        graphics.drawText(message, Game.getDisplayManager().getHorizontalCenter(width), 300);
    }
}
