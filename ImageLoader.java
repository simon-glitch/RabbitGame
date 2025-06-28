import java.net.URL;
import javax.swing.ImageIcon;

public class ImageLoader {
    private URL grassURL = Main.class.getResource("textures/grass.png");
    ImageIcon grassImage = new ImageIcon(grassURL);

    private URL ksrURL = Main.class.getResource("textures/kizi/right/kiziSitting.png");
    ImageIcon ksrImage = new ImageIcon(ksrURL);
    private URL kjr1URL = Main.class.getResource("textures/kizi/right/kiziJump1.png");
    ImageIcon kjr1Image = new ImageIcon(kjr1URL);
    private URL kjr2URL = Main.class.getResource("textures/kizi/right/kiziJump2.png");
    ImageIcon kjr2Image = new ImageIcon(kjr2URL);
    private URL kjr3URL = Main.class.getResource("textures/kizi/right/kiziJump3.png");
    ImageIcon kjr3Image = new ImageIcon(kjr3URL);

    private URL kslURL = Main.class.getResource("textures/kizi/left/kiziSitting.png");
    ImageIcon kslImage = new ImageIcon(kslURL);
    private URL kjl1URL = Main.class.getResource("textures/kizi/left/kiziJump1.png");
    ImageIcon kjl1Image = new ImageIcon(kjl1URL);
    private URL kjl2URL = Main.class.getResource("textures/kizi/left/kiziJump2.png");
    ImageIcon kjl2Image = new ImageIcon(kjl2URL);
    private URL kjl3URL = Main.class.getResource("textures/kizi/left/kiziJump3.png");
    ImageIcon kjl3Image = new ImageIcon(kjl3URL);

    private URL ksuURL = Main.class.getResource("textures/kizi/up/kiziSitting.png");
    ImageIcon ksuImage = new ImageIcon(ksuURL);
    private URL kju1URL = Main.class.getResource("textures/kizi/up/kiziJump1.png");
    ImageIcon kju1Image = new ImageIcon(kju1URL);
    private URL kju2URL = Main.class.getResource("textures/kizi/up/kiziJump2.png");
    ImageIcon kju2Image = new ImageIcon(kju2URL);
    private URL kju3URL = Main.class.getResource("textures/kizi/up/kiziJump3.png");
    ImageIcon kju3Image = new ImageIcon(kju3URL);

    private URL ksdURL = Main.class.getResource("textures/kizi/down/kiziSitting.png");
    ImageIcon ksdImage = new ImageIcon(ksdURL);
    private URL kjd1URL = Main.class.getResource("textures/kizi/down/kiziJump1.png");
    ImageIcon kjd1Image = new ImageIcon(kjd1URL);
    private URL kjd2URL = Main.class.getResource("textures/kizi/down/kiziJump2.png");
    ImageIcon kjd2Image = new ImageIcon(kjd2URL);
    private URL kjd3URL = Main.class.getResource("textures/kizi/down/kiziJump3.png");
    ImageIcon kjd3Image = new ImageIcon(kjd3URL);

    private URL foxURL = Main.class.getResource("textures/fox.png");
    ImageIcon foxImage = new ImageIcon(foxURL);

    private URL flowerURL = Main.class.getResource("textures/flower.png");
    ImageIcon flowerImage = new ImageIcon(flowerURL);
}
