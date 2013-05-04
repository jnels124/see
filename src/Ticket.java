import java.sql.Date;
import java.lang.*;
import java.util.*;

public class Ticket {
	List<Integer> playNumbers;			// Numbers being played
	Map<Date, List<Integer> > hits;	    // Hash map of playNumbers hit on date. index of list is the ctr for index in playNumbers
	//List<Integer> numbersHit;	 		// List of counters for playNumbers. Ctr is for each index in playNumbers
	double winnings;			 		// Accumulated winnings for playing ticket---> We may not use this!
}