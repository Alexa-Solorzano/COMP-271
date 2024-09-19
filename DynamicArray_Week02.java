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
import java.util.Arrays; 
public class DynamicArray_Week02 {

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
        this(DEFAULT_SIZE); 
    } // default constructor

//that returns true if target is present in the underlying array and false if it isn't.
    public boolean contains(String target){
        int i=0; //start checking from the beginning of foundation array
        boolean found = false;  //track whether target has been found 
        while(i < foundation.length && !found){ // as long as i is less than the length of the foundarion array AND found is false
            found = foundation[i].equalsIgnoreCase(target); //check if foundation[i] is equal to target 
            i++; //and keep checking the next element until we hit the end of the array 
        } 
        return found;
    }
//that returns the string in position [index] in the underlying array or null if something wrong.
    public String get(int index){
        if(index < 0 || index >= foundation.length){ //is the index less than 0 or greater than/equal to the length of the foundation array?
            return null; //index is invalid/out of bounds therefore null 
        } 
        return foundation[index]; // if it is in bounds of the array, return the string located at foundation[index]
     }
    /**
    that returns the value in position [index] in the underlying array then removes that value from the array.
    shift the elements in the array to accomodate for the removed index
    */

    public String remove(int index){
        //check if the index is within valid range 
        if(index < 0 || index >= foundation.length){
            return null; 
        } 
        String removedString = foundation[index];
        //shift elements to the left to account for the missing index
        for(int i = index; i < foundation.length-1; i++){ //start from index to the rest of the array
            foundation[i] = foundation[i+1];//move to the left 
         }
        foundation[foundation.length-1] = null; //make last index null to represent the removal
        return removedString; //return the value in position[index]
    }
        
        
    /**
    The fill() method fills an array with a specified value.
    Arrays.fill(array, start, end, value) 
    that removes the value from position [index] in the underlying array.
    */
    
    public void delete(int index){
         if(index < 0 || index >= foundation.length){
            return; 
        } 
        String removedString = foundation[index];
        //shift elements to the left to account for the missing index
        for(int i = index; i < foundation.length-1; i++){ //start from index to the rest of the array
            foundation[i] = foundation[i+1];//move to the left 
         }
        foundation[foundation.length-1] = null; //make last index null to represent the removal
    /**
    that adds a string in the DynamicArray object, overcoming the fixed size of the foundation array.
    1) make an array deep copy 
    2) add space for one more index (inc. fixed size by one)
    3) add string to newly added index 
    4) replace old array with new array
    */
    public void insert(String string){
        int newArraySize= foundation.length + 1; 
        String [] insertedString = new String[newArraySize];
        for(int i=0; i<foundation.length; i++){
            insertedString[i] = foundation[i];
        }
        insertedString[foundation.length] = string; 
        foundation = insertedString;
        
    }
//that increases the size of the foundation array as needed to accomodate additional strings inserted to the object.
    private void resize() {
        int newArraySize = foundation.length * 2; 
        String [] resizedArray = new String[newArraySize];
        for(int i=0; i<foundation.length; i++){
            resizedArray[i] = foundation[i];
        }
        foundation = resizedArray;
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
        String testContainsEmptyData =  (!test.contains("Java")) ? PASS : FAIL;
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
        test.insert("Pascal");
        test.insert("Basic");
    } // method main
} // class DynamicArray
