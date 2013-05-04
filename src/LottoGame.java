import java.util.*;
/* This class will hold the data for a lotto drawing;
   @author Jesse Nelson
   @author Josh Gillham
   @version May 04, 2013 : OS:3.8.10-1-ARCH : JavaVersion:ArchLinux build 7.u21_2.3.9-1-x86_64 
 */

public class LottoGame {
    private final Date drawingDate;
    private final List <Integer> winningNumbers;
    private final double jackpot; // This may or may not be used depending on what data we decide to analyze

    public LottoGame ( final Date drawingDate, final List<Integer> winningNumbers, final double jackpot ) {
	this.drawingDate = drawingDate;
	this.winningNumbers = winningNumbers; //parseNumbers ( numbers );
	this.jackpot = jackpot;
    } 

    /*  private ArrayList<Integer> parseNumbers ( final String numbers ) {
	ArrayList<Integer> nums = new ArrayList ( );
	StringTokenizer st = new StringTokenizer ( numbers );
	
	for ( int i = 0; i < 5; i++ ) { // There will only be 6 tokens
	    nums.add ( Integer.parseInteger ( st.nextToken ( ) );
	}
	return nums;
	}*/

    /* This method gets the drawing date for a game
     * 
     * @return drawingDate
     */
    public Date getDrawingDate ( ) {
	return this.drawingDate;
    }
    
    /* This method gets the winning numbers for a game
     * 
     * @return winngingNumbers
     */
    public List<Integer> getWinningNumbers ( ) {
	return this.winningNumbers;
    }

    /* This method gets the jackpot for a game
     * 
     * @return jackpot
     */
    public double getJackpot ( ) { 
	return this.jackpot;
    }
}
