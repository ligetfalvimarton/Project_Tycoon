package Sources;

import Model.Buildable;
import java.awt.Point;

/**
 *Alapegységek típusainak felvétele
 */
public enum UnitType {


    PATH("path"), EMPTY("empty"), LOCKED_GRASS("locked_grass"), GRASS("grass"),
    BUSH1("bush1"), BUSH2("bush2"), BUSH3("bush3"), TREE("tree"),
    BIN("bin"), FULL_BIN("full_bin"),TRASH("trash"),
    TOITOI("toitoi"),FOUNTAIN("fountain"),
    RAMEN("ramen"),CASTLE("castle"),UPDOWN("updown"),YURTA("yurta"),MYSTERI("mysteri"),POKE("poke"),SCARY("scary"),
    POLICE_STATION("police_station"), JANITOR_STATION("janitor_station"), RESTAURANT("restaurant");

    private Buildable Item;
    private String type;;
     
    /**
     * Adott egység létrehozása a számára megadott paraméterekkel, képpel
     * @param type 
     */
    private UnitType(String type){
        this.type = type;
        switch(type){
            case "path":
                Item = new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "path", Images.PATH);
                break;
            case "bush1":
                Item = new Buildable(200, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "bush1", Images.BUSH1);
                break;
            case "bush2":
                Item = new Buildable(200, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "bush2", Images.BUSH2);
                break;
            case "bush3":
                Item = new Buildable(200, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "bush3", Images.BUSH3);
                break;
            case "tree":
                Item = new Buildable(300, 0, 0, 0, 0, 1, 2, new Point(0,0), false, "tree", Images.TREE);
                break;
            case "bin":
                Item = new Buildable(500, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "bin", Images.BIN);
                break;
            case "full_bin":
                Item = new Buildable(0, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "full_bin", Images.FULL_BIN);
                break;
            case "trash":
                Item = new Buildable(0, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "trash", Images.TRASH);
                break;
            case "toitoi":
                Item = new Buildable(500, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "toitoi", Images.TOITOI);
                break;    
            case "fountain":
                Item = new Buildable(500, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "fountain", Images.FOUNTAIN);
                break;    
            case "police_station":
                Item = new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,0), false, "police_station", Images.POLICE_STATION);
                break;    
            case "janitor_station":
                Item = new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,0), false, "janitor_station", Images.JANITOR_STATION);
                break;    
            case "restaurant":
                Item = new Buildable(1000, 700, 10, 50, 60, 3, 3, new Point(0,0), false, "restaurant", Images.RESTAURANT);
                    break;
            case "ramen":
                Item = new Buildable(1500, 700, 10, 50, 60, 6, 6, new Point(0,0), false, "ramen", Images.RAMEN);
                    break;
            case "castle":
                Item = new Buildable(2000, 700, 10, 100, 60, 6, 6, new Point(0,0), false, "castle", Images.CASTLE);
                    break; 
            case "updown":
                Item = new Buildable(1800, 700, 10, 80, 60, 5, 5, new Point(0,0), false, "updown", Images.UPDOWN);
                    break;  
            case "yurta":
                Item = new Buildable(1000, 700, 10, 20, 60, 5, 5, new Point(0,0), false, "yurta", Images.YURTA);
                    break;  
            case "mysteri":
                Item = new Buildable(2000, 700, 10, 100, 60, 5, 5, new Point(0,0), false, "yurta", Images.MYSTERI);
                    break;
            case "poke":
                Item = new Buildable(2000, 700, 10, 100, 60, 5, 5, new Point(0,0), false, "poke", Images.POKE);
                    break;
            case "scary":
                Item = new Buildable(2000, 700, 10, 90, 60, 6, 6, new Point(0,0), false, "scary", Images.SCARY);
                    break;
            case "locked_grass":
                Item = new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "locked_grass", Images.LOCKED_GRASS);
                    break;
            case "grass":
                Item = new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "grass", Images.GRASS);
                    break;
            default :
                Item = new Buildable(0, 0, 0, 0, 0, 1, 1, new Point(0,0), false, "empty", Images.GRASS);
                break;  
        }
    }
    
    public Buildable getItem(){
        return Item;
    }
    
    public void setBuildablePosition(Point p){
        Item.setPosition(p);
    }
}
