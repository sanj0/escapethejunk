package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.rendering.ImageRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/door.png");
    private ImageRender render = new ImageRender(this, "de.naclstudios.gameObjects.door.imageRender", image.getSubimage(0, 0, 204, 87));

    public Door() {
        super(new Coordinates(Game.getDisplayManager().getHorizontalCenter(204), 25), 204, 87, "de.naclstudios.etj.gameObject.door");

        removeComponent(DEFAULT_PHYSICS_NAME);

        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")){
            Player player = (Player) e.getRoot();

            if (player.getCollectedKeyFragments() == Player.REQUIREDKEYFRAGMENTS){
                // Trigger end of the game
                System.out.println("You win!");
            }
        }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

    }
}
