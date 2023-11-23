package Model;

import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {
    
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    
    @Before
    public void setUp() {
        GameModel gm = new GameModel(75, 10000, 150, 64, 32);
        Path p = new Path(gm.getBoard());
    }
    
    @Test
    public void testFindPath(){
        Path p = new Path(gm.getBoard());
        
        p.findPath(new Point(29,33), new Point(29,31), 1, 1);
        
        char matrix[][] =  p.getMatrix();
        
        assertEquals('1', matrix[29][31]);
        assertEquals('1', matrix[29][32]);
        assertEquals('0', matrix[29][33]);
        
    }

}
