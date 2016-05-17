//Anuj Mehndiratta JHED: amehndi1
//Data Structures Project 2
//September 21, 2015
import java.util.Random;

/**
 * Array based implementation of our generic BaG interface.
 * @author Joanne Selinski
 * @param <T> the base type of the objects in the bag
 *
 */
public class BaGArray<T> implements BaG<T> {

    /** class member to be used for the random remove method. */
    private static Random randy = new Random();
    /** default starting size of a bag. */
    private static final int SSIZE = 10;

    /** the bag itself. */
    private T[] bag;
    /** how many things are in the bag. */
    private int size;


    /**
     * Create an empty bag with a default starting size.
     */
    public BaGArray() {
        this.bag = (T[]) new Object[SSIZE];
        this.size = 0;
    }

    /**
     * Add an object to the bag, duplicates ok, no limit on bag size.
     * @param o the object to add
     */
    public void add(T o) {
        if (this.size == this.bag.length) { // bag is full, need to resize
            T[] temp = (T[]) new Object[this.size * 2];
            for (int i = 0; i < this.bag.length; i++) {
                temp[i] = this.bag[i];
            }
            this.bag = temp;
        }
        this.bag[this.size++] = o;
    }

    /**
     * Remove a random thing from the bag, where all objects are
     * equally likely to be chosen.
     * @return the object removed, or null if the bag is empty
     */
    public T remove() {
        int rand = randy.nextInt(this.bag.length);
        if (this.isEmpty()) {
            return null;
        } else {
            return this.remove(this.bag[rand]);
        }
    }

    /**
     * Get a specific thing from the bag, if there.
     * @param o the object to remove (1 instance)
     * @return the object removed, or null if not found
     */
    public T remove(T o) {
        int where = this.find(o);
        if (where == -1) {
            return null;
        } else {
            T temp = (T) this.bag[where];
            this.size--;
            this.bag[where] = this.bag[this.size];
            this.bag[this.size] = null;
            return temp;
        }
    }
        
    /**
     * Find out if an object is in the bag.
     * @param o the object to be matched
     * @return true if found, false otherwise
     */
    public boolean contains(T o) {
        return this.find(o) != -1;
    }

    /**
     * Get the location of an object in the Bag, if it's there.
     * @param o the object to find
     * @return the index of the first occurrence, or -1 if it's not there.
    */
    private int find(T o) {
        for (int i = 0; i < this.size; i++) {
            if (this.bag[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Get the number of items in the bag.
     * @return how many
     */
    public int size() {
        return this.size;
    }


    /**
     * Empty the bag of all items.
     */
    public void clear() {
        this.bag = (T[]) new Object[SSIZE];
        this.size = 0;
    }

    /**
     * Check whether the bag has any items.
     * @return true if it is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Display the items of the bag using their string forms,
     * in a comma delimited list format enclosed in parens.
     * For example: (item1, item2, item3)
     * @return the string list of items
     */
    public String toString() {
        String result = "(";
        for (int i = 0; i < this.size; i++) {
            result += this.bag[i].toString();   
            if (i < this.size - 1) {
                result += ", ";
            }
        }
        result += ")";
        return result;
    }

}
