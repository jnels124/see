import java.util.*;
import java.io.*;

/* This class will drive the lotto analyzation program. It will simulate 
 *   several strategies for playing the lottery.
 *
 * @author Jesse Nelson
 * @author Josh Gillham
 * @version May 04, 2013 : OS:3.8.10-1-ARCH : JavaVersion:ArchLinux build 7.u21_2.3.9-1-x86_64 
 */
public class Plays {
    private static List<LottoGame> lottoHistory;
    private static List<Strategy> playedStrategies; // Add your strategies to this list
    public static void main( String[] args ) {
	lottoHistory = storeLottoHistory ( args [0] );
        System.out.print( args[0] );
    }

    /* Read lottery data from file specified on command line
     * @param fileName Name of file holding lottery data
     * @return games A list of lottoGame objects created from lottery history 
     */
    private static List<LottoGame> storeLottoHistory ( String fileName ) {
	ArrayList<LottoGame> games = new ArrayList<LottoGame> ( );
	ArrayList<Integer> gameNumbers;
	StringTokenizer st;
	String line;

	try { // This is hardcoded for our CO data set but it can easily be fixed 
	    Scanner infile = new Scanner ( new FileReader ( fileName ) );
	    while ( infile.hasNextLine ( ) ) {
		gameNumbers = new ArrayList<Integer> ( );
		line = infile.nextLine ( );
		st = new StringTokenizer ( line, ',' );   // We can pass delimeter from regex string if needed
		st.nextToken ( ); // Get rid of state token ( CO data set )
		//while ( st.hasMoreTokens ( ) ) { // Incase we have data formatted differently
		    Date drawingDate = new Date ( st.nextToken ( ) );
		    for ( int i = 0; i < 5; i++ ) {
			gameNumbers.add ( Integer.parseInt ( st.nextToken ( ) ) ); 
		    }
		    games.add ( new LottoGame ( drawingDate, gameNumbers, 0.0 ) ); 
		    //}
	    }
	}
	catch ( FileNotFoundException e ) {
	    System.out.println ( e );
	}

	/*catch ( IOException e ) {
	    System.out.println ( e );
	    }*/
	
	catch ( NumberFormatException e ) {
	    System.out.println ( e );
	}
	
	return games;
    }
    
    
}
