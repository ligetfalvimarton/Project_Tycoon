package Model;

import Sources.Images;
import Sources.VisitorState;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VisitorSimulationTest {
    
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    VisitorSimulation vs = new VisitorSimulation(gm);
    
    
    @Before
    public void setUp() {
        GameModel gm = new GameModel(75, 10000, 150, 64, 32);
        VisitorSimulation vs = new VisitorSimulation(gm);
    }
    
    @Test
    public void testGenerateDailyVisitors(){
        List<Buildable> built = new ArrayList<>();
        built.add(new Buildable(new Point(0,0), false, "ramen", Images.RAMEN, 3, 3));
        built.add(new Buildable(new Point(0,0), false, "ramen", Images.RAMEN, 3, 3));
        
        vs.setDailyVisitors(10);
        vs.setCapacity(20);
        
        vs.generateDailyVisitors(75, built);
        
        int dailyVisitors = vs.getDailyVisitors();
        assertEquals(7, dailyVisitors);
    }
    
    @Test
    public void testSimulate(){
        List<Buildable> built = new ArrayList<>();
        built.add(new Buildable(new Point(0,0), false, "ramen", Images.RAMEN, 3, 3));
        built.add(new Buildable(new Point(0,0), false, "ramen", Images.RAMEN, 3, 3));
        
        vs.setDailyVisitors(10);
        vs.setCapacity(20);
        
        vs.generateDailyVisitors(75, built);
        
        List<Visitor> visitors = new ArrayList<>();
        for(Visitor v : visitors){
            v.setState(VisitorState.LEAVING);
        }
        vs.setVisitors(visitors);
        
        vs.Simulate();
        
        int remainVisitors = vs.getVisitors().size();
        
        assertEquals(0, remainVisitors);
    }

}
