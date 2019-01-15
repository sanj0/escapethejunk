package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.edgelord.saltyengine.utils.Directions;
import de.naclstudios.etj.HighscoreAgent;
import de.naclstudios.etj.gameObjects.*;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.Random;

public class GameScene extends Scene {

    public static Player player;
    private Random random = new Random();

    public GameScene() {

        disableGravity();

        EscapeTheJunk.currentWallDelta = 177f;

        player = new Player();

        addGameObject(player);
        addGameObject(new Weapon(new Coordinates2f(Game.getHost().getHorizontalCentrePosition(72) + 100, Game.getHost().getVerticalCentrePosition(65))));

        addRats();
        addJunk();

        addFixedTask(new JunkGenerator());

        addGameObject(new HorizontalWall(Directions.Direction.UP));
        addGameObject(new HorizontalWall(Directions.Direction.DOWN));
        addWalls();

        addDrawingRoutine(new DrawBackground());

        addGameObject(new Door());

        HighscoreAgent.startStopwatch();
    }

    private void addWalls() {

        VerticalWall RIGHT = new VerticalWall(Directions.Direction.LEFT);
        VerticalWall LEFT = new VerticalWall(Directions.Direction.RIGHT);

        addGameObject(RIGHT);
        addGameObject(LEFT);
    }

    private void addRats() {
        for (int i = 0; i < 20; i++) {
            addGameObject(new Rat(getRandomGOPos()));
        }
    }

    private void addJunk() {
        for (int i = 0; i < 30; i++) {
            addGameObject(new Rat(getRandomGOPos()));
        }
    }

    private Coordinates2f getRandomGOPos() {
        return new Coordinates2f(random.nextInt(1600), random.nextInt(950));
    }
}
