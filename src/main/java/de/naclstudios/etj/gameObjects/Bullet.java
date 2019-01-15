package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.DrawHitboxComponent;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.edgelord.saltyengine.utils.Directions;
import de.edgelord.saltyengine.utils.SaltySystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.*;

public class Bullet extends GameObject {

    public static float DEFAULT_RANGE = 550;
    public static float DEFAULT_VELOCITY = 0.85f;
    public static Color color = Color.black;

    private int id = BulletIdManager.getNewId();

    private float range = DEFAULT_RANGE;
    private float velocity = DEFAULT_VELOCITY;
    private float delta = 0f;
    private Directions.Direction direction;
    private boolean deprecated = false;

    public Bullet(Coordinates2f position, Directions.Direction direction) {
        super(position, 12, 7, "de.naclstudios.etj.gameObjects.bullet");

        this.direction = direction;

        removeComponent(DEFAULT_PHYSICS_NAME);

        if (direction == Directions.Direction.UP || direction == Directions.Direction.DOWN) {
            setWidth(7);
            setHeight(12);
        }

        EscapeTheJunk.sounds.play("shot");
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.junkHill")) {

            JunkHill junkHill = (JunkHill) e.getRoot();

            junkHill.hitByBullet(this);
        }

        if (!e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player") && !e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.keyFragment")) {

            removeFromCurrentScene();
        }

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.rat")) {
            Rat rat = (Rat) e.getRoot();

            rat.bulletHit();
        }
    }

    public void onFixedTick() {

        if (delta >= range) {
            removeFromCurrentScene();
        } else {
            float nextStep = velocity * SaltySystem.fixedTickMillis;
            if (direction == null) {
            } else {
                move(nextStep, direction);
                delta += nextStep;
            }
        }
    }

    public void draw(SaltyGraphics graphics) {

        if (!isDeprecated()) {
            graphics.setColor(color);
            graphics.drawOval(getX(), getY(), getWidth(), getHeight());
        }
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Directions.Direction getDirection() {
        return direction;
    }

    public void setDirection(Directions.Direction direction) {
        this.direction = direction;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public int getId() {
        return id;
    }
}
