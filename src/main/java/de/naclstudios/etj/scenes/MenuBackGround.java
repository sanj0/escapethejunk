package de.naclstudios.etj.scenes;

import de.edgelord.saltyengine.factory.ImageFactory;
import de.edgelord.saltyengine.gameobject.DrawingRoutine;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.resource.InnerResource;

import java.awt.image.BufferedImage;

public class MenuBackGround extends DrawingRoutine {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/grey.png");

    public MenuBackGround() {
        super(DrawingPosition.BEFORE_GAMEOBJECTS);
    }

    public void draw(SaltyGraphics graphics) {

        graphics.drawImage(image, 0, 0, 1600, 950);
    }
}
