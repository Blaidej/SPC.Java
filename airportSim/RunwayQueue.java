import java.util.*;// to use some list functionsimport java.util.LinkedList; // for using a linked list import java.util.Queue; // for using the java queues /** * airportSimulations an airport with airplanes taking off and landing. The * landing planes get priority over the planes on the ground. The simulation * will * * @author Blaine Jacques * */public class RunwayQueue{    //Queue for planes to take off from    private Queue<Airplane> airplaneTakeoffQueue;    //Queue for planes waiting to land    private Queue<Airplane> airplaneLandingQueue;    //gives a number of airplanes Total, each plane assigned a number    private int airplaneNumber;    //gives a number of airplanes landing, each plane assigned a number    private int landingAirplaneNumber;    //each plane assigned a number, and gives number of planes taken off    private int takeoffAirplaneNumber;    //can count the number of planes that successfully landed    private int numberLanded;    //can count the number of planes that successfully took off    private int numberTakeoff;    //numCrash // the number of crashes in the simulated time    private int numCrashed;    // average wait time for the plane to takeoff    private double avgWaitTakeoff;    // average time that a plane spent in the landing queue    private double avgWaitLanding;    //can track the total time that planes wait to land    private int totalWaitForLanding;    //can track the total time that planes wait to takeoff    private int totalWaitForTakeoff;    /**     * Runway queue builds an instance of the landing and takeoff queues It also     * calls reset to ensure intialization of data fields.     */    public RunwayQueue() {        airplaneTakeoffQueue = new LinkedList<>();        airplaneLandingQueue = new LinkedList<>();        reset();    } // end default constructor    /**     * Aiport Simulation runs the primary loop that takes and makes new airplane     * objects, taking and adding them to the queues. Then taking and landing or     * takingoff if they can, while using the user submitted variables.     *     * @param timeToLand The amount of time to Land an airplane     * @param timeToTakeoff The amount of time it takes to for an airplane to     * takeoff     * @param probabilityLanding// The chance an airplane is going to get added     * to the landing queue     * @param probabilityTakeoff The change an airplane is going to get added      * to the takeoff queue     * @param maxFuelLife The amount of time an airplane can wait in the landing     * queue without crashing     * @param maxSimulationTime The amount of time the user wants the simulation      * to run. Think of these as minutes in general.     */    public void airportSimulation(int timeToLand, int timeToTakeoff,                                  double probabilityLanding,                                  double probabilityTakeoff,                                  int maxFuelLife, int maxSimulationTime) {        int timeToLandLeft = 0;// intializing time to land at 0;        int timeToTakeoffLeft = 0; //intializing time to takeoff at 0;        //This is the loop that will run for the length of the specified         //Simulation        for (int clock = 0; clock <= maxSimulationTime; clock++)        {            //Airplane landing generator + adds to end of line.            if (Math.random() < probabilityLanding)            {                airplaneNumber++;//increments the plane's number                landingAirplaneNumber++;//increments the landing plane's number                //makes an airplane named nextArrival                Airplane nextArrivalLanding = new Airplane(clock,                        landingAirplaneNumber);                //adds the next airplane to the queue                airplaneLandingQueue.add(nextArrivalLanding);                            } // end if            //Airplane takeoff generator + adds to end of line.            if (Math.random() < probabilityTakeoff)            {                airplaneNumber++;//increments the plane's number                takeoffAirplaneNumber++;//increments the take off plane's number                                //makes an airplane named nextArrival                Airplane nextArrivalTakeoff = new Airplane(clock,                                             takeoffAirplaneNumber);                //adds the airplane to the queue                airplaneTakeoffQueue.add(nextArrivalTakeoff);				            } // end if            /**             * ***********The Above operations happen every cycle*************             */            /* if airplaneLandingQueue is not Empty, then airplanes wanting to                takeoff need to wait for those landing airplanes.             */            /*If airplane is landing or taking off, the clock still continues,              airplanes are still being made and being added to their               corresponding lines             */            /*if there is a planing landing, the runway is busy*/            if ((timeToLandLeft > 0) || (timeToTakeoffLeft > 0))            {                if (timeToLandLeft > 0)                {                    timeToLandLeft--;                }                if (timeToTakeoffLeft > 0)                {                    timeToTakeoffLeft--;                }            } //if the Landing queue is not empty, we want a plane to land             else if (airplaneLandingQueue.peek() != null)            {                //removes the airplane from the Landing queue                Airplane nextAirplaneLanding = airplaneLandingQueue.remove();                //gets time waited by the plane landing                int timeWaitedLanding =                         clock - nextAirplaneLanding.getArrivalTime();                /*if an airplane is landing, and the timeWaitedLanding exceeds                 maxFuelLife it crashes, the numCrashed is tracked, but                the airplane info doesn't get added                  */                if (timeWaitedLanding > maxFuelLife)                {   					                    numCrashed++;                    //totalWaitForLanding += timeWaitedLanding;                }else                {                    /*otherwise the plane does land*/                     totalWaitForLanding += timeWaitedLanding;                    numberLanded++;                    timeToLandLeft = timeToLand;                }            } // end if            //if the landing queue is empty and the takeoff queue is not             //empty we take and have a plane take off            else if ((airplaneLandingQueue.peek() == null)                     && (airplaneTakeoffQueue.peek() != null))            {                //removes the airplane from the Landing queue                Airplane nextAirplaneTakeoff = airplaneTakeoffQueue.remove();                                //takes the time to take off so the loop gets entered                timeToTakeoffLeft = timeToTakeoff;                //gets time that it took the plane waited to takeoff                int timeWaitedTakeoff =                         clock - nextAirplaneTakeoff.getArrivalTime();                //adds the total amount to wait for takeoff                totalWaitForTakeoff += timeWaitedTakeoff;                //increment the number of takeoffs                numberTakeoff++;            } // end if 			        } // end for        /*for each plane in landing queue, see if any of the planes trying to 		land have exceeded their waiting time and have crashed         */        int airplanesNotLandedYet = airplaneLandingQueue.size();        for (int i = 0; i < airplanesNotLandedYet; i++)        {            //removes the airplane from the Landing queue            Airplane nextAirplaneLanding = airplaneLandingQueue.remove();                        int timeWaitedLanding =                    maxSimulationTime - nextAirplaneLanding.getArrivalTime();                        /*if an airplane is landing, and the timeWaitedLanding exceeds               maxFuelLifem it crashes, the numCrashed is tracked, but the               airplane info doesn't get added              */            if (timeWaitedLanding > maxFuelLife)            {                numCrashed++;            }        }    } // end airportSimulation    /**     * Displays summary of results of the simulation.     */    public void displayResults() {        System.out.println();        System.out.println("Number of planes that took off = " + numberTakeoff);        System.out.println("Number of planes Landed = " + numberLanded);        System.out.println("Number of Crashes = " + numCrashed);				//Calculation for averages        double avgWaitLanding = ((double) totalWaitForLanding) / numberLanded;        double avgWaitTakeoff = ((double) totalWaitForTakeoff) / numberTakeoff;        System.out.println("Average time waited to land = " + avgWaitLanding);        System.out.println("Average time waited to takeoff= " + avgWaitTakeoff);           } // end displayResults    /**     * Initializes the simulation values and queues.     */    public final void reset() {        airplaneLandingQueue.clear();        airplaneTakeoffQueue.clear();        airplaneNumber = 0;        landingAirplaneNumber = 0;        takeoffAirplaneNumber = 0;        numCrashed = 0;        numberLanded = 0;        numberTakeoff = 0;        totalWaitForLanding = 0;    } // end reset} // end RunwayQueue