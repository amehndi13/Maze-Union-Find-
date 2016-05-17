//Anuj Mehndiratta JHED: amehndi1
//Data Structures Project 2
//September 21, 2015

/**
 * The UnionFind class.
 */
public class UnionFind {
    /**
     * Array for the nodes.
     */
    private int[] array;
    /**
     * Array for the weights.
     */
    private int[] weights;
    /**
     * UnionFind constructor.
     * @param size - the size of the array
     */
    UnionFind(int size) {
        this.array = new int[size]; // Create node array
        this.weights = new int[size];
        for (int i = 0; i < size; i++) {
            this.array[i] = -1;       // Each node is its own root to start
            this.weights[i] = 1;
        }
      

    }
    /**
     * This method checks to make sure that everything is in the same set.
     * @return true - if everything is in the same set
     */
    public boolean oneSet() {
        int j = 0;
        for (int i = 1; i < this.array.length; i++) {
            if (this.find(i) != this.find(j)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Unions two sets if they have no overlap in elements.
     * @param a - one of the inputs
     * @param b - one of the inputs
     */
    public void union(int a, int b) {
        int root1 = this.find(a);     // Find root of node a
        int root2 = this.find(b);     // Find root of node b
        if (root1 != root2) {          // Merge with weighted union
            if (this.weights[root2] > this.weights[root1]) {
                this.array[root1] = root2;
                this.weights[root2] += this.weights[root1];
            } else {
                this.array[root2] = root1;
                this.weights[root1] += this.weights[root2];
            }
        }
    }

    
    /**
     * Return the root of curr's tree with path compression.
     * @param curr - the int that the method is trying to find
     * @return the int in the array where it was found
     */
    public int find(int curr) {
        if (this.array[curr] == -1) {
            return curr; // At root
        }
        this.array[curr] = this.find(this.array[curr]);
        return this.array[curr];
    }


}