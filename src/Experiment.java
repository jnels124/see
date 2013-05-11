import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

/**
 * The experiment runner sets up and runs an experiment.
 *
 * @author Josh Gillham
 * @version 5-4-13
 */
public enum Experiment {
    NONE
    ,
    /** Can the same numbers eventually win? */
    STUBORN_PLAYER
    ,
    /** Can winning be guaranteed with a subset of tickets? */
    MANIAC_PLAYER
    ,
    /** Can we get a better winning probability with high numbers? */
    PICKY_HIGH_NUMBERS_PLAYER
    ,
    /** Can we get a better winning probability with low numbers? */
    PICKY_LOW_NUMBERS_PLAYER
    ;
    /** Set to true to enable debugging. */
    static public boolean DEBUG = false;
    public enum Argument {
        FILE_NAME
        ,
        ALGORITHM
        ,
        OUTPUT_PREFIX
        ;
    }
    static public final int MIN_ARGUMENTS = Argument.values().length;
    /** Potential error values. */
    public enum Error {
        /** No arguments were given to the program. */
        NO_ARGUMENTS
        ,
        /** The experiment is not defined. */
        NO_SUCH_EXPERIMENT
        ,
        NO_FILE
        ,
        /** The experiment has not been implimented. */
        UNIMPLEMENTED_EXPERIMENT
        ,
        UNIMPLEMENTED_ARGUMENT
        ,
        GENERIC_ERROR
        ,
        BAD_FILE_FORMAT
        ;
    }
    
