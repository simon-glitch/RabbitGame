import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Kizi kizi = new Kizi();
        Fox fox = new Fox();
        Flower flower = new Flower();


        flower.setBounds(PosX(random), PosY(random), 64, 64);

        JPanel grid = new JPanel(null);

        JLabel grass = new JLabel(Texture.GRASS.image);
        grass.setBounds(0, 0, 1024, 768);

        JFrame frame = new JFrame("Kizi game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer folow = new Timer(350, null);
        Timer checkCatch = new Timer(50, null);
        
        frame.addKeyListener(new KeyListener() {
            //animations
            // isProcessingKey should do nothing, so you can totally remove it if you want
            Boolean isProcessingKey = false;
            short state = 2;

            Timer jumpRight = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    kizi.setLocation(kizi.getX() + 16, kizi.getY());
                    switch (state) {
                        case 2 -> { kizi.setIcon(Texture.KJR2.image); state++; }
                        case 3 -> { kizi.setIcon(Texture.KJR3.image); state++; }
                        case 4 -> { kizi.setIcon(Texture.KSR.image); state = 2;
                            kizi.setCheckpoint();
                            jumpRight.stop(); 
                            if(kizi.getX() == flower.getX() && kizi.getY() == flower.getY()) flower.setLocation(PosX(random), PosY(random)); }
                    }
                    kizi.repaint();
                }
            });
            Timer jumpLeft = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    kizi.setLocation(kizi.getX() - 16, kizi.getY());
                    switch (state) {
                        case 2 -> { kizi.setIcon(Texture.KJL2.image); state++; }
                        case 3 -> { kizi.setIcon(Texture.KJL3.image); state++; }
                        case 4 -> { kizi.setIcon(Texture.KSL.image); state = 2;
                            kizi.setCheckpoint();
                            jumpLeft.stop();
                            if(kizi.getX() == flower.getX() && kizi.getY() == flower.getY()) flower.setLocation(PosX(random), PosY(random)); }
                    }
                    kizi.repaint();
                }
            });
            Timer jumpUp = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    kizi.setLocation(kizi.getX(), kizi.getY() - 16);
                    switch (state) {
                        case 2 -> { kizi.setIcon(Texture.KJU2.image); state++; }
                        case 3 -> { kizi.setIcon(Texture.KJU3.image); state++; }
                        case 4 -> { kizi.setIcon(Texture.KSU.image); state = 2;
                            kizi.setCheckpoint();
                            jumpUp.stop();
                            if(kizi.getX() == flower.getX() && kizi.getY() == flower.getY()) flower.setLocation(PosX(random), PosY(random)); }
                    }
                    kizi.repaint();
                }
            });
            Timer jumpDown = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    kizi.setLocation(kizi.getX(), kizi.getY() + 16);
                    switch (state) {
                        case 2 -> { kizi.setIcon(Texture.KJD2.image); state++; }
                        case 3 -> { kizi.setIcon(Texture.KJD3.image); state++; }
                        case 4 -> { kizi.setIcon(Texture.KSD.image); state = 2;
                            kizi.setCheckpoint();
                            jumpDown.stop();
                            if(kizi.getX() == flower.getX() && kizi.getY() == flower.getY()) flower.setLocation(PosX(random), PosY(random)); }
                    }
                    kizi.repaint();
                }
            });
            KeyEvent keyToProcess;
            Timer processKey = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //movement
                Boolean isMoving = jumpUp.isRunning() || jumpDown.isRunning() || jumpLeft.isRunning() || jumpRight.isRunning();
                int keyCode = keyToProcess.getKeyCode();
                
                // if the player tries to press a different direction while we are moving, stop moving, return to the tile we came from, and then use the next switch statement to start moving again;
                Boolean stopMoving = false;
                if(isMoving) switch(keyCode) {
                    //left
                    case 37 -> {
                        if(!jumpLeft.isRunning()){
                            stopMoving = true;
                        }
                    }
                    //up
                    case 38 -> {
                        if(!jumpUp.isRunning()){
                            stopMoving = true;
                        }
                     }
                     //right
                    case 39 -> {
                        if(!jumpRight.isRunning()) {
                            stopMoving = true;
                        }
                    }
                    //down
                    case 40 -> {
                        if(!jumpDown.isRunning()){
                            stopMoving = true;
                        }
                     }
                }
                
                if(stopMoving){
                    if(jumpLeft.isRunning()){
                        // if(state < 4)
                        jumpLeft.getActionListeners()[0].actionPerformed(e);
                        jumpLeft.stop();
                    }
                    if(jumpUp.isRunning()){
                        // if(state < 4)
                        jumpUp.getActionListeners()[0].actionPerformed(e);
                        jumpUp.stop();
                    }
                    if(jumpRight.isRunning()){
                        // if(state < 4)
                        jumpRight.getActionListeners()[0].actionPerformed(e);
                        jumpRight.stop();
                    }
                    if(jumpDown.isRunning()){
                        // if(state < 4)
                        jumpDown.getActionListeners()[0].actionPerformed(e);
                        jumpDown.stop();
                    }
                    kizi.returnToCheckpoint();
                    state = 2;
                    isMoving = false;
                }
                
                // move if we're not moving, or move if we changed directions, as described above;
                if(!isMoving) switch(keyCode) {
                    //left
                    case 37 -> {
                        if(kizi.getX() != 0) {
                            kizi.setCheckpoint();
                            kizi.setLocation(kizi.getX() - 16, kizi.getY());
                            kizi.setIcon(Texture.KJL1.image);
                            kizi.repaint();
                            jumpLeft.start();
                        }
                    }
                    //up
                    case 38 -> {
                        if(kizi.getY() != 0) {
                            kizi.setCheckpoint();
                            kizi.setLocation(kizi.getX(), kizi.getY() - 16);
                            kizi.setIcon(Texture.KJU1.image);
                            kizi.repaint();
                            jumpUp.start();
                        }
                     }
                     //right
                    case 39 -> {
                        if(kizi.getX() != 960) {
                            kizi.setCheckpoint();
                            kizi.setLocation(kizi.getX() + 16, kizi.getY());
                            kizi.setIcon(Texture.KJR1.image);
                            kizi.repaint();
                            jumpRight.start();
                        }
                    }
                    //down
                    case 40 -> {
                        if(kizi.getY() != 704) {
                            kizi.setCheckpoint();
                            kizi.setLocation(kizi.getX(), kizi.getY() + 16);
                            kizi.setIcon(Texture.KJD1.image);
                            kizi.repaint();
                            jumpDown.start();
                        }
                    }
                }
                
                processKey.stop();
            }
            });
            
            public void keyTyped(KeyEvent e){}

            public void keyPressed(KeyEvent e) {
                if(isProcessingKey) return;
                isProcessingKey = true;
                keyToProcess = e;
                processKey.start();
                isProcessingKey = false;
            }

            public void keyReleased(KeyEvent e) {}
            
        });

        folow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Square location = calcPath(kizi.getX(), kizi.getY(), fox.getX(), fox.getY());
                fox.setLocation(location.x * 64, location.y * 64);
                 if (fox.getX() == kizi.getX() && fox.getY() == kizi.getY()) folow.stop();
            }
        });

        //not used
        checkCatch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (fox.getX() == kizi.getX() && fox.getY() == kizi.getY()) { folow.stop(); checkCatch.stop(); }
            }
        });

        folow.start();
        //checkCatch.start();

        //setting JFrame
        grid.setPreferredSize(new Dimension(1024, 767));
        grid.add(fox);
        grid.add(kizi);
        grid.add(flower);
        grid.add(grass);
        frame.add(grid);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static Square calcPath(int kX, int kY, int fX, int fY){
        ArrayList<Square> distance1 = new ArrayList<>();
        Square distance2 = null;
        int min = 0;
        kX = kX / 64; kY = kY / 64; fX = fX / 64; fY = fY / 64; //converting coords to simpler numbers

        Square[] squares = findSquares(fX, fY);

        //find the smallest x distance
        for(int i = 0; i < 8; i++){
            if(i == 0){
                min = Math.abs(squares[i].x - kX);
                distance1.add(squares[i]);
            } else{
                if(min == Math.abs(squares[i].x - kX)) distance1.add(squares[i]);
                if(min > Math.abs(squares[i].x - kX)){
                    min = Math.abs(squares[i].x - kX);
                    distance1.clear();
                    distance1.add(squares[i]);
                }
            }
        }

        //find the smalest y distance
        for(int i = 0; i < distance1.size(); i++){
            if(i == 0){
                min = Math.abs(distance1.get(i).y - kY);
                distance2 = (distance1.get(i));
            } else{
                if(min > Math.abs(distance1.get(i).y - kY)){
                    min = Math.abs(distance1.get(i).y - kY);
                    distance2 = (distance1.get(i));
                }
            }
        }

        return distance2;
    }

    static Square[] findSquares(int x, int y){
        Square[] squares = new Square[8];
            squares[0] = new Square(x - 1, y- 1);
            squares[1] = new Square(x - 1, y);
            squares[2] = new Square(x, y - 1);
            squares[3] = new Square(x + 1, y + 1);
            squares[4] = new Square(x + 1, y);
            squares[5] = new Square(x, y + 1);
            squares[6] = new Square(x - 1, y + 1);
            squares[7] = new Square(x + 1, y - 1);
        return squares;
    }

    static int PosX(Random random){
        return random.nextInt(16) * 64;
    }
    static int PosY(Random random){
        return random.nextInt(12) * 64;
    }
}