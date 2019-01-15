package de.naclstudios.etj.gameObjects;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.gameobject.DrawingRoutine;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.utils.ColorUtil;
import de.naclstudios.etj.HighscoreAgent;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.awt.*;

public class HighScoreScreen extends DrawingRoutine {

    public static final Color color = ColorUtil.changeBrightness(Color.yellow, -0.125f);

    public HighScoreScreen() {
        super(DrawingPosition.AFTER_GAMEOBJECTS);
    }

    public void draw(SaltyGraphics graphics) {

        String highscore = "Best time: ";

        if (EscapeTheJunk.highScore <= 0) {
            highscore += HighscoreAgent.getCurrentTimeAsReadable();
        } else {
            highscore += HighscoreAgent.getAsMinutesSecondsMillis(EscapeTheJunk.highScore);
        }

        graphics.setColor(color);
        graphics.setFont(graphics.getFont().deriveFont(25f));
        graphics.setFont(graphics.getFont().deriveFont(Font.PLAIN));

        graphics.drawText(highscore, Game.getHost().getHorizontalCentrePosition(graphics.getFontMetrics().stringWidth(highscore)), 50);
    }
}
