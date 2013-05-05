import java.util.List;

/**
 * Defines the shared API between classes that implement a strategy and other
 *  classes that need its services.
 *
 * @author Jesse Nelson
 * @author Josh Gillham
 * @version 5-4-13
 */
public interface Strategy {
     /**
     * Generates a list of tickets, one ticket for each drawing. The tickets 
     *  each have a date which corresponds the dates in the history. 
     *
     * @param history is the data from the lottory history.
     * 
     * @return the list tickets that would hypothetically be purchased.
     */
	public List< Ticket > play ( final List< Drawing > history );
    
    /**
     * Compares the history with the list of tickets. The output is the hits
     *  for each ticket.
     *
     * @param tickets the list of tickets purchased.
     * @param history the list of ticket drawings.
     *
     * @return the list of hits for each ticket.
     */
	public List< Hit > analyze ( final List< Ticket > tickets,
     final List< Drawing > history );
    
    /**
     * Prints the results of ticket winners to the standard output.
     *
     * @param hits the list of ticket scores.
     */
	public void printResults ( List< Hit > hits );
    
	/** Optional. If we want to graph the data with java. */
	// public void graphData ( );
}
