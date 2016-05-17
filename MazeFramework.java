//Anuj Mehndiratta JHED: amehndi1
//Data Structures Project 2
//September 21, 2015
import java.util.Random;

/**
 * MazeFramework class.
 */
public class MazeFramework implements Maze {

    /**
     * 2D array with all of the cells.
     */
    public Cell[][] cellArray;
    /**
     * BaGArray with walls.
     */
    public BaGArray<Wall> wallBag;

    /**
     * MazeFramework constructor.
     * Fills the BaGArray with all of the walls
     * @param rows - number of rows in the maze
     * @param cols - number of columns in the maze
     */
    public MazeFramework(int rows, int cols) {
        this.cellArray = new Cell[rows][cols];
        this.wallBag = new BaGArray<Wall>();
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cellArray[i][j] = new Cell();
                if (i == 0) {
                    this.wallBag.add(new Wall(counter , counter + cols));
                } else if (i == rows - 1) {
                    this.wallBag.add(new Wall(counter , counter - cols));
                } else {
                    this.wallBag.add(new Wall(counter , counter - cols));
                    this.wallBag.add(new Wall(counter , counter + cols));
                }
                if (j == 0) {
                    this.wallBag.add(new Wall(counter , counter + 1));
                } else if (j == cols - 1) {
                    this.wallBag.add(new Wall(counter , counter - 1));
                } else {
                    this.wallBag.add(new Wall(counter , counter + 1));
                    this.wallBag.add(new Wall(counter , counter - 1));
                }
                counter++;
            }
        }


    }
    /**
     * Generate the maze.  This takes a constructed Maze object with
     * all of its walls present, and randomly removes interior walls until all 
     * cells of the maze are reachable from all other cells of the maze. 
     * Also removes the west wall of top left corner cell (for a maze start)
     * and the east wall of bottom right corner cell (for a maze finish line).
     */
    public void generateMaze() {
        //remove the start and end points
        this.cellArray[0][0].setWest(false);
        int numRows = this.getNumRows();
        int numCols = this.getNumCols();
        this.getCellAt(numRows - 1, numCols - 1).setEast(false);
        this.wallBag.remove(new Wall(1, 0));
        this.wallBag.remove(new Wall(numRows * numCols, 0));
        UnionFind uf = new UnionFind(numRows * numCols);
        Random randy = new Random();
        System.out.println(this.wallBag.toString());
        while (!uf.oneSet() || !this.wallBag.isEmpty()) { 
            Wall randomwall = this.wallBag.remove();
            if (randomwall == null) {
                continue;
            }
            if (uf.find(randomwall.getCell1()) 
                        != uf.find(randomwall.getCell2())) {
                uf.union(randomwall.getCell1(), 
                            randomwall.getCell2());
                this.removeWall(randomwall.getCell1(), 
                            randomwall.getCell2());
                System.out.println(this.wallBag.toString());
                this.removeWall(randomwall.getCell2(), 
                            randomwall.getCell1());
            //System.out.println(this.wallBag.toString());
            }
        }
        return;   
    
    }

    /**
     * Return the Cell object stored at the given (row, column) position.
     * @param r the row position of the Cell in the Maze object
     * @param c the col position of the Cell in the Maze object
     * @return the Cell object that is at the specified position
     */
    public Cell getCellAt(int r, int c) {
        return this.cellArray[r][c];
    }

    /**
     * Set the cell at the given (row, column) position to the provided cell.
     * @param r the row position of the new Cell in the maze
     * @param c the column position of the new Cell in the maze
     * @param cell the new Cell object to be set in the specified position
     */
    public void setCellAt(int r, int c, Cell cell) {
        this.cellArray[r][c] = cell;
    }

    /**
     * Return the number of rows in the maze.
     * @return the number of rows in the maze
     */
    public int getNumRows() {
        return this.cellArray.length;
    }

    /**
     * Return the number of columns in the maze.
     * @return the number of columns in the maze
     */
    public int getNumCols() {
        return this.cellArray[0].length;
    }
    /**
     * Method to remove wall from the cell object.
     * Updates the booleans in the cell
     * @param c1 - the frist integer value in the wall object
     * @param c2 - the second integer value in the wall object
     */
    public void removeWall(int c1, int c2) {
        
        int colNum = this.getNumCols();
        int i1 = (c1) / colNum;
        int j1 = (c1) % colNum;
        int i2 = (c2) / colNum;
        int j2 = (c2) % colNum;
        if (i1 == i2 - 1 && j1 == j2) {
            this.getCellAt(i1, j1).setSouth(false);
            this.getCellAt(i2, j2).setNorth(false);
        } else if (i1 == i2 + 1 && j1 == j2) {
            this.getCellAt(i1, j1).setNorth(false);
            this.getCellAt(i2, j2).setSouth(false);
        } else if (j1 == j2 + 1 && i1 == i2) {
            this.getCellAt(i1, j1).setWest(false);
            this.getCellAt(i2, j2).setEast(false);
        } else if (j1 == j2 - 1 && i1 == i2) {
            this.getCellAt(i1, j1).setEast(false);
            this.getCellAt(i2, j2).setWest(false);
        }         
    }
}
