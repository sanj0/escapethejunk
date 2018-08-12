package de.naclstudios.etj.gameObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BulletIdManager {

    private static List<Integer> ids = new LinkedList<Integer>();
    private static Random idGenerator = new Random();

    public static int getNewId(){

        int id = idGenerator.nextInt();
        boolean readyToReturn = false;

        if (ids.size() != 0) {
            while (!readyToReturn) {
                for (int i : ids) {
                    if (id == i) {
                        readyToReturn = false;
                        break;
                    } else {
                        readyToReturn = true;
                    }
                }
            }
        } else {
            return id;
        }

        return id;
    }
}
