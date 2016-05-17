/**
 * Cell represents a single tile of a maze.
 *
 * 600.226 Data Structures, Fall 2015, Project 2
 *
 */
public class Cell {

    /** whether or not wall on north side exists. */
    private boolean north; 
    /** whether or not wall on south side exists. */
    private boolean south; 
    /** whether or not wall on east side exists. */
    private boolean east; 
    /** whether or not wall on west side exists. */
    private boolean west; 
    /** Indicates whether the cell is on the solution path */
    public boolean visited;
    /** Keeps track of whether a cell has been explored. */
    public boolean path;
    /** Integer for the cells rows; */
    public int cellRows;
    /** Integer for the cell columns; */
    public int cellCols;

    public Cell parent;
    /**
     * Cell constructor, has four walls by default.
     */
    public Cell(int r, int c) {
        this.north = true;
        this.south = true;
        this.west = true;
        this.east = true;
        this.visited = false;
        this.path = false;
        this.cellRows = r;
        this.cellCols = c;
        this.parent = null;
    }
    
    /**
     * Cell constructor with defined wall parameters.
     * @param n true if north end of the tile has a wall
     * @param s true if south end of the tile has a wall
     * @param w true if west end of the tile has a wall
     * @param e true if east end of the tile has a wall
     */
    public Cell(boolean n, boolean s, boolean e, boolean w) {
        this.north = n;
        this.south = s;
        this.east = e;
        this.west = w;
    }
    
    
    // Getters and Setters
    
    /**
     * Return whether this cell's north wall exists.
     * @return true if and only if the north wall exists
     */
    public boolean hasNorth() {
        return this.north;
    }

    /**
     * Indicate whether this cell's north wall should exist.
     * @param northVal  true if wall exists; false otherwise
     */
    public void setNorth(boolean northVal) {
        this.north = northVal;
    }

    /**
     * Return whether this cell's south wall exists.
     * @return true if and only if the south wall exists
     */
    public boolean hasSouth() {
        return this.south;
    }

    /**
     * Indicate whether this cell's south wall should exist.
     * @param southVal  true if wall exists; false otherwise
     */
    public void setSouth(boolean southVal) {
        this.south = southVal;
    }

    /**
     * Return whether this cell's west wall exists.
     * @return true if and only if the west wall exists
     */
    public boolean hasWest() {
        return this.west;
    }

    /**
     * Indicate whether this cell's west wall should exist.
     * @param westVal true if wall exists; false otherwise
     */
    public void setWest(boolean westVal) {
        this.west = westVal;
    }

    /**
     * Return whether this cell's east wall exists.
     * @return true if and only if the east wall exists
     */
    public boolean hasEast() {
        return this.east;
    }

    /**
     * Indicate whether this cell's east wall should exist.
     * @param eastVal  true if wall exists; false otherwise
     */
    public void setEast(boolean eastVal) {
        this.east = eastVal;
    }
    /**
     * Sets the path boolean.
     * @param pathVal true if part of path; false otherwise
     */
    public void setPath(boolean pathVal) {
        this.path = pathVal;
    }
    /**
     * Sets the visited boolean.
     * @param visitedVal true if has been visited; 
     * false otherwise
     */
    public void setVisited(boolean visitedVal) {
        this.visited = visitedVal;
    }
    /**
     * Gets the path boolean.
     */
    public boolean getPath() {
        return this.path;
    }
    /**
     * Gets the visited boolean.
     */
    public boolean getVisited() {
        return this.visited;
    }
    /**
     * Sets the cellCols integer.
     * @param cellNum the number of the cell
     */
    public void setCellCols(int cellNum) {
        this.cellCols = cellNum;
    }
    /**
     * Sets the cellRows integer.
     * @param cellNum the number of the cell
     */
    public void setCellRowss(int cellNum2) {
        this.cellRows = cellNum2;
    }
    /**
     * Sets the cellCols integer.
     * @param cellNum the number of the cell
     */
    public int getCellCols() {
        return this.cellCols;
    }
    /**
     * Sets the cellRows integer.
     * @param cellNum the number of the cell
     */
    public int getCellRows() {
        return this.cellRows;
    }

}
