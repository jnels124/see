import java.util.*;
public class PickyPlayer implements Strategy {
	final List< Integer > picks;
    final List <Drawing> history;
    private final int highBall, lowBall;
    
    public PickyPlayer ( final List< Integer > picks, final List <Drawing> history, final int highBall, final int lowBall ) {
		this.picks = picks;
		this.history = history;
		this.highBall = highBall;
		this.lowBall = lowBall;
        // Method headers will be adjusted later
    }
    
    public List< Ticket > play ( final List< Drawing > history ) {
        return java.util.Arrays.asList( new Ticket( new Date(), picks, 0 ) );
    }
    
    public List< Hit > analyze ( final List< Ticket > tickets,
     final List< Drawing > history ) {
        Ticket ticket = tickets.get( 0 );
        List< Hit > hits = new LinkedList< Hit >();
        for ( Drawing drawing : history ) {
            List< Integer > winners = new LinkedList< Integer >();
            listIntersection( ticket.getWinningNumbers(), 
            drawing.getWinningNumbers( ), winners );
            hits.add( new Hit( drawing.getDrawingDate(), winners, drawing.getJackpot() ) );
        }
        return hits;
    }
    
    static public < T > List< T > listIntersection( List< T > l1, 
     List< T > l2, List< T > out ) {
        for ( T item : l1 ) {
            if ( l2.contains( item ) ) {
                out.add( item );
            }
        }
        return out;
    }
    /**
     * Prints a collections with the specified braces and spaces the output
     *  so that it looks pretty.
     *
     * @param c is the collection to print.
     * @param message is the message to display before the collection.
     * @param start is the beginning brace.
     * @param close is the closing brace.
     */
    /*
    static public <V> void printCollectionPretty( Collection<V> c,
     String message, char start, char close ) {
        int i = 0;
        for ( V item : c ) {
            System.out.printf( "%s", item );
            if ( i < c.size() - 1 ) {
                System.out.printf( ", ", item );
            }
            ++i;
        }
    }
    */
    public void printResults ( List< Hit > hits ) {
        for ( Hit hit : hits ) {
            System.out.printf( "%s,%d\n", hit.getDrawingDate(), 
             hit.getWinningNumbers().size() );
        }
    }
    
    public Strategy reset ( ) {
    	return new PickyPlayer ( Ticket.initializePicks( 1, this.lowBall, this.highBall), this.history, this.lowBall, this.highBall );
    }
    
	/*public void runExperiment ( List<Drawing> lottoHistory, String outputPrefix ) {
        System.out.println( "Test3a" );
        PrintStream standardOut = System.out;
        //final int TRIALS = 20;
        //final int MIN_NUM = 22;
        //final int MAX_NUM = 42;
        //final int MIN_PICKS = 6;
        for ( int i = 0; i < TRIALS; ++i ) {
            /*List< Integer > universe = range( MIN_NUM, MAX_NUM, 
             new ArrayList<Integer>( MAX_NUM - MIN_NUM + 1 ) );

            List< Integer > picks = new ArrayList< Integer >( MAX_NUM - MIN_NUM + 1 );
            while ( picks.size() < MIN_PICKS ) {
                Integer select = universe.get( 
                 (int)( Math.random() * picks.size() ) );
                universe.remove( select );
                picks.add( select );
            } 
            //PickByHistory current = new PickByHistory( Ticket.initializePicks( 1, this.lowBall, this.highBall ), lottoHistory );
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
}
