package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.FixedTask;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.*;
import java.util.Random;

public class JunkGenerator implements FixedTask {

    private int ticks = 0;
    private Random random = new Random();

    public static int spawnRate = 1500;

    public JunkGenerator() {
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

        int min = (int) EscapeTheJunk.currentWallDelta;
        int maxX = (int) (1600 - EscapeTheJunk.currentWallDelta);

        if (ticks == spawnRate * StaticSystem.fixedTickMillis){
            StaticSystem.currentScene.getGameObjects().add(StaticSystem.currentScene.getGameObjects().size() - 5, new JunkHill(new Coordinates(random.nextInt(maxX - min) + min, random.nextInt(620 - 100) + 100)));

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
