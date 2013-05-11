import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;
public class oneTicket implements Strategy {
    final List< Integer > picks;
    final List <Drawing> history;
    
    public oneTicket ( final List< Integer > picks, final List <Drawing> history ) {
	this.picks = picks;
	this.history = history;
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
             drawing.getWinningNumbers(), winners );
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
}
