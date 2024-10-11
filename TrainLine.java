public class TrainLine {

    /** The name of the trainline */
    private String name;
    /** Points to the first station in the trainline */
    private TrainStation head;
    /** Points to the last station in the trainline */
    private TrainStation tail;
    /** Keeps a running tally of train stations in the trainline */
    private int numberOfStations;

    /** Full constructor */
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            // If head is not null, there is one station in the line
            this.numberOfStations = 1;
        }
        // At initialization head and tail point to the same station even if null
        this.tail = null;
    } // full constructor

    /** Basic constructor */
    public TrainLine(String name) {
        this(name, null);
    } // basic constructor

    /**
     * Creates a new station with the given name and adds it to the end of the line.
     */
    public void add(String name) {
        // Create the new station to add
        TrainStation newStation = new TrainStation(name);
        // Determine where to place the new station
        if (this.head == null) {
            // Trainline is empty, make new station the head of the line
            this.head = newStation;
        } else {
            // When there is a head station already, add the new station after the last
            // station in the line.
            this.tail.setNext(newStation);
        }
        // The new station becomes the tail station of the line
        this.tail = newStation;
        // Update station count
        this.numberOfStations++;
    } // method add

    /** Returns the number of stations in the line >= 0 */
    public int getNumberOfStations() {
        return numberOfStations;
    } // method getNumberOfStations

    public TrainStation remove(int position) {
        TrainStation removedStation = null;
        if (position >= 1 && position <= this.numberOfStations) {
            // Commence safe operations
            if (position == 1) {
                // Remove head
                removedStation = this.head;
                this.head = this.head.getNext();
            } else {
                // Find the station prior to the one to be removed
                TrainStation cursor = this.head;
                for (int i = 1; i < position-1; i++) {
                    cursor = cursor.getNext();
                }
                // cursor should be at the prior station
                if (cursor.getNext() == this.tail) {
                    this.tail = cursor;
                }
                removedStation = cursor.getNext();
                cursor.setNext(cursor.getNext().getNext());
            }
            this.numberOfStations--;
            removedStation.setNext(null);
        }
        return removedStation;
    }

    public void insert(String newStationName, int position){
        /**
        * Make a new TrainStation object reflecting the new inserted station name 
        * protect against exceptions by ensuring the position is within the linked list 
        * if the inserted station right at the head of the list, 
        * the head should be replaced by the new station name 
        * keep track of the linked list by using a cursor starting at the head
        * traverse the linked list until we get to the station prior to the position 
        * update the cursor to point to the next station in the list, moving the cursor foward to get in position before the insertion point
        * link the new station to the existing station that comes after the cursor 
        * update the pointer of the cursor to point to the new Station link 
        * if there is no station after the new inserted station, it should be declared as the tail as well
        * update the number of stations 
        */
        TrainStation newStation = new TrainStation(newStationName);
        if(position >= 1 && position <= this.numberOfStations+1){
            if(position==1){
                //insert the head
                newStation.setNext(this.head); 
                this.head = newStation;
                if(this.numberOfStations==0){ //if the list was empty, newStation is also the tail 
                    this.tail = newStation;
                }
            } else {
            TrainStation cursor = this.head; 
            for(int i = 1; i < position-1; i++){
                    cursor = cursor.getNext();
                }
                // Insert new station after cursor 
                newStation.setNext(cursor.getNext());
                cursor.setNext(newStation);
                if(newStation.getNext()==null){
                    this.tail = newStation;
                }
            }
            this.numberOfStations++;  
        }
    }

    public String toString(){
        String[] stationNames = new String[numberOfStations];
        TrainStation current = head;
        int index = 0; 

        while(current != null){
            stationNames[index++] = current.getName();
            current = current.getNext();
        }

        String result = name + "-->";
        for(int i=0; i < stationNames.length; i++){
            result += stationNames[i];
            if(i < stationNames.length - 1){
                result += "-->";
            }
        }
        return result; 
        //still need:
        //As long as the return string printout is a folded (snake-like) path with arrows moving in one direction in one line and the opposite direction in the other line, and the corners are displayed properly, and each line does not exceed 80 characters, you are fine.

    }

    
    public static void main(String[] args) {
        // A few station names
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : CTA.RED_LINE_SB_NAMES) {
            redLineSB.add(station);
        }

        redLineSB.insert("COMP 271", 5);
        System.out.println(redLineSB);
        // An empty trainline
        prep_TrainLine brownLineSB = new prep_TrainLine("Brown Line SB");
        // A random station name
        String randomName = "Oak Park";
    } // method main
} // class TrainLine
/**
* During class I make sure that I am fully engaged through my note taking. I ensure to take intensive notes each time I attend class.
* I write down what professor Leo is explaining, I take moments to just understand the metaphors, and I write down my own suggestions/ideas.
* I use these notes to reflect and connect to the themes of the week's assignment. I also make sure to look over the material from the previous week.
* I understand that many of the topics learned are built on top of each other, and connect as we learn more. 
* I have never had homework that is assigned on Friday and is due the next week. I think I’ve been caught in the cycle of not looking at the assignment until Monday.
* I think moving forward I need to account for myself to look over the assignment over the weekend. I am trying to evolve my style of coding with the new style shown in the solutions.
* I am trying to elevate my coding style to simplify the code. I come to class every week, and the only times I have missed have been due to health-related issues that I let Professor Leo know beforehand via emails.
* Based on this reflection, I expect my course grade to be a B-. 
*/
