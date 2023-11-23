package Model;

import Sources.EmployeeState;
import Sources.EmployeeType;
import Sources.Images;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeSimulationTest {
    
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    EmployeeSimulation es = new EmployeeSimulation(gm);
    
    @Before
    public void setUp() {
        GameModel gm = new GameModel(75, 10000, 150, 64, 32);
        EmployeeSimulation es = new EmployeeSimulation(gm);
    }
    
    @Test
    public void testGenerateStaff(){
        es.generateStaff();
        int numOfJanitors = es.getJanitors().size();
        assertEquals(1, numOfJanitors);
        
        List<Buildable> janitorStations = new ArrayList<>();
        janitorStations.add(new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,0), false, "janitor_station", Images.JANITOR_STATION));
        janitorStations.add(new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,3), false, "janitor_station", Images.JANITOR_STATION));
        janitorStations.add(new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,6), false, "janitor_station", Images.JANITOR_STATION));
        
        gm.setJanitorStations(janitorStations);
        es.generateStaff();
        
        numOfJanitors = es.getJanitors().size();
        assertEquals(3, numOfJanitors);
    }
    
    @Test
    public void testCreateMess(){
        es.createMess();
        es.createMess();
        es.createMess();
        es.createMess();
        
        boolean fullBins = es.getNeedToFix().size() > 0;
        String binType = es.getNeedToFix().get(0).getType();
        assertEquals(fullBins, true);
        assertEquals(binType, "full_bin");
    }
    
    @Test
    public void testRemoveChore(){
        ArrayList<Unit> needToFix = new ArrayList<>();
        needToFix.add(new Unit(new Point(0,0), false, "trash", Images.TRASH));
        needToFix.add(new Unit(new Point(0,1), false, "trash", Images.TRASH));
        es.setNeedToFix(needToFix);
        
        es.removeChore(1);
        es.removeChore(0);
        
        int numOfTrash = es.getNeedToFix().size();
        
        assertEquals(0, numOfTrash);
    }
    
    @Test
    public void testjanitorStartNewDuty(){
        ArrayList<Unit> needToFix = new ArrayList<>();
        needToFix.add(new Unit(new Point(29,33), false, "bin", Images.TRASH));
        es.setNeedToFix(needToFix);
        
        List<Employee> janitors = new ArrayList<>();
        janitors.add(new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, gm, new Point(0,0), es));      
        janitors.get(0).setPosition(new Point(29,31));
        janitors.get(0).setBase(new Point(29,31));
        es.setJanitors(janitors);
        
        es.janitorStartNewDuty();
        
        int lengthOfJanitorsPath = es.getJanitors().get(0).getPathToDest().size();
        assertEquals(2, lengthOfJanitorsPath);
        
    }
    
    public void testPatrol(){
        List<Employee> officers = new ArrayList<>();
        officers.add(new Employee(EmployeeType.OFFICER, EmployeeState.WAITING, Images.OFFICER, gm, new Point(0,0), es));
        officers.add(new Employee(EmployeeType.OFFICER, EmployeeState.WAITING, Images.OFFICER, gm, new Point(5,5), es));
        es.setOfficers(officers);
        
        es.patrol();
        
        EmployeeState officer0 = es.getJanitors().get(0).getState();
        EmployeeState officer1 = es.getJanitors().get(1).getState();
        
        assertEquals(officer0, EmployeeState.PATROLLING);
        assertEquals(officer1, EmployeeState.PATROLLING);
    }

}
