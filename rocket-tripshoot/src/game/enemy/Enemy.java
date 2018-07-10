package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import effect.Shield;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.Collider;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameObject implements Collider {

    public Vector2D velocity;


    public BoxCollider boxCollider;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vector2D velocity = player.position
                    .subtract(this.position)
                    .normalize()
                    .multiply(1.5f);
            this.velocity.set(velocity);
        }
        this.position.addUp(this.velocity);
        //cho positon boxcollider trung voi position enemy
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);


    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    public void hit(GameObject gameObject) {
        if (gameObject instanceof Player || gameObject instanceof BulletPlayer || gameObject instanceof Shield)
            this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
