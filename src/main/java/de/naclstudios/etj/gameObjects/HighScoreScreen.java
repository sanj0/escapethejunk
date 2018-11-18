package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.gameobject.DrawingRoutine;
import de.edgelord.saltyengine.graphics.SaltyGraphics;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.*;

public class HighScoreScreen extends DrawingRoutine {
    public HighScoreScreen() {
        super(DrawingPosition.AFTER_GAMEOBJECTS);
    }

    public void draw(SaltyGraphics graphics) {

        String highscore = "Highscore: " + EscapeTheJunk.highScore;

        graphics.setColor(Color.yellow);
        graphics.setFont(graphics.getFont().deriveFont(25f));
        graphics.setFont(graphics.getFont().deriveFont(Font.BOLD));

        graphics.drawText(highscore, Game.getHost().getHorizontalCentrePosition(graphics.getFontMetrics().stringWidth(highscore)), 50);
    }
}
