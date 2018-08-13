package de.naclstudios.etj.scenes;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.location.Coordinates;

import java.awt.*;

public class EndSceneTextPanel extends GameObject {

    private String message;

    public EndSceneTextPanel(String message) {
        super(new Coordinates(0, 0), 0, 0, "text");

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

    public void draw(Graphics2D graphics2D) {

        graphics2D.setFont(new Font("Serif", 0, 75));

        FontMetrics fontMetrics = graphics2D.getFontMetrics(graphics2D.getFont());

        int width = fontMetrics.stringWidth(message);

        graphics2D.drawString(message, Game.getDisplayManager().getHorizontalCenter(width), 300);
    }
}