    /**
     * Starts the experiment from the command line.
     *
     * @param args expects a number designating the experiment to run.
     */
    static public void main( String[] args ) {
        // DEBUG print all arguments.
        if ( DEBUG ) {
            for( int i = 0; i < args.length; ++i ) {
                System.out.printf( "Argument[%d]: %s\n", i, args[i] );
            }
        }
        // Check for minimum arguments.
        if ( args.length < MIN_ARGUMENTS ) {
            printUsage();
            System.exit( Error.NO_ARGUMENTS.ordinal() );
        }
        System.out.println( "Test1" );
        // Select an experiment using the arguments.
        Experiment choice = null;
        String file = null;
        String outputPrefix = null;
        try {
            for ( Argument arg : Argument.values() ) {
                System.out.println( "Test1a" );
                String argument = args[ arg.ordinal() ];
                switch ( arg ) {
                case FILE_NAME:
                    file = argument;
                    File temp = new File( file );
                    if ( !temp.exists() ) {
                        System.out.println( "File does not exist." );
                        printUsage();
                        System.exit( Error.NO_FILE.ordinal() );
                    }
                break;
                case ALGORITHM:
                    choice = Experiment.values()[ Integer.valueOf( argument ) ];
                    if ( choice == NONE ) {
                        System.out.println( "Bad experiment choice." );
                        printUsage();
                        System.exit( Error.NO_SUCH_EXPERIMENT.ordinal() );
                    }
                break;
                case OUTPUT_PREFIX:
                    outputPrefix = argument;
                break;
                default:
                    System.out.println( "Argument needs implementation." );
                    printUsage();
                    System.exit( Error.UNIMPLEMENTED_ARGUMENT.ordinal() );
                }
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
            System.out.println( "Bad experiment choice." );
            printUsage();
            System.exit( Error.GENERIC_ERROR.ordinal() );
        }
        System.out.println( "Test2" );
        // Try to parse the file in.
        List<Drawing> lottoHistory = null;
        try {
            System.out.println( "Test2a" );
            lottoHistory = Plays.storeLottoHistory ( file );
            System.out.println( "Test2a.i" );
        }
        catch ( java.io.FileNotFoundException e ) {
            System.out.println( "File does not exist." );
            e.printStackTrace();
            printUsage();
            System.exit( Error.NO_FILE.ordinal() );
        }
        catch ( Plays.BadFileFormatException e ) {
            e.printStackTrace();
            System.exit( Error.BAD_FILE_FORMAT.ordinal() );
        }
        System.out.println( "Test2b" );
        // Run the selected experiment.
        switch ( choice ) {
        case STUBORN_PLAYER:
            System.out.println( "Test3" );
            runStubornPlayer( lottoHistory, outputPrefix );
        break;
        case PICKY_HIGH_NUMBERS_PLAYER:
            runPickyPlayer_HighNumbers( lottoHistory, outputPrefix );
        break;
        case MANIAC_PLAYER:
        case PICKY_LOW_NUMBERS_PLAYER:
        default:
            System.out.println( "Experiment needs implementation." );
            printUsage();
            System.exit( Error.UNIMPLEMENTED_EXPERIMENT.ordinal() );
        }
    }
    
    /** Show the current commands for this program. */
    static public void printUsage() {
        System.out.println( "Usage: <experiment number>" );
        System.out.println( "experiment number -- chooses the experiment." );
    }
    
    /** Run the stuborn player experiment. */
    static public void runStubornPlayer( List<Drawing> lottoHistory, String outputPrefix ) {
        System.out.println( "Test3a" );
        PrintStream standardOut = System.out;
        final int TRIALS = 20;
        final int MIN_NUM = 1;
        final int MAX_NUM = 42;
        final int MIN_PICKS = 6;
        for ( int i = 0; i < TRIALS; ++i ) {
            List< Integer > universe = range( MIN_NUM, MAX_NUM, 
             new ArrayList<Integer>( MAX_NUM - MIN_NUM + 1 ) );

            List< Integer > picks = new ArrayList< Integer >( MAX_NUM - MIN_NUM + 1 );
            while ( picks.size() < MIN_PICKS ) {
                Integer select = universe.get( 
                 (int)( Math.random() * picks.size() ) );
                universe.remove( select );
                picks.add( select );
            }
            oneTicket current = new oneTicket( picks, lottoHistory );
            List< Hit > hits = current.analyze( current.play( lottoHistory ), lottoHistory );
            ByteArrayOutputStream outputCollector = new ByteArrayOutputStream();
            System.setOut( new PrintStream( outputCollector ) );
            current.printResults( hits );
            System.setOut( standardOut );
            try {
                FileWriter outputFile = new FileWriter( 
                 String.format( "%s-stubborn-%03d.csv", outputPrefix, i ) );
                outputFile.write( outputCollector.toString() );
            }
            catch ( java.io.IOException e ) {
                e.printStackTrace();
            }
        }
    }
    /** Run the stuborn player experiment. */
    static public void runPickyPlayer_HighNumbers( 
     List<Drawing> lottoHistory, String outputPrefix ) {
        System.out.println( "Test3a" );
        PrintStream standardOut = System.out;
        final int TRIALS = 20;
        final int MIN_NUM = 22;
        final int MAX_NUM = 42;
        final int MIN_PICKS = 6;
        for ( int i = 0; i < TRIALS; ++i ) {
            List< Integer > universe = range( MIN_NUM, MAX_NUM, 
             new ArrayList<Integer>( MAX_NUM - MIN_NUM + 1 ) );

            List< Integer > picks = new ArrayList< Integer >( MAX_NUM - MIN_NUM + 1 );
            while ( picks.size() < MIN_PICKS ) {
                Integer select = universe.get( 
                 (int)( Math.random() * picks.size() ) );
                universe.remove( select );
                picks.add( select );
            }
            oneTicket current = new oneTicket( picks, lottoHistory );
            List< Hit > hits = current.analyze( current.play( lottoHistory ), lottoHistory );
            ByteArrayOutputStream outputCollector = new ByteArrayOutputStream();
            System.setOut( new PrintStream( outputCollector ) );
            current.printResults( hits );
            System.setOut( standardOut );
            try {
                FileWriter outputFile = new FileWriter( 
                 String.format( "%s-pickyHigh-%03d.csv", outputPrefix, i ) );
                outputFile.write( outputCollector.toString() );
            }
            catch ( java.io.IOException e ) {
                e.printStackTrace();
            }
        }
    }
    static public List<Integer> range( int min, int max, List<Integer> list ) {
        for ( int i = min; i <= max; ++i ) {
            list.add( i );
        }
        return list;
    }
}
