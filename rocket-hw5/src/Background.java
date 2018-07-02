import java.awt.*;

public class Background extends GameObject {

    public Background() {

        this.renderer = new BackgroundRenderer(Color.BLACK, 1024, 600);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}
