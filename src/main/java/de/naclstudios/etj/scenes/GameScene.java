package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.Directions;
import de.naclstudios.etj.gameObjects.*;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.Random;

public class GameScene extends Scene {

    public static Player player;
    private Random random = new Random();

    public GameScene() {

        EscapeTheJunk.currentWallDelta = 177f;

        player = new Player();

        addGameObject(player);
        addGameObject(new Weapon(new Vector2f(Game.getHost().getHorizontalCentrePosition(72) + 100, Game.getHost().getVerticalCentrePosition(65))));

        addRats();
        addJunk();

        addFixedTask(new JunkGenerator());

        addGameObject(new HorizontalWall(Directions.Direction.UP));
        addGameObject(new HorizontalWall(Directions.Direction.DOWN));
        addWalls();

        addDrawingRoutin(new DrawBackground());

        addGameObject(new Door());
    }

    private void addWalls() {

        VerticalWall RIGHT = new VerticalWall(Directions.Direction.LEFT);
        VerticalWall LEFT = new VerticalWall(Directions.Direction.RIGHT);

        addGameObject(RIGHT);
        addGameObject(LEFT);
    }

    private void addRats() {
        /*
        There would normally be a for or while...
         */
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Vector2f(random.nextInt(1600), random.nextInt(950))));
    }

    private void addJunk() {
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Vector2f(random.nextInt(1600), random.nextInt(950))));
    }
}
