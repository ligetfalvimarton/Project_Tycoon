package Model;

import Sources.Images;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {
    
    Unit u = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    
    @Before
    public void setUp() {
        Unit u = new Unit(new Point(0,0),true, "empty", Images.GRASS);
    }
    
    @Test
    public void changeUnit(){
        u.setUsable(false);
        u.setType("bush1");
        u.setImageID(Images.BUSH1);
        
        Images imageID = u.getImageID();
        Boolean usable = u.isUsable();
        String type = u.getType();
        
        assertEquals(Images.BUSH1, imageID);
        assertEquals(false, usable);
        assertEquals("bush1", type);
    } 
}
