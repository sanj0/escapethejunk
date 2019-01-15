package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.DrawHitboxComponent;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.edgelord.saltyengine.utils.Directions;

import java.awt.image.BufferedImage;

public class HorizontalWall extends GameObject {

    private BufferedImage image;

    public HorizontalWall(Directions.Direction direction) {
        super(new Coordinates2f(0, 0), 1600, 100, "de.naclstudios.etj.gameObjects.horizontalWall");

        removeComponent(DEFAULT_PHYSICS_NAME);

        if (direction == Directions.Direction.DOWN) {
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_down.png");
        }

        if (direction == Directions.Direction.UP) {
            setY(850);
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_up.png");
        }

        setStationary(true);
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

        graphics.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }
}
