package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.components.DrawHitboxComponent;
import de.edgelord.saltyengine.components.rendering.ImageRender;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Coordinates2f;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.image.BufferedImage;

public class KeyFragment extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/key.png");
    private ImageRender render = new ImageRender(this, "imageRender", image);

    public KeyFragment(Coordinates2f position) {
        super(position, 50, 26, "de.naclstudios.etj.gameObjects.keyFragment");

        removeComponent(DEFAULT_PHYSICS_NAME);
        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")) {

            EscapeTheJunk.sounds.play("key_collected");
            Player player = (Player) e.getRoot();

            player.setCollectedKeyFragments(player.getCollectedKeyFragments() + 1);

            removeFromCurrentScene();
        }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(SaltyGraphics graphics) {

    }
}
