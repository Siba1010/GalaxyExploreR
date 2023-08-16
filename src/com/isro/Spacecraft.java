package com.isro;
public class Spacecraft {
    private int x;
    private int y;
    private int z;
    private Direction currentDirection;

    // Direction enum to represent possible directions
    public enum Direction {
        NORTH, SOUTH, EAST, WEST, UP, DOWN
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public Spacecraft(int x, int y, int z, Direction initialDirection) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.currentDirection = initialDirection;
    }


    public void moveForward() {
        y += 1;
    }

    public void moveBackward() {
        y -= 1;
    }

/*Turn the spacecraft left/right: */
public void turnLeft() {
    switch (currentDirection) {
        case NORTH:
            currentDirection = Direction.WEST;
            break;
        case SOUTH:
            currentDirection = Direction.EAST;
            break;
        case EAST:
            currentDirection = Direction.NORTH;
            break;
        case WEST:
            currentDirection = Direction.SOUTH;
            break;
        // Handle UP and DOWN directions if needed
    }
}

public void turnRight() {
    switch (currentDirection) {
        case NORTH:
            currentDirection = Direction.EAST;
            break;
        case SOUTH:
            currentDirection = Direction.WEST;
            break;
        case EAST:
            currentDirection = Direction.SOUTH;
            break;
        case WEST:
            currentDirection = Direction.NORTH;
            break;
        // Handle UP and DOWN directions if needed
}
}

public void turnUp() {
    switch (currentDirection) {
        case NORTH:
        case SOUTH:
        case EAST:
        case WEST:
            currentDirection = Direction.UP;
            break;
        case UP:
            // No change in direction when turning up from UP
            break;
        case DOWN:
            currentDirection = Direction.NORTH;
            break;
    }
}

public void turnDown() {
    switch (currentDirection) {
        case NORTH:
        case SOUTH:
        case EAST:
        case WEST:
            currentDirection = Direction.DOWN;
            break;
        case DOWN:
            // No change in direction when turning down from DOWN
            break;
        case UP:
            currentDirection = Direction.SOUTH;
            break;
    }
}
public void executeCommands(char[] commands) {
    for (char command : commands) {
        executeCommand(command);
    }
}

private void executeCommand(char command) {
    switch (command) {
        case 'f':
            moveForward();
            break;
        case 'b':
            moveBackward();
            break;
        case 'l':
            turnLeft();
            break;
        case 'r':
            turnRight();
            break;
        case 'u':
            turnUp();
            break;
        case 'd':
            turnDown();
            break;
        // You can handle other cases if needed
        default:
            // Ignore or handle unknown commands
            break;
    }
}



}
