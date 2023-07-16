package pl.edu.pg.eti.ksg.oop.lab2.throughthewoods.robots;

import pl.edu.pg.eti.ksg.oop.lab2.throughthewoods.Robot;
import pl.edu.pg.eti.ksg.oop.lab2.throughthewoods.TaskTypes;
import pl.edu.pg.eti.ksg.oop.lab2.throughthewoods.TerrainType;

/**
 *
 * @author TB
 */
public class MobileRobot extends Robot {

    public MobileRobot(int serialNumber) {
        super("Mobile robot, type A", serialNumber);
    }

    @Override
    public double movementSpeed(TerrainType terrainType) {
        switch(terrainType)
        {
            case ROAD:
                communicate("Terrain detected: "+terrainType+". Maximum movement speed.");
                return randomFactors.nextDouble()*0.1 + 0.95; //From 0.95 to 1.5
            case PATH:
                communicate("Terrain detected: "+terrainType+". Moderate speed.");
                return randomFactors.nextDouble()*0.1 + 0.85; //From 0.85 to 0.95
            case HIGH_FORESST:
                communicate("Terrain detected: "+terrainType+". Unfriendly conditions.");
                return randomFactors.nextDouble()*0.1 + 0.4; //From 0.4 to 0.5
            case LOW_FOREST:
                communicate("Terrain detected: "+terrainType+". A large number of obstacles have been detected.");
                return randomFactors.nextDouble()*0.2 + 0.2; //From 0.2 to 0.4
            case SWAMP:
            default:
                communicate("Terrain detected: "+terrainType+".");
                communicate("Engines malfunction!");
                return randomFactors.nextDouble()*0.1; //From 0.0 to 0.1
        }
    }

    @Override
    public boolean solveTask(TaskTypes tasksField){
        switch(tasksField)
        {
            case Math:
                communicate("Solving a Mathematical problem. ");
                return randomFactors.nextFloat()<0.1;
            case Art:
                communicate("Solving an Art problem. ");
                return randomFactors.nextFloat()<0.1;
            case Physics:
                communicate("Solving a Physics problem. ");
                return randomFactors.nextFloat()<0.1;
            case ComputerScience:
                communicate("Solving a Computer Science problem. ");
                return randomFactors.nextFloat()<0.1;
            case ForestrySciences:
            default:
                communicate("Solving a problem in Forestry Sciences.");
                return randomFactors.nextFloat()<0.1;
        }
    }
    
}
