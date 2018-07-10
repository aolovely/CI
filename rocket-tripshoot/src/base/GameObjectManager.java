package base;

import effect.EffectShield;
import effect.EffectTripShoot;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.Collider;

import java.awt.*;
import java.util.ArrayList;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    public ArrayList<GameObject> list = new ArrayList<>();
    public ArrayList<GameObject> tempList = new ArrayList<>();

    private GameObjectManager() {
//        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> gameObject.isAlive)
                .findFirst()
                .orElse(null);
    }

    //lay ra enemy va cham vs bullet
    public Enemy checkCollsion(BulletPlayer bulletPlayer) {

        return (Enemy) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive) //loc ra con con song
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider other = ((Enemy) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollisition(other);
                }) //ket qua tra ve 1 list enemy va cham vs bullet
                .findFirst() //nhung chi lay 1 con thoi
                .orElse(null);
    }

    public Player checkCollsion(EffectShield effectShield) {

        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive) //loc ra con con song
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider other = ((Player) gameObject).boxCollider;
                    return effectShield.boxCollider.checkCollisition(other);
                })
                .findFirst()
                .orElse(null);
    }

    public Player checkCollsion(EffectTripShoot effectTripShoot) {

        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive) //loc ra con con song
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider other = ((Player) gameObject).boxCollider;
                    return effectTripShoot.boxCollider.checkCollisition(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T checkCollsion(BoxCollider boxCollider, Class<T> object) {

        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> object.isInstance(gameObject))
                .filter(gameObject -> gameObject instanceof Collider)
                .filter(gameObject -> {
                    BoxCollider other = ((Collider) gameObject).getBoxCollider();
                    return boxCollider.checkCollisition(other);
                })
                .findFirst()
                .orElse(null);
    }
}
