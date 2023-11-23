package Sources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;



/**
 * Képek felvétele
 */
public enum Images {
    PATH(Paths.get("").toAbsolutePath().toString() + "/src/resources/path.jpg"),
    
    GRASS(Paths.get("").toAbsolutePath().toString() + "/src/resources/grass.jpg"),
    LOCKED_GRASS(Paths.get("").toAbsolutePath().toString() + "/src/resources/locked_grass.jpg"),
    
    BUSH1(Paths.get("").toAbsolutePath().toString() + "/src/resources/bush1.png"),
    BUSH2(Paths.get("").toAbsolutePath().toString() + "/src/resources/bush2.png"),
    BUSH3(Paths.get("").toAbsolutePath().toString() + "/src/resources/bush3.png"),
    TREE(Paths.get("").toAbsolutePath().toString() + "/src/resources/tree.jpg"),
    
    BIN(Paths.get("").toAbsolutePath().toString() + "/src/resources/bin.jpg"),
    FULL_BIN(Paths.get("").toAbsolutePath().toString() + "/src/resources/full_bin.jpg"),
    TRASH(Paths.get("").toAbsolutePath().toString() + "/src/resources/trash.jpg"),
    
    TOITOI(Paths.get("").toAbsolutePath().toString() + "/src/resources/toitoi.jpg"),
    FOUNTAIN(Paths.get("").toAbsolutePath().toString() + "/src/resources/fountain.jpg"),
    
    RESTAURANT(Paths.get("").toAbsolutePath().toString() + "/src/resources/restaurant.jpg"),
    JANITOR_STATION(Paths.get("").toAbsolutePath().toString() + "/src/resources/janitor_station.jpg"),
    POLICE_STATION(Paths.get("").toAbsolutePath().toString() + "/src/resources/police_station.jpg"),
    
    ADULT(Paths.get("").toAbsolutePath().toString() + "/src/resources/adult_path.png"),
    YOUTH(Paths.get("").toAbsolutePath().toString() + "/src/resources/youth_path.png"),
    JANITOR(Paths.get("").toAbsolutePath().toString() + "/src/resources/Janitor_path.png"),
    OFFICER(Paths.get("").toAbsolutePath().toString() + "/src/resources/officer_path.png"),
    THIEF(Paths.get("").toAbsolutePath().toString() + "/src/resources/thief.png"),
    CHEF(Paths.get("").toAbsolutePath().toString() + "/src/resources/chef_path.jpg"),
    
    RAMEN(Paths.get("").toAbsolutePath().toString() + "/src/resources/toy12.jpg"),    
    CASTLE(Paths.get("").toAbsolutePath().toString() + "/src/resources/toy11.jpg"),    
    UPDOWN(Paths.get("").toAbsolutePath().toString() + "/src/resources/toy5.jpg"),    
    YURTA(Paths.get("").toAbsolutePath().toString() + "/src/resources/toy9.jpg"),    
    MYSTERI(Paths.get("").toAbsolutePath().toString() + "/src/resources/mysteri.png"),    
    POKE(Paths.get("").toAbsolutePath().toString() + "/src/resources/game3.png"),    
    SCARY(Paths.get("").toAbsolutePath().toString() + "/src/resources/game2.png"),
    
    CORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/resources/correct_place.jpg"),
    INCORRECTPLACE(Paths.get("").toAbsolutePath().toString() + "/src/resources/incorrect_place.jpeg");
    
    private BufferedImage image;
    private final String path;
    
    private Images(String path){
        this.path = path;
        BufferedImage tempImage = null;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (Exception e) {
            tempImage = null;
            System.err.println(e.getStackTrace());
        }
        image = tempImage;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public String getPath(){
        return path;
    }
}
