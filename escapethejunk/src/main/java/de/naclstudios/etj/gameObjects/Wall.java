package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.RectangleRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.utils.Directions;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;

public class Wall extends GameObject {

    private Directions.Direction direction;
    private boolean move = true;

    private int ticks = 0;

    private RectangleRender rectangleRender = new RectangleRender(this, "recatngleRender");

    public Wall(Coordinates coordinates, int width, int height, Directions.Direction direction) {
        super(coordinates, width, height, "de.naclstudios.etj.gameObjects.wall");

        this.direction = direction;

        addComponent(rectangleRender);
        removeComponent(DEFAULT_PHYSICS_NAME);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

        if (move) {
            if (ticks == 7000 / StaticSystem.fixedTickMillis) {
                makeMove(25f);t
                ticks = 0;
            } else {
                ticks++;
            }
        }
    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }

    public void makeMove(float delta){

        move(delta, direction);
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
