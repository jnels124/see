public class Date { // 
    private int month,
	        day,
	        year;
    //String dayOfWeek;   --> May later decide to compare day of week
    
    public Date ( String date ) { 
	// parse out date
    }

    public int getMonth ( ) {
	return this.month;
    }

    public int getDay ( ) {
	return this.day;
    }
    
    public int getYear ( ) {
	return this.year;
    }

    //@overide
    public int hashCode ( Object value ) {
	return 0;
    }
    
    //@overide 
    public String toString ( Object date ) {
	return "";
    }
}
