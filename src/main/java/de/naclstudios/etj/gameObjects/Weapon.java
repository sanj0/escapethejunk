package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.cosmetic.Animation;
import de.edgelord.saltyengine.cosmetic.Spritesheet;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.gameobject.components.rendering.AnimationRender;
import de.edgelord.saltyengine.location.Coordinates;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.utils.StaticSystem;
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
        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();
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
