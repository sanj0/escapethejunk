package de.naclstudios.etj.gameObjects;

import de.edgelord.sjgl.core.Game;
import de.edgelord.sjgl.core.event.CollisionEvent;
import de.edgelord.sjgl.cosmetic.Animation;
import de.edgelord.sjgl.cosmetic.Spritesheet;
import de.edgelord.sjgl.factory.ImageFactory;
import de.edgelord.sjgl.gameobject.GameObject;
import de.edgelord.sjgl.gameobject.components.DrawHitboxComponent;
import de.edgelord.sjgl.gameobject.components.SimplePhysicsComponent;
import de.edgelord.sjgl.gameobject.components.rendering.AnimationRender;
import de.edgelord.sjgl.location.Coordinates;
import de.edgelord.sjgl.resource.InnerResource;
import de.edgelord.sjgl.utils.Directions;
import de.edgelord.sjgl.utils.StaticSystem;
import de.naclstudios.etj.scenes.EndScene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Player extends GameObject {

    private int collectedKeyFragments = 0;
    public static final int REQUIREDKEYFRAGMENTS = 7;

    private ImageFactory imageFactory = new ImageFactory(new InnerResource());

    private AnimationRender animationRender = new AnimationRender(this, "de.naclstudios.etj.gameObjects.player.animationRender");

    private Spritesheet mainCharSpriteSheet = new Spritesheet(imageFactory.getOptimizedImageResource("pictures/mainchar.png"), 143, 184);

    private Animation walkUp = new Animation(this);
    private Animation walkDown = new Animation(this);
    private Animation walkRight = new Animation(this);
    private Animation walkLeft = new Animation(this);

    private BufferedImage up = mainCharSpriteSheet.getManualSprite(1, 1);
    private BufferedImage down = mainCharSpriteSheet.getManualSprite(2, 1);
    private BufferedImage right = mainCharSpriteSheet.getManualSprite(3, 1);
    private BufferedImage left = mainCharSpriteSheet.getManualSprite(5, 1);

    private BufferedImage currentFreezeImage;

    private Coordinates[] walkUpSprites = {new Coordinates(1, 1), new Coordinates(1, 2), new Coordinates(1, 1), new Coordinates(1, 3)};
    private Coordinates[] walkDownSprites = {new Coordinates(2, 1), new Coordinates(2, 2), new Coordinates(2, 1), new Coordinates(2, 3)};
    private Coordinates[] walkRightSprites = {new Coordinates(3, 1), new Coordinates(3, 2), new Coordinates(3, 1), new Coordinates(3, 3)};
    private Coordinates[] walkLeftSprites = {new Coordinates(6, 1), new Coordinates(6, 2), new Coordinates(6, 1), new Coordinates(6, 3)};

    private Coordinates[] walkUpSpritesWeapon = {new Coordinates(1, 4), new Coordinates(1, 5), new Coordinates(1, 4), new Coordinates(1, 6)};
    private Coordinates[] walkDownSpritesWeapon = {new Coordinates(2, 4), new Coordinates(2, 5), new Coordinates(2, 4), new Coordinates(2, 6)};
    private Coordinates[] walkRightSpritesWeapon = {new Coordinates(4, 1), new Coordinates(4, 2), new Coordinates(4, 1), new Coordinates(4, 3)};
    private Coordinates[] walkLeftSpritesWeapon = {new Coordinates(5, 4), new Coordinates(5, 5), new Coordinates(5, 4), new Coordinates(5, 6)};

    private Directions.Direction currentDirection;
    private boolean freeze = true;

    private boolean hasWeapon = false;
    private int weaponCooldown = (int) (350 * StaticSystem.fixedTickMillis);
    private boolean cooldown = false;
    private int ticks = 0;

    private int secureTicks = 0;

    public Player() {
        super(Game.getDisplayManager().getCenter(71, 91), 71, 91, "de.naclstudios.etj.gameObject.player");

        animationRender.setTicksPerFrame((int) (175 / StaticSystem.fixedTickMillis));

        // removeComponent(DEFAULT_PHYSICS_NAME);
        getPhysics().removeGravity();
        addComponent(animationRender);
        currentDirection = Directions.Direction.DOWN;
        readAnimation();
    }

    public void initialize() {
    }

    public void onCollision(CollisionEvent e) {

        if (e.getRoot().getTag().equals("de.naclstudios.etj.gameObjects.wall")){
            if (secureTicks > 10) {
                StaticSystem.currentScene = new EndScene(false);
            }
        }
    }

    public void onFixedTick() {

        freeze = true;

        if (secureTicks < 300) {
            secureTicks++;
        }

        if (StaticSystem.inputUp) {

            currentDirection = Directions.Direction.UP;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_UPWARDS_FORCE).setVelocity(0.35f);
            freeze = false;
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_UPWARDS_FORCE).setVelocity(0f);
        }

        if (StaticSystem.inputDown) {
            currentDirection = Directions.Direction.DOWN;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_DOWNWARDS_FORCE).setVelocity(0.35f);
            freeze = false;
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_DOWNWARDS_FORCE).setVelocity(0f);
        }

        if (StaticSystem.inputRight) {
            currentDirection = Directions.Direction.RIGHT;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_RIGHTWARDS_FORCE).setVelocity(0.35f);
            freeze = false;
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_RIGHTWARDS_FORCE).setVelocity(0f);
        }

        if (StaticSystem.inputLeft) {
            currentDirection = Directions.Direction.LEFT;
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_LEFTWARDS_FORCE).setVelocity(0.35f);
            freeze = false;
        } else {
            getPhysics().getForce(SimplePhysicsComponent.DEFAULT_LEFTWARDS_FORCE).setVelocity(0f);
        }

        if (currentDirection != null) {
            switch (currentDirection) {

                case RIGHT:
                    animationRender.setAnimation(walkRight);
                    currentFreezeImage = right;
                    setSlimHitbox();
                    break;
                case LEFT:
                    animationRender.setAnimation(walkLeft);
                    currentFreezeImage = left;
                    setSlimHitbox();
                    break;
                case UP:
                    animationRender.setAnimation(walkUp);
                    currentFreezeImage = up;
                    setBigHitbox();
                    break;
                case DOWN:
                    animationRender.setAnimation(walkDown);
                    currentFreezeImage = down;
                    setBigHitbox();
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

        if (freeze) {
            animationRender.disable();
            graphics2D.drawImage(currentFreezeImage, getCoordinates().getX(), getCoordinates().getY(), getWidth(), getHeight(), null);
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

    private void setSlimHitbox() {
        getHitbox().setOffsetX(14);
        getHitbox().setWidth(45);
    }

    private void setBigHitbox() {
        getHitbox().setWidth(71);
        getHitbox().setOffsetX(0);
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;

        if (hasWeapon){
            walkUp.setFrames(mainCharSpriteSheet.getManualFrames(walkUpSpritesWeapon));
            walkDown.setFrames(mainCharSpriteSheet.getManualFrames(walkDownSpritesWeapon));
            walkLeft.setFrames(mainCharSpriteSheet.getManualFrames(walkLeftSpritesWeapon));
            walkRight.setFrames(mainCharSpriteSheet.getManualFrames(walkRightSpritesWeapon));

            up = mainCharSpriteSheet.getManualSprite(1, 4);
            down = mainCharSpriteSheet.getManualSprite(2, 4);
            right = mainCharSpriteSheet.getManualSprite(4, 1);
            left = mainCharSpriteSheet.getManualSprite(5, 4);
        }
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

    public int getCollectedKeyFragments() {
        return collectedKeyFragments;
    }

    public void setCollectedKeyFragments(int collectedKeyFragments) {
        this.collectedKeyFragments = collectedKeyFragments;
    }
}
