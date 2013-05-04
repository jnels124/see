// This class will hold the data for a lotto drawing;
public class LottoGame {
    private final Date drawingDate;
    private final List <Integer> winningNumbers;
    private final double jackpot; // This may or may not be used depending on what data we decide to analyze

    public LottoGame ( final Date drawingDate, final String numbers, final jackpot ) {
	this.drawingDate = drawingDate;
	this.winningNumbers = parseNumbers ( numbers );
	this.jackpot = jackpot;
    } 

    private ArrayList<Integer> parseNumbers ( final String numbers ) {
	ArrayList<Integer> nums = new ArrayList ( );
	StringTokenizer st = new StringTokenizer ( numbers );
	
	for ( int i = 0; i < 5; i++ ) { // There will only be 6 tokens
	    nums.add ( Integer.parseInteger ( st.nextToken ( ) );
	}
	return nums;
    }

    public Date getDrawingDate ( ) {
	return this.drawingDate;
    }

    public List<Integer> getWinningNumbers ( ) {
	return this.winningNumbers;
    }

    public double getJackpot ( ) { 
	return this.jackpot;
    }
}
