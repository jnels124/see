import java.util.Date;
import java.util.List;

/** This class will hold the data from a lottery drawing
 *
 *  @author Jesse Nelson
 *  @author Josh Gillham
 *  @version May 04, 2013 : OS:3.8.10-1-ARCH : JavaVersion:ArchLinux build 7.u21_2.3.9-1-x86_64 
 */
public class Drawing {
    /** The drawing date. */
    private Date date;

    /** The numbers selected in the drawing. */
    private List< Integer > winningNumbers;

    /** The JackPot for this drawing. */
    private double jackpot;

    /** This counstructor sets all instance variables 
     * 
     *  @param drawingDate The date of the drawing
     *  @param winningNumbers The winning numbers for the drawing
     *  @param jackpot The jackpot for this drawing
     */
    public Drawing ( final Date drawingDate, final List<Integer> winningNumbers, final double jackpot ) {
	this.date = drawingDate;
	this.winningNumbers = winningNumbers; //parseNumbers ( numbers );
	this.jackpot = jackpot;
    } 
    
    /** Get date of drawing
     * 
     *  @return drawingDate The date of drawing
     */
    public Date getDrawingDate ( ) {
	return this.date;
    }
    
    /** This method gets the winning numbers for a game
     * 
     *  @return winngingNumbers
     */
    public List<Integer> getWinningNumbers ( ) {
	return this.winningNumbers;
    }

    /** This method gets the jackpot for a game
     * 
     *  @return jackpot
     */
    public double getJackpot ( ) { 
	return this.jackpot;
    }
}
