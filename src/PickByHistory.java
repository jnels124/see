import java.util.Random;
import java.util.HashSet<E>;

public class PickByHistory implements Strategy {
    private final List< Drawing > history;
    private List< Ticket > pick;
    private numberQueue myQ;
    private Random numGen;
    
    public PickByHistory ( final List < Drawing >  history ) {
		this.history = history;
		this.picks = //initializePicks ( numTickets );
		this.numPlays = n;
		this.myQ = new numberQueue( ); 
    }
    
    static class numberQueue {
    	private List< Integer > theQ;
    	
    	public numberQueue ( ) {
    		numGen = new Random ( Drawing.MAX_BALL );		
    		this.theQ = new ArrayList < Integer > ( );  
    		for ( int i = 1; i <= 42; i++ ) {
    			this.theQ.add( i );
    		}
    			
    	}
    	
    	public void enqueue ( int item ) {
    		if ( this.theQ.contains ( item ) {
    			return; 
    		}
    		
    		else {
    			this.theQ.add ( item );
    		}
 
    	public int dequeue ( ) {
    		/*if ( this.ready.isEmpty( ) ) {
    			this.ready = this.waiting;
    			this.waiting = new ArrayList( );
    		}*/
    		
    		return this.theQ.remove ( 0 ); 
    	}	
    }
    
    public List< Ticket > play ( final List< Drawing > history ) {
    	Random numGen = new Random ( Drawing.LOW_BALL );
		for ( int i = 0; i < 6; i++ ) {
    			ArrayList< Integer > nums = new ArrayList< Integer > ( Drawing.NUM_BALLS );
    			nums.add ( this.theQ.remove ( numGen.nextInt( ) );
    	}
		return new Ticket ( new Date( ), nums, 0 ); 		
	}

    public List< Hit > analyze ( List< Ticket > tickets, final List< Drawing > history ) {
    	List< Hit > hits = new LinkedList< Hit > ( );
    	//for ( Ticket currTicket : tickets ) {
    		for ( Drawing currDrawing : history ) {
    			List< Integer > winners = new LinkedList < Integer >( );
    			oneTicket.listIntersection ( currTicket.getWinningNumbers ( ), currDrawing.getWinningNumbers, winners ); 
    			hits.add ( new Hit( currDrawing.getDate( ), winners, drawing.getJackpot( ) ) );  
    			compareTicketToWinner ( currTicket, currDrawing )   			
    		}
    	//} 
    	return hits;
    }

    public void printResults ( List< Hit > hits ) {
        for ( Hit hit : hits ) {
            System.out.printf( "%s,%d\n", hit.getDrawingDate(), 
             hit.getWinningNumbers().size() );
        }
    }
    
    private void compareTicketToWinner ( Ticket ticket, final Drawing drawing ) {
    	for ( int i = 0; i < 6; i++ ) {
    		this.theQ.enqueue ( ticket.getWinningNumbers( ).get( i ) ); //enqueue recently hit numbers
    		if ( !drawing.getWinningNumbers.contains ( ticket.getWinningNumbers.get( i ) ) {
    			//replaceNumber( i, ticket )
    			ticket.getWinngingNumbers.set ( i, this.theQ.dequeue );  // Replace hit number
    		}
    	}
    }
}
