package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.cosmetic.Animation;
import de.edgelord.saltyengine.cosmetic.Spritesheet;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.gameobject.components.rendering.AnimationRender;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Coordinates;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.Directions;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.Random;

public class Rat extends GameObject {

    private int health = 2;
    private int ticks = 0;
    private Random random = new Random();

    private Spritesheet spritesheet = new Spritesheet(new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/rat.png"), 477, 235);

    private Animation walkRight = new Animation(this);
    private Animation walkLeft = new Animation(this);

    private AnimationRender render = new AnimationRender(this, "animaitonRender");

    public Rat(Vector2f position) {
        super(position, 56, 28, "de.naclstudios.etj.gameObjects.rat");

        removeComponent(DEFAULT_PHYSICS_NAME);

        walkRight.setFrames(spritesheet.getManualFrames(new Coordinates(1, 1), new Coordinates(1, 2), new Coordinates(1, 1), new Coordinates(1, 3)));
        walkLeft.setFrames(spritesheet.getManualFrames(new Coordinates(2, 1), new Coordinates(2, 2), new Coordinates(2, 1), new Coordinates(2, 3)));

        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.bullet")) {
            health--;
        }
    }

    public void onFixedTick() {

        if (health <= 0) {
            EscapeTheJunk.sounds.play("rat_dies");
            spawnKey();
            StaticSystem.currentScene.getGameObjects().remove(this);
        }

        if (ticks == 50) {
            ticks = 0;
            runAway();
        } else {
            ticks++;
        }
    }

    public void onTick() {

    }

    public void draw(SaltyGraphics graphics) {

    }

    private void spawnKey() {

        StaticSystem.currentScene.addGameObject(new KeyFragment(getPosition()));
    }

    private void runAway() {

        int randomDir = random.nextInt(4);

        if (randomDir == 0) {
            if (getPosition().getY() >= 105) {
                move(15f, Directions.Direction.UP);
                return;
            }
        }

        if (randomDir == 1) {
            if (getPosition().getY() <= 840) {
                move(15f, Directions.Direction.DOWN);
                return;
            }
        }

        if (randomDir == 2) {
            if (getPosition().getX() <= 1600 - EscapeTheJunk.currentWallDelta) {
                render.setAnimation(walkRight);
                move(15f, Directions.Direction.RIGHT);
                return;
            }
        }

        if (randomDir == 3) {
            if (getPosition().getX() >= EscapeTheJunk.currentWallDelta) {
                render.setAnimation(walkLeft);
                move(15f, Directions.Direction.LEFT);
            }
        }
    }
}
