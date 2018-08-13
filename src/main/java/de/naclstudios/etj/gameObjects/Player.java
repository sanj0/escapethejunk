package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.cosmetic.Animation;
import de.edgelord.sjgl.cosmetic.Spritesheet;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.SimplePhysicsComponent;
import de.edgelord.sjgl.gameobject.components.rendering.AnimationRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.Directions;
import de.edgelord.sjgl.utils.StaticSystem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private ImageFactory imageFactory = new ImageFactory(new InnerResource());

    private AnimationRender animationRender = new AnimationRender(this, "de.naclstudios.etj.gameObjects.player.animationRender");

    private Spritesheet mainCharSpriteSheet = new Spritesheet(imageFactory.getOptimizedImageResource("pictures/mainchar.png"), 143, 182);

    private Animation walkUp = new Animation(this);
    private Animation walkDown = new Animation(this);
    private Animation walkRight = new Animation(this);
    private Animation walkLeft = new Animation(this);

    private Coordinates[] walkUpSprites = {new Coordinates(1, 1), new Coordinates(1, 2), new Coordinates(1, 1), new Coordinates(1, 3)};
    private Coordinates[] walkDownSprites = {new Coordinates(2, 4), new Coordinates(2, 5), new Coordinates(2, 4), new Coordinates(2, 6)};
    private Coordinates[] walkRightSprites = {new Coordinates(5, 1), new Coordinates(5, 2), new Coordinates(5, 1), new Coordinates(5, 3)};
    private Coordinates[] walkLeftSprites = {new Coordinates(6, 1), new Coordinates(6, 2), new Coordinates(6, 1), new Coordinates(6, 3)};

    private Directions.Direction currentDirection = null;

    private boolean hasWeapon = false;
    private int weaponCooldown = (int) (350 * StaticSystem.fixedTickMillis);
    private boolean cooldown = false;
    private int ticks = 0;

    public Player() {
        super(Game.getDisplayManager().getCenter(71, 91), 71, 91, "de.naclstudios.etj.gameObject.player");

        animationRender.setTicksPerFrame((int) (175 / StaticSystem.fixedTickMillis));

        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();
        addComponent(animationRender);

        readAnimation();
    }

    public void initialize() {
    }

    public void onCollision(CollisionEvent collisionEvent) {

    }

    public void onFixedTick() {

        if (StaticSystem.inputUp) {
            currentDirection = Directions.Direction.UP;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_UPWARDS_FORCE).setAcceleration(0.0025f);
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_UPWARDS_FORCE).setAcceleration(0f);
        }

        if (StaticSystem.inputDown) {
            currentDirection = Directions.Direction.DOWN;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_DOWNWARDS_FORCE).setAcceleration(0.0025f);
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_DOWNWARDS_FORCE).setAcceleration(0f);
        }

        if (StaticSystem.inputRight) {
            currentDirection = Directions.Direction.RIGHT;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_RIGHTWARDS_FORCE).setAcceleration(0.0025f);
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_RIGHTWARDS_FORCE).setAcceleration(0f);
        }

        if (StaticSystem.inputLeft) {
            currentDirection = Directions.Direction.LEFT;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_LEFTWARDS_FORCE).setAcceleration(0.0025f);
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_LEFTWARDS_FORCE).setAcceleration(0f);
        }

        if (currentDirection != null) {
            switch (currentDirection) {

                case RIGHT:
                    animationRender.setAnimation(walkRight);
                    break;
                case LEFT:
                    animationRender.setAnimation(walkLeft);
                    break;
                case UP:
                    animationRender.setAnimation(walkUp);
                    break;
                case DOWN:
                    animationRender.setAnimation(walkDown);
                    break;
            }
        }

        if (cooldown){
            ticks++;
        }

        if (ticks == weaponCooldown){
            cooldown = false;
            ticks = 0;
        }

        if (StaticSystem.input != null) {
            if (StaticSystem.input.getKeyCode() == KeyEvent.VK_SPACE) {
                shoot();
            }
        }
    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics2D) {

        if (currentDirection == null) {
            animationRender.disable();
        } else {
            animationRender.enable();
        }
    }

    private void shoot() {

        if (hasWeapon && !cooldown) {

            cooldown = true;

            if (currentDirection == null){

                StaticSystem.currentScene.addGameObject(new Bullet(new Coordinates(getCoordinates().getX() + 50, getCoordinates().getY() + 53), Directions.Direction.DOWN));
            } else {
                switch (currentDirection){


                    case RIGHT: StaticSystem.currentScene.addGameObject(new Bullet(new Coordinates(getCoordinates().getX() + 25, getCoordinates().getY() + 53), Directions.Direction.RIGHT));
                        break;
                    case LEFT: StaticSystem.currentScene.addGameObject(new Bullet(new Coordinates(getCoordinates().getX() + 25, getCoordinates().getY() + 53), Directions.Direction.LEFT));
                        break;
                    case   UP: StaticSystem.currentScene.addGameObject(new Bullet(new Coordinates(getCoordinates().getX() + 50, getCoordinates().getY() + 53), Directions.Direction.UP));
                        break;
                    case DOWN: StaticSystem.currentScene.addGameObject(new Bullet(new Coordinates(getCoordinates().getX() + 50, getCoordinates().getY() + 53), Directions.Direction.DOWN));
                        break;
                }
            }
        }
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    private void readAnimation() {
        walkUp.setFrames(mainCharSpriteSheet.getManualFrames(walkUpSprites));
        walkDown.setFrames(mainCharSpriteSheet.getManualFrames(walkDownSprites));
        walkRight.setFrames(mainCharSpriteSheet.getManualFrames(walkRightSprites));
        walkLeft.setFrames(mainCharSpriteSheet.getManualFrames(walkLeftSprites));
    }

    public void readAnimationWithWeapon() {
        mainCharSpriteSheet = new Spritesheet(imageFactory.getOptimizedImageResource("pictures/mainchar-with-weapon.png"), 143, 182);
        readAnimation();
    }
}
