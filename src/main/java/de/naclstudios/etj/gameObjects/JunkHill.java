package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.rendering.ImageRender;
import de.edgelord.saltyengine.core.ImageLoader;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.transform.Vector2f;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class JunkHill extends GameObject {

    private BufferedImage image = ImageLoader.getOrLoadImage("junkHill", "pictures/junk_hill.png");
    private ImageRender imageRender = new ImageRender(this, "de.naclstudios.etj.gameObjects.trashHill.ovalRender", image);
    private List<Integer> hitByIds = new LinkedList<Integer>();

    private int hitCounter = 0;

    public JunkHill(Vector2f position) {
        super(position, 147, 132, "de.naclstudios.etj.gameObjects.junkHill");

        // removeComponent(DEFAULT_PHYSICS_NAME);

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

    public void draw(SaltyGraphics graphics) {

    }

    public void hitByBullet(Bullet bullet) {

        for (int i : hitByIds) {
            if (bullet.getId() == i) {
                return;
            }
        }

        hitByIds.add(bullet.getId());

        hitCounter++;

        if (hitCounter >= 2) {
            EscapeTheJunk.sounds.play("junk_destroyed");
            removeFromCurrentScene();
        }
    }
}
