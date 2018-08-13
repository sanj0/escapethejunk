package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.Directions;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HorizontalWall extends GameObject {

    private BufferedImage image;

    public HorizontalWall(Directions.Direction direction) {
        super(new Coordinates(0, 0), 1600, 100, "de.naclstudios.etj.gameObjects.horizontalWall");

        removeComponent(DEFAULT_PHYSICS_NAME);

        if (direction == Directions.Direction.DOWN){
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_down.png");
        }

        if (direction == Directions.Direction.UP){
            setY(850);
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_up.png");
        }
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

        graphics2D.drawImage(image, getCoordinates().getX(), getCoordinates().getY(), getWidth(), getHeight(), null);
    }
}
