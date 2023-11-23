package Model;

import Sources.Images;
import java.awt.Point;

/**
 * Alapegységek a boardon.
 */
public class Unit {
    private Point position;
    private boolean usable;
    private String type;
    private Images imageID;

    /**
     * Teljes konstruktor
     * @param position
     * @param usable
     * @param type
     * @param imageID 
     */
    public Unit(Point position, boolean usable, String type, Images imageID) {
        this.position = position;
        this.usable = usable;
        this.type = type;
        this.imageID = imageID;
    }
    
    //alap konstruktor
    public Unit(){}

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Images getImageID() {
        return imageID;
    }

    public void setImageID(Images imageID) {
        this.imageID = imageID;
    }
}
