package com.isro.test;
import com.isro.Spacecraft;
import static org.junit.jupiter.api.Assertions.*;


public class SpacecraftTest {
    
    public void testMoveForward() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, null);
        spacecraft.moveForward();
        assertEquals(1, spacecraft.getY());
    }

    
    public void testMoveBackward() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, null);
        spacecraft.moveBackward();
        assertEquals(-1, spacecraft.getY());
    }

    
    public void testTurnLeft() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);

        spacecraft.turnLeft();
        assertEquals(Spacecraft.Direction.WEST, spacecraft.getCurrentDirection());

        spacecraft.turnLeft();
        assertEquals(Spacecraft.Direction.SOUTH, spacecraft.getCurrentDirection());

        spacecraft.turnLeft();
        assertEquals(Spacecraft.Direction.EAST, spacecraft.getCurrentDirection());

        spacecraft.turnLeft();
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }

public void testTurnRight() {
    Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);

    spacecraft.turnRight();
    assertEquals(Spacecraft.Direction.EAST, spacecraft.getCurrentDirection());

    spacecraft.turnRight();
    assertEquals(Spacecraft.Direction.SOUTH, spacecraft.getCurrentDirection());

    spacecraft.turnRight();
    assertEquals(Spacecraft.Direction.WEST, spacecraft.getCurrentDirection());

    spacecraft.turnRight();
    assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
}

    
    public void testTurnUp() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);

        spacecraft.turnUp();
        assertEquals(Spacecraft.Direction.UP, spacecraft.getCurrentDirection());

        spacecraft.turnUp();
        assertEquals(Spacecraft.Direction.UP, spacecraft.getCurrentDirection()); // Stays up

        spacecraft.turnLeft();
        spacecraft.turnUp();
        assertEquals(Spacecraft.Direction.UP, spacecraft.getCurrentDirection()); // Stays up

        spacecraft.turnDown();
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }
    
    public void testTurnDown() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);
    
        spacecraft.turnDown();
        assertEquals(Spacecraft.Direction.DOWN, spacecraft.getCurrentDirection());
    
        spacecraft.turnDown();
        assertEquals(Spacecraft.Direction.DOWN, spacecraft.getCurrentDirection()); // Stays down
    
        spacecraft.turnLeft();
        spacecraft.turnDown();
        assertEquals(Spacecraft.Direction.DOWN, spacecraft.getCurrentDirection()); // Stays down
    
        spacecraft.turnUp();
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }
    
    
    // Other test cases for movement and command execution
    public void testExecuteCommands() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);

        char[] commands = {'f', 'r', 'u', 'b', 'l'};
        spacecraft.executeCommands(commands);

        assertEquals(0, spacecraft.getX());
        assertEquals(1, spacecraft.getY());
        assertEquals(-1, spacecraft.getZ());
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }

    
    public void testExecuteCommandsOtherDirections() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.WEST);

        char[] commands = {'f', 'r', 'd', 'l', 'u'};
        spacecraft.executeCommands(commands);

        assertEquals(1, spacecraft.getX());
        assertEquals(1, spacecraft.getY());
        assertEquals(0, spacecraft.getZ());
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }

    // Add more test cases to cover different scenarios

    
    public void testExecuteCommandsUnknownCommands() {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);

        char[] commands = {'f', 'x', 'y', 'z'};
        spacecraft.executeCommands(commands);

        assertEquals(1, spacecraft.getY()); // Position should be updated by 'f'
        // Verify that the direction is still NORTH
        assertEquals(Spacecraft.Direction.NORTH, spacecraft.getCurrentDirection());
    }

   
        public static void main(String[] args) {
            Spacecraft spacecraft = new Spacecraft(0, 0, 0, Spacecraft.Direction.NORTH);
    
            char[] commands = {'f', 'r', 'u', 'b', 'l'};
            spacecraft.executeCommands(commands);
    
            System.out.println("Final Position: (" + spacecraft.getX() + ", " + spacecraft.getY() + ", " + spacecraft.getZ() + ")");
            System.out.println("Final Direction: " + spacecraft.getCurrentDirection());
        }
    
    
}






