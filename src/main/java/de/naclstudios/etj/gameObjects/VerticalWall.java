package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.ImageRender;
import de.edgelord.sjgl.gameobject.components.rendering.RectangleRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.location.Vector2f;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.Directions;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;
import sun.print.DialogOwner;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VerticalWall extends GameObject {

    private Directions.Direction direction;
    private boolean move = true;

    private BufferedImage image;

    private int ticks = 0;

    public VerticalWall(Directions.Direction direction) {
        super(new Coordinates(0, 0), 950, 950, "de.naclstudios.etj.gameObjects.wall");

        this.direction = direction;

        if (direction == Directions.Direction.LEFT){
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_right.png");
            setPosition(new Vector2f(1423, 0));
        } else if (direction == Directions.Direction.RIGHT){
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_left.png");
            setPosition(new Vector2f(-773, 0));
        }

        addComponent(new ImageRender(this, "de.naclstudios.etj.gameObject.walls.imageRender", image));

        removeComponent(DEFAULT_PHYSICS_NAME);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

        if (move) {
            if (ticks == 7000 / StaticSystem.fixedTickMillis) {
                makeMove(25f);
                EscapeTheJunk.currentWallDelta += 12.5f;
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
