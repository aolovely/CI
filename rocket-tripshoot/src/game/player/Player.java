package game.player;

import base.GameObject;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.Collider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements Collider {

    public double angle = 0.0;
    public Vector2D velocity;
    public BoxCollider boxCollider;


    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.velocity = new Vector2D(3.5f, 0);
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.boxCollider = new BoxCollider(20, 16);
    }

    @Override
    public void run() {
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);

    }

    @Override
    public void hit(GameObject gameObject) {
        if (gameObject instanceof Enemy || gameObject instanceof BulletEnemy)
            this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
