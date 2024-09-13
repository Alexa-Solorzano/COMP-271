/**
 * A simple class to demonstrate dynamic behavior with arrays. Objects of this
 * class store strings in an array that grows to match the demand for storage.
 * 
 * The class is based on an underlying string array. Objects can be initialized
 * to any size; otherwise they'll be initialized to the default size. For
 * example,
 * 
 * DynamicArray da1 = new DynamicArray(10);
 * 
 * will have initially room for 10 strings, while
 * 
 * DynamicArray da2 = new DynamicArray();
 * 
 * will have initially room for 4 strings.
 */
public class DynamicArray {

    /** Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    /** The underlying array for this class */
    private String[] foundation;

    /**
     * Full constructor. Initializes the underlying array to the specified size. The
     * size must be a positive, non zero value. Otherwise the constructor uses the
     * default size value.
     */
    public DynamicArray(int size) {
        // If size <= 0 use default -- this is a good time to demo ternary operator
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
    } // full constructor

    /** Array-based constructor -- used for testing */
    public DynamicArray(String[] data) {
        this.foundation = data;
    } // array-based constructor

    /**
     * Default constructor
     */
    public DynamicArray() {
        this(DEFAULT_SIZE)
    } // default constructor

    
//that returns true if target is present in the underlying array and false if it isn't.
    public boolean contains(String target){
        int i=0; 
        boolean found = false; 
        while(i < foundation.length && !found){
            found = foundation[i].equalsIgnoreCase(target);
            i++;
        } 
        return found;
    }
//that returns the string in position [index] in the underlying array or null if something wrong.
    public String get(int index){
        if(index < 0 || index >= foundation.length){
            return null; 
        } 
        return foundation[index];
     }
    /**
    that returns the value in position [index] in the underlying array then removes that value from the array.
    shift the elements in the array to accomodate for the removed index
    */

    public String remove(int index){
        if(index < 0 || index >= foundation.length){
            return null; 
        } 
        return foundation[index];
        int end = index + 1; 
        Arrays.fill(foundation, index, end, null);
     }
        
    /**
    The fill() method fills an array with a specified value.
    Arrays.fill(array, start, end, value) 
    that removes the value from position [index] in the underlying array.
    */
    
    public void delete(int index){
        int end = index + 1; 
        Arrays.fill(foundation, index, end, null);
    }
    
//that adds a string in the DynamicArray object, overcoming the fixed size of the foundation array.
    public void insert(String string){

    }
//that increases the size of the foundation array as needed to accomodate additional strings inserted to the object.
    private void resize() {

    }
    
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        // Test data
        String[] testData = {"Java", "Python", "C", "C++", "Fortran"};
        prep_DynamicArray test = new prep_DynamicArray(testData);
        prep_DynamicArray tset = new prep_DynamicArray(null);
        // Naive testing - I am ashamed to do this but I need 
        // to keep things simple for now.
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;
        String testContainsEmptyData =  (!tset.contains("Java")) ? PASS : FAIL;
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;
        String testGetOutOfBounds = (test.get(testData.length+1)==null) ? PASS : FAIL;
        String testRemove = (testData[1].equals(test.remove(1))) ? PASS : FAIL;
        String testRemoveNull = (test.remove(1) == null) ? PASS : FAIL;
        String testRemoveOutOfBounds = (test.remove(testData.length+1) == null) ? PASS :FAIL;
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n", testGetOutOfBounds);
        System.out.printf("\nTest for remove(1): .................... %s", testRemove);
        System.out.printf("\nTest for remove(null): ................. %s", testRemoveNull);
        System.out.printf("\nTest for remove(out of bounds): ........ %s\n\n", testRemoveOutOfBounds);
       // test.insert("Pascal");
       // test.insert("Basic");
    } // method main

} // class DynamicArray
