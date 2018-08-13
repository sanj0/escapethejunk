package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.ImageRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class KeyFragment extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/key.png");
    private ImageRender render = new ImageRender(this, "imageRender", image);

    public KeyFragment(Coordinates coordinates) {
        super(coordinates, 50, 26, "de.naclstudios.etj.gameObjects.keyFragment");

        removeComponent(DEFAULT_PHYSICS_NAME);
        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")){
            Player player = (Player) e.getRoot();

            player.setCollectedKeyFragments(player.getCollectedKeyFragments() + 1);

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
