package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.gameobject.FixedTask;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.Random;

public class JunkGenerator implements FixedTask {

    private int ticks = 0;
    private Random random = new Random();

    public static int spawnRate = 1000;

    public JunkGenerator() {
    }

    public void onFixedTick() {

        int min = (int) EscapeTheJunk.currentWallDelta;
        int maxX = (int) (1600 - EscapeTheJunk.currentWallDelta);

        if (ticks == spawnRate * StaticSystem.fixedTickMillis){
            if (maxX - min > 0) {
                StaticSystem.currentScene.getGameObjects().add(StaticSystem.currentScene.getGameObjects().size() - 5, new JunkHill(new Vector2f(random.nextInt(maxX - min) + min, random.nextInt(620 - 100) + 100)));
            }

            ticks = 0;
        } else {

            ticks++;
        }
    }
}
