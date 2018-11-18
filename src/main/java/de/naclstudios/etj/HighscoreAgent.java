package de.naclstudios.etj;

import de.edgelord.saltyengine.io.serialization.Serializable;
import de.edgelord.stdf.Species;
import de.naclstudios.etj.main.EscapeTheJunk;

public class HighscoreAgent implements Serializable {

    private final String HIGHSCORE_TAG = "highscore";

    public void serialize(Species species) {
        species.addTag(HIGHSCORE_TAG, EscapeTheJunk.highScore);
    }

    public void deserialize(Species species) {
        EscapeTheJunk.highScore = Integer.valueOf(species.getTagValue(HIGHSCORE_TAG));
    }

    public String getDataSetName() {
        return "highscore-agent";
    }
}
