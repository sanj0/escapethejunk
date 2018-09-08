package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.gameobject.components.rendering.ImageRender;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.scenes.EndScene;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/door.png");
    private ImageRender render = new ImageRender(this, "de.naclstudios.gameObjects.door.imageRender", image.getSubimage(0, 0, 204, 87));

    public Door() {
        super(new Vector2f(Game.getHost().getHorizontalCentrePosition(204), 25), 204, 87, "de.naclstudios.etj.gameObject.door");

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

    public void draw(SaltyGraphics graphics) {

        graphics.setColor(Color.yellow);
        graphics.drawRect(10, 10, 195, 30);
        graphics.fillRect(10, 10, (float) (200 / Player.REQUIREDKEYFRAGMENTS) * GameScene.player.getCollectedKeyFragments(), 30);
    }
}
