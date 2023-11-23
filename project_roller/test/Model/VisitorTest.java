package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VisitorTest {
    
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    VisitorSimulation sim = new VisitorSimulation(gm);
    Visitor a = new Visitor(true, 65, 1, gm, sim);
    
    @Before
    public void setUp() {
        GameModel gm = new GameModel(75, 10000, 150, 64, 32);
        VisitorSimulation sim = new VisitorSimulation(gm);
        Visitor a = new Visitor(true, 65, 1, gm, sim);
    }
    
    
    @Test
    public void testGenerateToVisit(){
        
        List<Integer> toVisit = new ArrayList<>();
        
        a.generateToVisit(1);
        int toVisit1 = a.getToVisit().size();
        assertEquals(2, toVisit1);
        a.setToVisit(toVisit);
        
        a.generateToVisit(4);
        boolean toVisit4 = a.getToVisit().size() >= 1;
        assertEquals(true, toVisit4);
        a.setToVisit(toVisit);
        
        a.generateToVisit(8);
        boolean toVisit8 = a.getToVisit().size() >= 5;
        assertEquals(true, toVisit8);
        a.setToVisit(toVisit);
        
        a.generateToVisit(15);
        boolean toVisit15 = a.getToVisit().size() > 7;
        assertEquals(true, toVisit15);
        a.setToVisit(toVisit);
         
    }
    
    @Test
    public void testAddPathtoDest(){
        a.addPathToDest(new Point(29,31), 1, 1);
        
        int lengthOfPath = a.getPathToDest().size();
        
        assertEquals(5, lengthOfPath);
    }
}
