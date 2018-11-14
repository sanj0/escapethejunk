package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.gameobject.FixedTask;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.SaltySystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.Random;

public class JunkGenerator extends FixedTask {

    private int ticks = 0;
    private Random random = new Random();

    public static int spawnRate = 1000;

    public JunkGenerator() {
    }

    public void onFixedTick() {

        int min = (int) EscapeTheJunk.currentWallDelta;
        int maxX = (int) (1600 - EscapeTheJunk.currentWallDelta);

        if (ticks == spawnRate * SaltySystem.fixedTickMillis) {
            if (maxX - min > 0) {
                SceneManager.getCurrentScene().addGameObject(SceneManager.getCurrentScene().getGameObjectCount() - 5, new JunkHill(new Vector2f(random.nextInt(maxX - min) + min, random.nextInt(620 - 100) + 100)));
            }

            ticks = 0;
        } else {

            ticks++;
        }
    }
}
