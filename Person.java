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

    public void makeRandomSound(){
    /**
    * 1) Declare an array with random sounds
    * 2) using the random class, generate a random index number based on the length of the array
    * 3) assign variable representing the random sound chosen and attach it to the random index 
    * 4) print out sound
    */
        String[] sounds = {"PLOP", "SPLAT", "GUSH", "HOOT", "HOWL", "POP", "CRUNCH", "BEEP", "SQUEAK", "DRIP", "BANG", "ROAR", "BLEAT", "SNAP", "FLUTTER", "CRACK", "PURR", "SIZZLE", "CLAP", "RATTLE"};
        Random random = new Random();
        int index = random.nextInt(sounds.length);
        String randomSound = sounds[index];
        System.out.println(randomSound);
    }
    public void performSillyDance(){
        System.out.println("The footwork for the Caballo Dorado - Payaso de Rodeo is complicated but simple.\nYou start off with one arm/fist in the air and the stomp with opposite foot to the beat." +
                          "Once the music starts you take two steps to the right followed by two steps to the back. Then you take two steps to the back and two steps forward. From this position make a half turn" +
                          "to your right and repeat the steps starting from the two steps to the right. Repeat until the 4 minuet and 14 second song is over.");
    }

    public String reciteAlphabetBackwards(){
        /**
        * 1) declare an array with all 26 letters of the alphabet 
        * 2) declare a variable with a random number that will represent the element of the skipped letter
        * 3) for loop that will print out the array backwards 
        * 4) if(loop traversing is not the skipped element)
        *   then print out the array  
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

    /** Count to ten in an unusual way (maybe skip a number) */
    public void countToTenWeirdly(){
    /**
    * 1) declare an array with words in different languages counting to 10 
    * 2) declare a variable with a random number that will represent the element of the skipped letter
    * 3) for loop that will print out the array  
    * 4) if(loop traversing is not the skipped element)
    *      then print out the array  
    */
        String[] tenAroundTheWorld = {"UNO","DEUX", "THREE", "QUATRE", "FUNF", "SEIS", "SEPT", "ACHT", "NEUF", "TEN"};
        Random random = new Random();
        int skippedNumber = random.nextInt(10);
        for(int i=0; i<=tenAroundTheWorld.length; i++){
            if(i != skippedNumber){
               System.out.print(tenAroundTheWorld[i]) + " ";
            }
        }
    }

    public String createWhimsicalPoem(String topic){
    /**
    * 1) ensure there are variables representing random words from PoemWords java file 
    * 2) start the poem, including the String topic in the first line 
    */
        Random random = new Random();
        String insertPoemWord1 = getRandomPoemWord(random);
        String insertPoemWord2 = getRandomPoemWord(random);
        String insertPoemWord3 = getRandomPoemWord(random);
        String insertPoemWord4 = getRandomPoemWord(random);
        String insertPoemWord5 = getRandomPoemWord(random);
        String insertPoemWord6 = getRandomPoemWord(random);
        String insertPoemWord7 = getRandomPoemWord(random);
        
        String whimsicalPoem = "In the " + topic + " of " + insertPoemWord1 + ",\nWe find the " + insertPoemWord2 + " of " + insertPoemWord3 + "\nWhere " + insertPoemWord4 + 
            " meets " + insertPoemWord5 + ",\nAnd " + insertPoemWord6 + " dances with " + insertPoemWord7 + ".");
        return whimsicalPoem; 
    }

    private String getRandomPoemWord(Random random){
        int index = random.nextInt(PoemWords.words.length);
        return PoemWords.words[index];
    }
    
    public void winStateLottery(){
    /**
    * 1) In Illinois Loto, players pick 6 numbers from 1-52
    * 2) declare an array that represents the 6 winning lottery number
    * 3) keep count of how many winning numbers we have 
    * 4) while we have less than 6 lottery numbers, generate random number from 1-52 
    * 5) need to keep track and ensure each number is unique --> boolean
    * 6) declare boolean as true so that we know when a winning lottery number is repeated and boolean turns false 
    * 7) for each winning lottery number, a random number should be assigned, and if it is repeated boolean equals false 
    * 8) if it is unique, add it to the winning lottery number array and increment the count to accurately keep track
    */
        Random random = new Random();
        int[] winningLottoNumbers = new int[6];
        int count =0; 
        while(count < 6){
            int randomLottoNumber = random.nextInt(52)+1; //+1 ensures it generates a number from 1-52
            boolean isUnique = true;
        }
        
        for(int i = 0; i < count; i++){
            if(winningLottoNumbers[i] == randomLottoNumber){
                isUnique = false; 
            }
        }
       if(isUnique){
           winningLottoNumbers[count] = randomLottoNumber; 
           count++;
       }
    }
}
