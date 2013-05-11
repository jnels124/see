import java.util.Date;
import java.util.List;
/**
 * Holds the count of winners from a drawing date.
 *
 * @author Josh Gillham
 * @version 5-4-13
 */
public class Hit extends Ticket {
    /** The hit count. */
    int hits = 0;
    public Hit( final Date drawingDate, final List<Integer> winningNumbers, final double jackpot ) {
        super( drawingDate, winningNumbers, jackpot );
    }
}
