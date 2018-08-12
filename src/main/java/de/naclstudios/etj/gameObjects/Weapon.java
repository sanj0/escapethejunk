package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.cosmetic.Animation;
import de.edgelord.sjgl.cosmetic.Spritesheet;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.AnimationRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.GameScene;

import java.awt.*;

public class Weapon extends GameObject {

    private ImageFactory imageFactory = new ImageFactory(new InnerResource());
    private Spritesheet spritesheet = new Spritesheet(imageFactory.getOptimizedImageResource("pictures/weapon-on_ground.png"), 533, 478);
    private Animation animation = new Animation(this);
    private AnimationRender animationRender = new AnimationRender(this, "de.naclstudios.etj.gameObjects.weapon.animationRender", animation, (int) (175 * StaticSystem.fixedTickMillis));

    public Weapon(Coordinates coordinates) {
        super(coordinates, 72, 65, "de.naclstudios.etj.gameObjects.weapon");

        animation.setFrames(spritesheet.getManualFrames(new Coordinates(1, 1), new Coordinates(2, 1)));

        addComponent(animationRender);
        removeComponent(DEFAULT_PHYSICS_NAME);
        removeComponent(DEFAULT_PUSH_OUT_ON_COLLISION_NAME);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent collisionEvent) {

            if (collisionEvent.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")) {
                GameScene.player.setHasWeapon(true);
                StaticSystem.currentScene.getGameObjects().remove(this);
            }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }
}
