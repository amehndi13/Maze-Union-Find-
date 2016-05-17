//Anuj Mehndiratta JHED: amehndi1
//Data Structures Project 2
//September 21, 2015
 /** 
 * The wall class.
 */
public class Wall {
   
    /** 
    * Integer for the value of cell2
    * 0 if the wall is and outer wall.
    */
    private int c1;
    /**
    * Integer for the value of cell2
    * 0 if the wall is and outer wall.
    */
    private int c2;
    /**
    * Constructor for the Wall Class.
    * @param cell1 - the value to set parentcell to
    * @param cell2 - the value to set cell2 to
    */
    public Wall(int cell1, int cell2) {
        this.c1 = cell1;
        this.c2 = cell2;
    }
    /**
    * Converts the wall to a string.
    * @return string of the wall
    */
    public String toString() {
        return this.c1 + ", " + this.c2;
    }
    /**
    * Method to set the value of cell1.
    * @param c - the value to set
    */

    public void setCell1(int c) {
        this.c1 = c;
    }
    /**
    * Method to get the value of cell1.
    * @return the value of cell1
    */
    public int getCell1() {
        return this.c1;
    }
    /**
    * Method to set the value of cell2.
    * @param c - the value to set
    */
    public void setCell2(int c) {
        this.c2 = c;
    }
    /**
    * Method to return the value of cell2.
    * @return the value of cell2
    */
    public int getCell2() {
        return this.c2;
    }
    /**
    * Method to determine if the properties.
    * are equal in both Walls
    * @param w - the object you are seeing if its equal to
    * @return true if the the values are equal 
    * false if they are not
    * 
    */
    public boolean equals(Object w) {
        if (w instanceof Wall) {
            Wall wall = (Wall) w;
            boolean test = (this.getCell1() == wall.getCell1() 
                    && this.getCell2() == wall.getCell2());
            return test;
        }
        return false;
    }
    /**
     * Just used to eliminate checkstyle errors.
     * @return int 0
     */
    public int hashCode() {
        return 0;
    }  
}