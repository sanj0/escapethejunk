package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.PushInTheOppositeDirectionOnCollision;
import de.edgelord.sjgl.gameobject.components.rendering.OvalRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class JunkHill extends GameObject {

    private OvalRender ovalRender = new OvalRender(this, "de.naclstudios.etj.gameObjects.trashHill.ovalRender");
    private List<Integer> hittenByIds = new LinkedList<Integer>();

    private int hitCounter = 0;

    public JunkHill(Coordinates coordinates) {
        super(coordinates, 100, 100, "de.naclstudios.etj.gameObjects.junkHill");

        removeComponent(DEFAULT_PHYSICS_NAME);
        removeComponent(DEFAULT_PUSH_OUT_ON_COLLISION_NAME);

        addComponent(ovalRender);
        addComponent(new PushInTheOppositeDirectionOnCollision(this, "test"));
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

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
