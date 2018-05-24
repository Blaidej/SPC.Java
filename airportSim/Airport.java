import java.util.Scanner;//allows user input

/**
 * The airport is the main class driver that runs an airport simulation to 
 * see if an airport needs to add another runway by how many crashes are caused
 * by different landing and takeoff times. Also by how busy the landing and
 * takeoff queues are.
 * @author Blaine Jacques
 */
public class Airport
{

    public static void main(String[] args) {
        
        //Airport Simulation Introduction
		System.out.println("");
        System.out.println("HELLO AND WELCOME TO THE AIRPORT SIMULATOR");
        System.out.println("------------------------------------------");
        System.out.println("As you give your input for time, think of it as"
                + " minutes and think of the decimal between\n zero"
                + " and one as the percentage of "
                + "arrivals and departures of the airplanes \n "
                + "coming into this airport.");
        System.out.println("------------------------------------------");
        
        //fields for input
        int timeToLand;// amount of time needed for a plane to land
        int timeToTakeoff; // amount of time needed for plane to take off
        // the probability of an arrival of a plane into the landing queue
        double probabilityLanding; 
        // the probability of an arrival of a plane into the takeoff queue
        double probabilityTakeoff;
        int maxFuelLife; // amount of fuel for planes in the landing queue
        int maxSimulationTime; // amount of fuel for planes in the landing queue

        timeToLand = getInt(
                "What is the amount of time needed for one plane to land:");
        timeToTakeoff = getInt(
                "What is the amount of time needed for one plane to take off:");
        probabilityLanding = getDouble(
                "What is the probability of an arrival of a plane into the "
                        + "landing queue (input range is decimal 0 - 1): ");
        probabilityTakeoff = getDouble(
                "What is the probability of an arrival of a plane into the"
                        + " takeoff queue (input range is decimal 0 - 1): ");
        maxFuelLife = getInt(
                " What is the maximum amount of time that a plane can stay in\n"
                + "the landing queue without running out of fuel and crashing:");
        maxSimulationTime = getInt(
                "What is the total length of time to be simulated:");

        //creating simulation of runway
        RunwayQueue simulationOne = new RunwayQueue();

        //call and sending variables to runway class
        simulationOne.airportSimulation(timeToLand, timeToTakeoff,
                probabilityLanding, probabilityTakeoff, maxFuelLife,
                maxSimulationTime);
        //calling to display results of the simulation
        simulationOne.displayResults();
    }

    /**
     * A simple method that checks the user input for a valid response, 
     * if no valid response is given it is auto set to 10
     * @param rangePrompt is the string asked in the method call
     * @return Returns the int for the question asked
     */
    public static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
    }

    /**
     * A simple method that checks the user input for a valid response, 
     * if no valid response is given it is auto set to .5
     * @param rangePrompt is the string asked in the method call
     * @return Returns the double for the question asked
     */
    public static double getDouble(String rangePrompt) {
        Scanner input;
        double result = .5;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextDouble();

        } catch (NumberFormatException e)
        {
            System.out.println("Could not convert input to an double");
            System.out.println(e.getMessage());
            System.out.println("Will use .5 as the default value");
        } catch (Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use .5 as the default value");
        }
        return result;
    }
}
