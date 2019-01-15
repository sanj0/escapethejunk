package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.DrawHitboxComponent;
import de.edgelord.saltyengine.components.rendering.ImageRender;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.edgelord.saltyengine.utils.Directions;
import de.edgelord.saltyengine.utils.SaltySystem;
import de.naclstudios.etj.main.EscapeTheJunk;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.image.BufferedImage;

public class VerticalWall extends GameObject {

    private Directions.Direction direction;
    private boolean move = true;

    private BufferedImage image;

    private int ticks = 0;

    public VerticalWall(Directions.Direction direction) {
        super(new Coordinates2f(-1000, -1000), 950, 950, "de.naclstudios.etj.gameObjects.wall");

        this.direction = direction;
        if (direction == Directions.Direction.LEFT) {
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_right.png");
            setPosition(new Coordinates2f(1423, 0));
        } else if (direction == Directions.Direction.RIGHT) {
            image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/walls/wall_left.png");
            setPosition(new Coordinates2f(-773, 0));
        }

        addComponent(new ImageRender(this, "de.naclstudios.etj.gameObject.walls.imageRender", image));

        removeComponent(DEFAULT_PHYSICS_NAME);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")) {
            GameScene.player.move(12.5f, direction);
        }

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.junkHill")) {
            EscapeTheJunk.sounds.play("junk_destroyed");
            e.getRoot().removeFromCurrentScene();
        }
    }

    public void onFixedTick() {

        if (move) {
            if (ticks == 2500 / SaltySystem.fixedTickMillis) {
                makeMove(25f);
                EscapeTheJunk.currentWallDelta += 12.5f;
                ticks = 0;
            } else {
                ticks++;
            }
        }
    }

    public void draw(SaltyGraphics graphics) {

    }

    public void makeMove(float delta) {

        if (direction == Directions.Direction.RIGHT) {
            if (GameScene.player.getX() <= (getX() + getWidth() + delta)) {
                GameScene.player.move(50f, direction);
            }
        } else {
            if (GameScene.player.getX() >= getX() + delta) {
                GameScene.player.move(-50f, direction);
            }
        }
        move(delta, direction);
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public Directions.Direction getDirection() {
        return direction;
    }
}
