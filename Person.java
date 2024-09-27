import java.util.Random;
public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;

    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     * 
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    //------------------- AUTO GENERATED METHODS ------------------------------
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public void performSillyDance(){
        System.out.println("The footwork for the Caballo Dorado - Payaso de Rodeo is complicated but simple.\nYou start off with one arm/fist in the air and the stomp with opposite foot to the beat." +
                          "Once the music starts you take two steps to the right followed by two steps to the back. Then you take two steps to the back and two steps forward. From this position make a half turn" +
                          "to your right and repeat the steps starting from the two steps to the right. Repeat until the 4 minuet and 14 second song is over.");
    }

    public String reciteAlphabetBackwards(){
        /**
        1) declare an array with all 26 letters of the alphabet 
        2) declare a variable with a random number that will represent the element of the skipped letter
        3) for loop that will print out the array backwards 
        4) if(loop traverses this one element (the variable))
           then print out the next element 
        */
        char[] alphabetOrder = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Random random = new Random();
        int skippedLetter = random.nextInt(26); //want a letter represent from element 0 to element 25
        StringBuilder backwardsResult = new StringBuilder();
        for(int i=25; i>=0; i--){
            if(i != skippedLetter){
                backwardsResult.append(alphabetOrder[i]).append(" ");
            }
        }
        return backwardsResult.toString().trim();
    }
}
