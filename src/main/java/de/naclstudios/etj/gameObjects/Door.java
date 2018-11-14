package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.rendering.ImageRender;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.transform.Vector2f;
import de.naclstudios.etj.main.EscapeTheJunk;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

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

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")) {
            Player player = (Player) e.getRoot();

            if (player.getCollectedKeyFragments() >= Player.REQUIREDKEYFRAGMENTS) {
                EscapeTheJunk.lastGameWon = true;
                try {
                    SceneManager.setCurrentScene("end");
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }
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
        graphics.outlineRect(10, 10, 195, 30);
        graphics.drawRect(10, 10, (float) (200 / Player.REQUIREDKEYFRAGMENTS) * GameScene.player.getCollectedKeyFragments(), 30);
    }
}
