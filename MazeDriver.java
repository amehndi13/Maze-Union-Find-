/**
 * Driver to generate a random a Maze object.
 *
 * 600.226 Data Structures, Fall 2015, Project 2
 *
 * Takes desired number of rows and number of columns as command-line 
 * arguments.  (When the specified dimensions are too small or large, the
 * appearance of rendered maze may be improved by resizing the generated
 * window.)
 */

/**
 * Driver file to generate a random maze with specified dimensions.
 */
public final class MazeDriver {

    /**
     * For checkstyle compliance only.
     */
    private MazeDriver() {
    }


    /**
     * Generate a random maze.
     * @param args command-line arguments: first is number of rows, 
     *     then number of columns
     */
    public static void main(String[] args) {

        //Collect 2 command-line arguments specifying numbers of rows & columns
        if (args.length < 2) {
            throw new IllegalArgumentException("Two arguments are required.");
        }

        int numRows = 0;
        int numCols = 0;
        try {
            numRows = Integer.parseInt(args[0]);
            numCols = Integer.parseInt(args[1]);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Both arguments must be "
                + "integers.");
        }
        
        if (numRows < 1 || numCols < 1) {
            throw new IllegalArgumentException("Both arguments must be "
                + "positive.");
        }
        
        //Create new Maze framework using the given dimensions
        Maze maze = new MazeFramework(numRows, numCols);
        
        //Generate an actual maze at random
        maze.generateMaze();

        //Display the generated maze in a separate window
        MazeRenderer renderer = new MazeRenderer(maze);
        renderer.createAndShowGUI();
    }

}
