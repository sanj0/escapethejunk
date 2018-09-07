package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.gameobject.components.rendering.ImageRender;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;
import de.edgelord.saltyengine.transform.Vector2f;
import de.edgelord.saltyengine.utils.StaticSystem;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.image.BufferedImage;

public class KeyFragment extends GameObject {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/key.png");
    private ImageRender render = new ImageRender(this, "imageRender", image);

    public KeyFragment(Vector2f position) {
        super(position, 50, 26, "de.naclstudios.etj.gameObjects.keyFragment");

        removeComponent(DEFAULT_PHYSICS_NAME);
        addComponent(render);
    }

    public void initialize() {

    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObject.player")){

            EscapeTheJunk.sounds.play("key_collected");
            Player player = (Player) e.getRoot();

            player.setCollectedKeyFragments(player.getCollectedKeyFragments() + 1);

            StaticSystem.currentScene.getGameObjects().remove(this);
        }
    }

    public void onFixedTick() {

    }

    public void onTick() {

    }

    public void draw(SaltyGraphics graphics) {

    }
}
