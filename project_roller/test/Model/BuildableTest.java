package Model;

import Sources.Images;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BuildableTest {

    Buildable b = new Buildable(new Point(0,0), true, "empty", Images.GRASS, 1, 1);
    
    @Before
    public void setUp(){
        Buildable b = new Buildable(new Point(0,0), true, "empty", Images.GRASS, 1, 1);
    }
    
    @Test
    public void changeToPath(){
        b.setImageID(Images.PATH);
        b.setUsable(false);
        b.setType("path");
        
        Images imageID = b.getImageID();
        Boolean usable = b.isUsable();
        String type = b.getType();
        
        assertEquals(Images.PATH, imageID);
        assertEquals(false, usable);
        assertEquals("path", type);
    }
    
    @Test
    public void changeToBuilding(){
        b.setImageID(Images.JANITOR_STATION);
        b.setUsable(false);
        b.setType("janitor_station");
        b.setSizeX(3);
        b.setSizeY(3);
        
        Images imageID = b.getImageID();
        Boolean usable = b.isUsable();
        String type = b.getType();
        int sizeX = b.getSizeX();
        int sizeY = b.getSizeY();
        
        assertEquals(Images.JANITOR_STATION, imageID);
        assertEquals(false, usable);
        assertEquals("janitor_station", type);
        assertEquals(3, sizeX);
        assertEquals(3, sizeY);
    }
}
