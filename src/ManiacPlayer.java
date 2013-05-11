import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;
public class ManiacPlayer implements Strategy {
	private int numPlays; 
	private List < Drawing > history;

    public ManiacPlayer ( final int numPlays, final List < Drawing > history ) {
		this.numPlays = numPlays;
		this.history = history;
		//this.picks = Drawing.initializePicks ( numPlays )
    }

    public List< Ticket > play ( final List< Drawing > history ) {
    	List < Ticket > tickets = new ArrayList < Ticket > ( );
		//this.picks = Ticket.initializePicks ( );
		/*for ( int i = 0; i < this.picks; i++ ) {
		}*/
		for ( int i = 0; i < this.numPlays; i++ ) {
			tickets.add( new Ticket ( new Date( ), Ticket.initializePicks ( 1, Drawing.MIN_BALL, Drawing.MAX_BALL ), 0 ) );
		}
		return tickets;
		
	}

    public List< Hit > analyze ( final List< Ticket > tickets, final List< Drawing > history ) {
    	List< Hit > hits = new LinkedList< Hit > ( );
    	for ( Ticket currTicket : tickets ) {
    		for ( Drawing currDrawing : history ) {
    			List< Integer > winners = new LinkedList < Integer >( );
    			oneTicket.listIntersection ( currTicket.getWinningNumbers ( ), currDrawing.getWinningNumbers( ), winners ); 
    			hits.add ( new Hit( currDrawing.getDrawingDate( ), winners, currDrawing.getJackpot( ) ) );
    		}
    	}
    	
    	return hits;
    }

    public void printResults ( List< Hit > hits ) {
        for ( Hit hit : hits ) {
            System.out.printf( "%s,%d\n", hit.getDrawingDate(), 
             hit.getWinningNumbers().size() );
        }
    }
    
    public Strategy reset ( ) {
    	return new ManiacPlayer( this.numPlays, this.history );
    } 
}
