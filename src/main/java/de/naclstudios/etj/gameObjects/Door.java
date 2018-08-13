package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.ImageRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.EndScene;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/door.png");
    private ImageRender render = new ImageRender(this, "de.naclstudios.gameObjects.door.imageRender", image.getSubimage(0, 0, 204, 87));

    public Door() {
        super(new Coordinates(Game.getDisplayManager().getHorizontalCenter(204), 25), 204, 87, "de.naclstudios.etj.gameObject.door");

        removeComponent(DEFAULT_PHYSICS_NAME);

        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")){
            Player player = (Player) e.getRoot();

            if (player.getCollectedKeyFragments() >= Player.REQUIREDKEYFRAGMENTS){
                StaticSystem.currentScene = new EndScene(true);
                System.out.println("You win!");
            }
        }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

        graphics2D.setColor(Color.yellow);
        graphics2D.drawRect(10, 10, 195, 30);
        graphics2D.fillRect(10, 10, (200 / Player.REQUIREDKEYFRAGMENTS) * GameScene.player.getCollectedKeyFragments(), 30);
    }
}
