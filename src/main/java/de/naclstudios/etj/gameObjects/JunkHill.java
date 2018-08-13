package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.DrawHitboxComponent;
import de.edgelord.sjgl.gameobject.components.DrawPositionComponent;
import de.edgelord.sjgl.gameobject.components.PushInTheOppositeDirectionOnCollision;
import de.edgelord.sjgl.gameobject.components.rendering.ImageRender;
import de.edgelord.sjgl.gameobject.components.rendering.OvalRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.StaticSystem;

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
        super(coordinates, 147, 130, "de.naclstudios.etj.gameObjects.junkHill");

        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();

        addComponent(imageRender);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.wall")){
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
            getTheFuckOutOfMyRoomImPlayingMinecraft();
        }
    }

    private void getTheFuckOutOfMyRoomImPlayingMinecraft(){
        StaticSystem.currentScene.getGameObjects().remove(this);
    }
}
