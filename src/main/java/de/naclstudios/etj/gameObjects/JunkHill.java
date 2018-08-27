package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.gameobject.components.rendering.ImageRender;
import de.edgelord.saltyengine.location.Coordinates;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class JunkHill extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/junk_hill.png");
    private ImageRender imageRender = new ImageRender(this, "de.naclstudios.etj.gameObjects.trashHill.ovalRender", image);
    private List<Integer> hittenByIds = new LinkedList<Integer>();

    private int hitCounter = 0;

    public JunkHill(Coordinates coordinates) {
        super(coordinates, 147, 132, "de.naclstudios.etj.gameObjects.junkHill");

        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();

        addComponent(imageRender);

        getHitbox().setOffsetX(10);
        getHitbox().setOffsetY(20);

        getHitbox().setWidth(127);
        getHitbox().setHeight(112);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.wall")){
            EscapeTheJunk.sounds.play("junk_destroyed");
            StaticSystem.currentScene.getGameObjects().remove(this);
        }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }

    public void hitByBullet(Bullet bullet){

        for (int i : hittenByIds){
            if (bullet.getId() == i){
                return;
            }
        }

        hittenByIds.add(bullet.getId());

        hitCounter++;

        if (hitCounter >= 3){
            EscapeTheJunk.sounds.play("junk_destroyed");
            removeFromScene();
        }
    }

    private void removeFromScene(){
        StaticSystem.currentScene.getGameObjects().remove(this);
    }
}
