package pl.edu.pg.eti.ksg.oop.lab2.throughthewoods;

/**
 * Types of terrain that can be encoutered by participants.
 * @author TB
 */
public enum TerrainType {
    /**
     * Easy terrain
     */
    ROAD,
    
    /**
     * Little more difficult than {@link pl.edu.pg.eti.ksg.oop.lab2.throughthewoods.TerrainType#ROAD}
     */
    PATH,
    
    /**
     * Terrain in which you shoud move carefully.
     */
    HIGH_FORESST,
    
    /**
     * Hard terrain
     */
    LOW_FOREST,
    
    /**
     * Dangerous terrain, almost impossible to pass.
     */
    SWAMP;
}
