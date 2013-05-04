public class Plays {
    private static List<LottoGame> lottoHistory;
    public static void main( String[] args ) {
	lottoHistory = storeLottoHistory ( args [0] );
        System.out.print( args[0] );
    }

    private static List<LottoGame> storeLottoHistory ( String fileName ) {
	ArrayList<LottoGame> games = new ArrayList<Integer> ( );
	ArrayList<Integer> gameNumbers;
	StringTokenizer st;
	String line;

	try { // This is hardcoded for our CO data set but it can easily be fixed 
	    Scanner infile = new Scanner ( new FileReader ( fileName ) );
	    while ( infile.hasNextLine ( ) ) {
		gameNumbers = new ArrayList<Integer> ( );
		line = infile.nextLine ( );
		st = new StringTokenizer ( line );   // We can pass an additonal argument as delimeter from regex string if needed
		st.nextToken ( ); // Get rid of state token ( CO data set )
		while ( st.hasMoreTokens ( ) ) { // Incase we have data formatted differently
		    Date drawingDate = new Date ( st.nextToken ( ) );
		    for ( int i = 0; i < 5; i++ ) {
			gameNumbers.add ( Integer.parseInteger ( st.nextToken ) ); 
		    }
		    games.add ( new LottoGame ( drawingDate, gameNumbers, null ) ); 
		}
	    }
	}
    }
}
