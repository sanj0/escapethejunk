package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.DrawingRoutin;
import de.edgelord.sjgl.resource.InnerResource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawBackground implements DrawingRoutin {

    private BufferedImage image = new ImageFactory(new InnerResource()).getOptimizedImageResource("pictures/environment.png");

    public void draw(Graphics2D graphics2D) {

        graphics2D.drawImage(image, 0, 0, 1600, 950, null);
    }
}
