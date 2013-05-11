import java.util.Random;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;
import java.util.NoSuchElementException;

public class PickByHistory implements Strategy {
    private final List< Drawing > history;
    private List< Integer > picks;
    private numberQueue myQ;
    
    
    public PickByHistory ( List< Integer > picks, final List < Drawing >  history ) {
		this.history = history;
		this.picks = picks;//initializePicks ( numTickets );
		//this.numPlays = n;
		this.myQ = new numberQueue( ); 
    }
    
    /** Cheap implementation of a queue to hold order*/ 
    static class numberQueue {
    	private List< Integer > theQ;
    	private Random numGen;
    	
    	public numberQueue ( ) {
    		numGen = new Random ( Drawing.MAX_BALL );		
    		this.theQ = new ArrayList < Integer > ( );  
    		for ( int i = 1; i <= 42; i++ ) {
    			this.theQ.add( i );
    		}		
    	}
    	
    	public void enqueue ( int item ) {
    		if ( this.theQ.contains ( item ) ) { // Remove number from current index and add to end of list
    			this.theQ.remove ( item ); 
    		}
    		
    		//else {
    			this.theQ.add ( item );
    	}
 
    	public int dequeue ( ) {
    		if ( this.theQ.isEmpty( ) ) {
    			throw new NoSuchElementException ( "Tried to dequeue from an empty queue!" );
    		}
    		
    		return this.theQ.remove ( 0 ); 
    	}	
    }
    
    public List< Ticket > play ( final List< Drawing > history ) {
    	Random numGen = new Random ( Drawing.MIN_BALL );
    	ArrayList< Integer > nums = new ArrayList< Integer > ( Drawing.NUM_BALLS );
		for ( int i = 0; i < 6; i++ ) {
    			nums.add ( this.myQ.dequeue( ) );//remove ( numGen.nextInt( ) ) );
    	}
		return java.util.Arrays.asList( new Ticket ( new Date( ), nums, 0 ) ); 		
	}

    public List< Hit > analyze ( List< Ticket > tickets, final List< Drawing > history ) {
    	List< Hit > hits = new LinkedList< Hit > ( );
    	for ( Ticket currTicket : tickets ) {
    		for ( Drawing currDrawing : history ) {
    			List< Integer > winners = new LinkedList < Integer >( );
    			oneTicket.listIntersection ( currTicket.getWinningNumbers ( ), currDrawing.getWinningNumbers( ), winners ); 
    			hits.add ( new Hit( currDrawing.getDrawingDate( ), winners, currDrawing.getJackpot( ) ) );  
    			compareTicketToWinner ( currTicket, currDrawing );   			
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
    
    public Strategy reset( ) {
    	return new PickByHistory( Ticket.initializePicks( 1, Drawing.MIN_BALL, Drawing.MAX_BALL ), this.history );
    }
    
    /*public void runExperiment ( List<Drawing> lottoHistory, String outputPrefix ) {
        System.out.println( "Test3a" );
        PrintStream standardOut = System.out;
     
        for ( int i = 0; i < TRIALS; ++i ) {
            PickByHistory current = new PickByHistory( Ticket.initializePicks( 1, Drawing.MIN_BALL, Drawing.MAX_BALL ), lottoHistory );
            List< Hit > hits = current.analyze( current.play( lottoHistory ), lottoHistory );
            ByteArrayOutputStream outputCollector = new ByteArrayOutputStream();
            System.setOut( new PrintStream( outputCollector ) );
            current.printResults( hits );
            System.setOut( standardOut );
            try {
                FileWriter outputFile = new FileWriter( 
                 String.format( "%s-history-%03d.csv", outputPrefix, i ) );
                outputFile.write( outputCollector.toString() );
            }
            catch ( java.io.IOException e ) {
                e.printStackTrace();
            }
        }
    }*/
    
    private void compareTicketToWinner ( Ticket ticket, final Drawing drawing ) {
    	for ( int i = 0; i < 6; i++ ) {
    		this.myQ.enqueue ( ticket.getWinningNumbers( ).get( i ) ); //enqueue recently hit numbers
    		if ( drawing.getWinningNumbers( ).contains ( ticket.getWinningNumbers( ).get( i ) ) ) {
    			ticket.getWinningNumbers( ).set ( i, this.myQ.dequeue( ) );  // Replace hit number
    		}
    	}
    }
}
