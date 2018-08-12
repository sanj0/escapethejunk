package de.naclstudios.etj.scenes;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.scene.Scene;
import de.edgelord.sjgl.utils.Directions;
import de.naclstudios.etj.gameObjects.*;

import java.util.Random;

public class GameScene extends Scene {

    public static Player player = new Player();
    private Random random = new Random();

    public GameScene() {

        addGameObject(player);
        addGameObject(new Weapon(new Coordinates(Game.getDisplayManager().getHorizontalCenter(72) + 100, Game.getDisplayManager().getVerticalCenter(65))));

        addJunk();

        addGameObject(new JunkGenerator());

        addWalls();
    }

    private void addWalls(){


        Wall above = new Wall(new Coordinates(0, 0), 1600, 100, Directions.Direction.down);
        above.setMove(false);
        Wall bottom = new Wall(new Coordinates(0, 850), 1600, 100, Directions.Direction.up);
        bottom.setMove(false);
        Wall right = new Wall(new Coordinates(1500, 100), 100, 750, Directions.Direction.left);

        Wall left = new Wall(new Coordinates(0, 100), 100, 750, Directions.Direction.right);

        addGameObject(above);
        addGameObject(bottom);
        addGameObject(right);
        addGameObject(left);
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
