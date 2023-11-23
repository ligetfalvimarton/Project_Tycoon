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

public class EmployeeTest {
    
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    Point base = new Point(0,0);
    EmployeeSimulation sim = new EmployeeSimulation(gm);
    Employee e = new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, gm, base, sim);
    
    @Before
    public void setUp() {
        Employee e = new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, gm, base, sim);
    }
    
    @Test
    public void testChangeToOfficer(){
        e.setImageID(Images.OFFICER);
        e.setState(EmployeeState.PATROLLING);
        e.setType(EmployeeType.OFFICER);
        
        Images imgID = e.getImageID();
        EmployeeState empState = e.getState();
        EmployeeType empType = e.getType();
        
        assertEquals(imgID, Images.OFFICER);
        assertEquals(empState, EmployeeState.PATROLLING);
        assertEquals(empType, EmployeeType.OFFICER);          
    }
    
    @Test
    public void testChangeToThief(){
        e.setImageID(Images.THIEF);
        e.setState(EmployeeState.ESCAPING);
        e.setType(EmployeeType.THIEF);
        
        Images imgID = e.getImageID();
        EmployeeState empState = e.getState();
        EmployeeType empType = e.getType();
        
        assertEquals(imgID, Images.THIEF);
        assertEquals(empState, EmployeeState.ESCAPING);
        assertEquals(empType, EmployeeType.THIEF);        
    }
    
    @Test
    public void testStartPatrol(){
        List<Employee> officers = new ArrayList<>();
        officers.add(new Employee(EmployeeType.OFFICER, EmployeeState.WAITING, Images.OFFICER, gm, new Point(0,0), sim));
        
        List<Buildable> policeStations = new ArrayList<>();
        policeStations.add(new Buildable(base, false, "police_station", Images.POLICE_STATION, 3, 3));
        
        Employee e = new Employee(EmployeeType.OFFICER, EmployeeState.WAITING, Images.OFFICER, gm, base, sim);
        e.setPosition(new Point(29,31));
        e.setBase(new Point(29,31));
        
        gm.setPoliceStations(policeStations);
        sim.setOfficers(officers);
        e.startPatrol();
        
        EmployeeState officerState = e.getState();
        assertEquals(EmployeeState.PATROLLING, officerState);
    }
    
    @Test
    public void testAddPathToDest(){
        e.setPosition(new Point(29,31));
        e.setBase(new Point(29,31));
        e.addPathToDest(new Point(29,33), 0, 0);
        
        int lenghtOfPath = e.getPathToDest().size();
        
        assertEquals(2, lenghtOfPath);
    }
}
