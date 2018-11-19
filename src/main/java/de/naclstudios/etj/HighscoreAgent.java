package de.naclstudios.etj;

import de.edgelord.saltyengine.io.serialization.Serializable;
import de.edgelord.stdf.Species;
import de.naclstudios.etj.main.EscapeTheJunk;

import java.util.concurrent.TimeUnit;

public class HighscoreAgent implements Serializable {

    private final String HIGHSCORE_TAG = "highscore";

    private static long startTime = 0;
    private static boolean timerIsRunning = false;

    public static void startStopwatch() {
        startTime = System.currentTimeMillis();
        timerIsRunning = true;
    }

    public static void stopStopwatch() {
        EscapeTheJunk.highScore = Math.min(System.currentTimeMillis() - startTime, EscapeTheJunk.highScore);
        timerIsRunning = false;
    }

    public static long getCurrentTime() {
        if (timerIsRunning) {
            return System.currentTimeMillis() - startTime;
        }

        return 0;
    }

    public static String getCurrentTimeAsReadable() {
        if (timerIsRunning) {
            return getAsMinutesSecondsMillis(getCurrentTime());
        }

        return "0";
    }

    public static String getAsMinutesSecondsMillis(long millis) {
        return String.format("%02d.%02d,%d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                TimeUnit.MILLISECONDS.toMillis(millis) -
                        TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))
        );
    }

    public void serialize(Species species) {
        species.addTag(HIGHSCORE_TAG, EscapeTheJunk.highScore);
    }

    public void deserialize(Species species) {
        EscapeTheJunk.highScore = Integer.valueOf(species.getTagValue(HIGHSCORE_TAG));
        System.out.println(EscapeTheJunk.highScore);
    }

    public String getDataSetName() {
        return "highscore-agent";
    }
}
