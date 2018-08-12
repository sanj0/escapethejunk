package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;
import java.util.Random;

public class JunkGenerator extends GameObject {

    private int ticks = 0;
    private Random random = new Random();

    public static int spawnRate = 4000;

    public JunkGenerator() {
        super (new Coordinates(99999, 29173489), 0, 0, "de.naclstudios.etj.junkGenerator");
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

        if (ticks == spawnRate * StaticSystem.fixedTickMillis){
            synchronized (StaticSystem.currentScene.getGameObjects()) {
                StaticSystem.currentScene.getGameObjects().add(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
            }

            ticks = 0;
        } else {

            ticks++;
        }
    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }
}
