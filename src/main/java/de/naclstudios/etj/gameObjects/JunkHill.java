package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.rendering.ImageRender;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class JunkHill extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/junk_hill.png");
    private ImageRender imageRender = new ImageRender(this, "de.naclstudios.etj.gameObjects.trashHill.ovalRender", image);
    private List<Integer> hittenByIds = new LinkedList<Integer>();

    private int hitCounter = 0;

    public JunkHill(Vector2f position) {
        super(position, 147, 132, "de.naclstudios.etj.gameObjects.junkHill");

        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();

        addComponent(imageRender);

        getHitboxAsSimpleHitbox().setOffsetX(10);
        getHitboxAsSimpleHitbox().setOffsetY(20);

        getHitboxAsSimpleHitbox().setWidth(127);
        getHitboxAsSimpleHitbox().setHeight(112);

        setStationary(true);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(SaltyGraphics graphics) {

    }

    public void hitByBullet(Bullet bullet) {

        for (int i : hittenByIds) {
            if (bullet.getId() == i) {
                return;
            }
        }

        hittenByIds.add(bullet.getId());

        hitCounter++;

        if (hitCounter >= 3) {
            EscapeTheJunk.sounds.play("junk_destroyed");
            removeFromScene();
        }
    }

    private void removeFromScene() {
        StaticSystem.currentScene.getGameObjects().remove(this);
    }
}
