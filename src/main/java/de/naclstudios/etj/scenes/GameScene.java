package de.naclstudios.etj.scenes;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.scene.Scene;
import de.edgelord.sjgl.utils.Directions;
import de.naclstudios.etj.gameObjects.*;

import java.util.Random;

public class GameScene extends Scene {

    public static Player player;
    private Random random = new Random();

    public GameScene() {

        player = new Player();

        addGameObject(player);
        addGameObject(new Weapon(new Coordinates(Game.getDisplayManager().getHorizontalCenter(72) + 100, Game.getDisplayManager().getVerticalCenter(65))));

        addRats();
        addJunk();

        addFixedTask(new JunkGenerator());

        addGameObject(new HorizontalWall(Directions.Direction.UP));
        addGameObject(new HorizontalWall(Directions.Direction.DOWN));
        addWalls();

        addDrawingRoutin(new DrawBackground());

        addGameObject(new Door());
    }

    private void addWalls(){

        VerticalWall RIGHT = new VerticalWall(Directions.Direction.LEFT);
        VerticalWall LEFT = new VerticalWall(Directions.Direction.RIGHT);

        addGameObject(RIGHT);
        addGameObject(LEFT);
    }

    private void addRats(){
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new Rat(new Coordinates(random.nextInt(1600), random.nextInt(950))));
    }

    private void addJunk(){
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
        addGameObject(new JunkHill(new Coordinates(random.nextInt(1600), random.nextInt(950))));
    }
}
