import javax.swing.ImageIcon;

public enum Texture {
    GRASS(new ImageLoader().grassImage),

    KSR(new ImageLoader().ksrImage),
    KJR1(new ImageLoader().kjr1Image),
    KJR2(new ImageLoader().kjr2Image),
    KJR3(new ImageLoader().kjr3Image),

    KSL(new ImageLoader().kslImage),
    KJL1(new ImageLoader().kjl1Image),
    KJL2(new ImageLoader().kjl2Image),
    KJL3(new ImageLoader().kjl3Image),

    KSU(new ImageLoader().ksuImage),
    KJU1(new ImageLoader().kju1Image),
    KJU2(new ImageLoader().kju2Image),
    KJU3(new ImageLoader().kju3Image),

    KSD(new ImageLoader().ksdImage),
    KJD1(new ImageLoader().kjd1Image),
    KJD2(new ImageLoader().kjd2Image),
    KJD3(new ImageLoader().kjd3Image),

    FOX(new ImageLoader().foxImage),
    
    FLOWER(new ImageLoader().flowerImage);
    ImageIcon image;
    Texture(ImageIcon image){
        this.image = image;
    }
}
