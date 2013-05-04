public class oneTicket implements Strategies {
    //int numPlays;
    
    public oneTicket ( final int numPlays, final List <LottoGame> history ) {
	//this.numPlays = numPlays;
	printResults ( analyze ( play ( numPlays, history ) ) ); // Method headers will be adjusted later
    }

    public static void play ( final int numPlays, final List <LottoGame> history ) {
	for ( int i = 0; i <= numPlays; i++ ) {
	    

	}
    }

    public static void analyze ( ) {

    }

    public static void printResults ( ) {

    }

    public static void graphData ( ) { // If we find an easy way to generate graphs

    }

}
