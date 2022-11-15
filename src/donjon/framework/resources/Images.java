package donjon.framework.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {

    public BufferedImage image ;



    public Images() throws IOException {
         this.image = ImageIO.read(new File("res/textures/soldier_altcolor.png"));


    }

    public BufferedImage cutter(int x , int y , int width , int height ){

        BufferedImage bufferedImage1 = image.getSubimage(456,142,52,52);
        return bufferedImage1;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("res/textures/NESW.png"));
        ImageIO.write(image.getSubimage(98,193,46,63),"png",new File("/Users/zidanifahed/IdeaProjects/Dungeon-Crawler/res/textures/L2.png"));

    }



}
