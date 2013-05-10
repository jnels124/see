import java.util.Random;

public class PickByHistory implements Strategy {
    private final List< Drawing > history;
    private List< Ticket > picks;
    public PickByHistory ( final List < Drawing >  history, final int numTickets ) {
	this.history = history;
	this.picks = initializePicks ( numTickets );
	//analyzeHistory ( ) 
    }
    
    /* static class numberQueue {
	public boolean enqueue ( int hitNum ) {
	}
	public int dequeue ( ) {}
	public boolean isEmpty () {
	}
    }*/

    public List< Ticket > play ( final List< Drawing > history ) {
	
    }

    public List< Hit > analyze ( final List< Ticket >, final List< Drawing > history ) {
	
    } 

    public void printResults ( List< Hit > ) {
	
    }

    // Initialize pick 
    private ArrayList< Ticket  > initializePicks ( int numTickets ) { 
	int i = 0;
	while ( i < numTickets ) {
	    for ( j = 0; j < Drawing.NUM_BALLS; i++ ) {
	    }
	}
    }
}
