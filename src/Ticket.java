//import java.sql.Date;
import java.lang.*;
import java.util.*;

/**
 * Defines the ticket purchase data.
 *
 * @author Jesse Nelson
 * @author Josh Gillham
 * @version 5-4-13
 */
public class Ticket extends Drawing {
    /** Accumulated winnings for playing ticket---> We may not use this! */
	double winnings;
    public Ticket( final Date drawingDate, final List<Integer> winningNumbers, 
     final double jackpot ) {
        super( drawingDate, winningNumbers, jackpot );
    }
    
    public static initializePicks ( int numPlays ) {
    	List < Integer > generatedNums;
    	List < Ticket > generatedTickets = new ArrayList < Ticket > ( numPlays ); 
    	Random numGenerator;
    	int i = 0;
    	while ( i < numPlays ) {
    		numGenerator = new Random ( (long) Drawing.MIN_BALL );
    		generatedNums = new ArrayList ( Drawing.NUM_BALLS );
    		for ( int j = 0; j < Drawing.NUM_BALLS; j++ ) {
    			generatedNums.add ( numGenerator.nextInt ( ) );
    		}
    		generatedTickets.add ( new Ticket ( new Date ( ), generatedNums ) );
    	}
    	return generatedTickets;
    }
}
