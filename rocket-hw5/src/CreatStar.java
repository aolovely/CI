import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatStar{

    public List<Star> stars;
    private Counter counter;
    private Random random;

    public CreatStar(){
        stars = new ArrayList<>();
        counter = new Counter(30);
        random = new Random();
    }

    public void creat(){
        if(this.counter.run()){
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.counter.reset();
        }
    }
}
