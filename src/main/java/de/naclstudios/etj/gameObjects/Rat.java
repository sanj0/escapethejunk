package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.RectangleRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.utils.Directions;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.*;
import java.util.Random;

public class Rat extends GameObject {

    private int health = 2;
    private int ticks = 0;
    private Random random = new Random();

    public Rat(Coordinates coordinates) {
        super(coordinates, 47, 23, "de.naclstudios.etj.gameObjects.rat");

        removeComponent(DEFAULT_PHYSICS_NAME);
        addComponent(new RectangleRender(this, "test"));
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.bullet")){
            health--;
        }
    }

    public void onFixedTick() {

        if (health <= 0){
            spawnKey();
            StaticSystem.currentScene.getGameObjects().remove(this);
        }

        if (ticks == 50){
            ticks = 0;
            runAway();
        } else {
            ticks++;
        }
    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }

    private void spawnKey(){

        if (GameScene.player.getCollectedKeyFragments() < Player.REQUIREDKEYFRAGMENTS) {
            StaticSystem.currentScene.addGameObject(new KeyFragment(getCoordinates()));
        }
    }

    private void runAway(){

        int randomDir = random.nextInt(4);

        if (randomDir == 0){
            if (getPosition().getY() >= 105) {
                move(15f, Directions.Direction.UP);
                return;
            }
        }

        if (randomDir == 1){
            if (getPosition().getY() <= 840) {
                move(15f, Directions.Direction.DOWN);
                return;
            }
        }

        if (randomDir == 2){
            if (getPosition().getX() <= 1600 - EscapeTheJunk.currentWallDelta) {
                move(15f, Directions.Direction.RIGHT);
                return;
            }
        }

        if (randomDir == 3){
            if (getPosition().getX() >= EscapeTheJunk.currentWallDelta) {
                move(15f, Directions.Direction.LEFT);
            }
        }
    }
}
