/** ADT BaG Interface is a collection of objects of the same type.
    Examples: candy bag, scrabble tiles, Santa Claus' sack of toys.
    Assumptions: duplicates allowed, unordered, unlimited size, unindexed
    (not positional).
    @param <T> the base type of the objects in the bag
*/

public interface BaG<T> {

    /** Find out the number of things in the bag.
        @return how many
    */
    int size();

    /** Find out if the bag is empty.
        @return true if empty, false otherwise
    */
    boolean isEmpty();

    /** Dump out the contents of the bag.
    */
    void clear();

    /** Add an item to the bag, enlarging it if necessary.
        @param o the item to add
    */
    void add(T o);

    /** See if the bag contains a particular item.
        @param o the item to search for
        @return true if there, false otherwise
    */
    boolean contains(T o);

    /** Pull a random object out of the bag, if not empty.
        @return the object, null otherwise
    */
    T remove();         // pulls out random object

    /** Pull a particular object out of the bag, if there.
        @param o the object to remove
        @return the object if found, null otherwise
    */
    T remove(T o);  // overloads previous method

    /*  Inherited from Object
    String toString();
    */

}
