public class ManiacPlayer implements Strategy {
	private int numPlays; 
	private List < Drawing > history;

    public ManiacPlayer ( final int numPlays, final List < Drawing > history ) {
		this.numPlays = numPlays;
		this.history = history;
		//this.picks = Drawing.initializePicks ( numPlays )
    }

    public static void play ( final int numPlays, final List < Drawing > history ) {
		//this.picks = Ticket.initializePicks ( );
		/*for ( int i = 0; i < this.picks; i++ ) {
		}*/
		return Drawing.initializePicks ( numPlays );
		
	}

    public List< Hit > analyze ( final List< Ticket > tickets, final List< Drawing > history ) {
    	List< Hit > hits = new LinkedList< Hit > ( );
    	for ( Ticket currTicket : tickets ) {
    		for ( Drawing currDrawing : history ) {
    			List< Integer > winners = new LinkedList < Integer >( );
    			oneTicket.listIntersection ( currTicket.getWinningNumbers ( ), currDrawing.getWinningNumbers, winners ); 
    			hits.add ( new Hit( currDrawing.getDate( ), winners, drawing.getJackpot( ) ) );
    		
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
}
