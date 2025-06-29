import java.awt.Point;
import javax.swing.JLabel;

public class Kizi extends JLabel{
    Point checkpoint = new Point(0, 0);
    public void setCheckpoint() {
        this.checkpoint = this.getLocation();
    }
    public void returnToCheckpoint() {
        this.setLocation(this.checkpoint);
    }

    Kizi(){
        this.setIcon(Texture.KSR.image);
        this.setBounds(0, 0, 64, 64);
    }

}

