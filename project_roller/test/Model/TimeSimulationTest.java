package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeSimulationTest {
    
    TimeSimulate ts = new TimeSimulate();
    
    @Before
    public void setUp() {
        TimeSimulate ts = new TimeSimulate();
    }

    @Test
    public void testFasterTime(){
        ts.FasterTime();
        
        assertEquals(1, ts.getToAdd());
        assertEquals(10, ts.getTimeGap());
    }
    
    @Test
    public void testNormalTime(){
        ts.NormalTime();
        
        assertEquals(1, ts.getToAdd());
        assertEquals(50, ts.getTimeGap());
    }
    
    @Test
    public void testStopTime(){
        ts.StopTime();
        
        assertEquals(0, ts.getToAdd());
    }
}
