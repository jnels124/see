import java.util.Date;
import java.util.List;

public class Drawing {
    /** The drawing date. */
    Date date;

    /** The numbers selected in the drawing. */
    List< Integer > numbers;

    /** The JackPot for this drawing. */
    double jackpot;

    /** This counstructor sets all instance variables 
     * 
     *  @param drawingDate The date of the drawing
     *  @param winningNumbers The winning numbers for the drawing
     *  @param jackpot The jackpot for this drawing
     */
    public Drawing ( final Date drawingDate, final List<Integer> winningNumbers, final double jackpot ) {
	this.drawingDate = drawingDate;
	this.winningNumbers = winningNumbers; //parseNumbers ( numbers );
	this.jackpot = jackpot;
    } 
    
    /** Get date of drawing
     * 
     *  @return drawingDate The date of drawing
     */
    public Date getDrawingDate ( ) {
	return this.drawingDate;
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
