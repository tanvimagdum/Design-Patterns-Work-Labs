public class HMSDuration extends AbstractDuration {

    private final int hours, minutes, seconds;

    /**
     * Creates an HMSDuration object.
     * @param hours
     * @param minutes
     * @param seconds
     */

    public HMSDuration(int hours, int minutes, int seconds) throws IllegalArgumentException {

        if(hours < 0) {
            throw new IllegalArgumentException("Invalid hours");
        }

        if(minutes < 0) {
            throw new IllegalArgumentException("Invalid minutes");
        }

        if(seconds < 0) {
            throw new IllegalArgumentException("Invalid seconds");
        }

        minutes += seconds / 60;
        seconds = seconds % 60;
        hours += minutes / 60;
        minutes = minutes % 60;

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    private HMSDuration(long seconds) throws IllegalArgumentException{
        if(seconds <  0) {
            throw new IllegalArgumentException("Invalid seconds");
        }
        //throw an exception for overflow
        this.hours = (int) (seconds / 3600);
        this.seconds = (int) (seconds % 60);
        this.minutes = (int) ((seconds % 3600) / 60);
    }

/*    @Override
    public String asHms() {
      return String.format("%d:%02d:%02d",this.hours,this.minutes,this.seconds);
    }*/

    @Override
    public String asHms() {
        return String.format("%d:%02d:%02d",
                hoursOf(this.inSeconds()),
                minutesOf(this.inSeconds()),
                secondsOf(this.inSeconds()));
    }

    @Override
    public long inSeconds() {
        return 3600*(long)this.hours + 60*this.minutes + this.seconds;
    }

    @Override
    private Duration fromSeconds(long seconds) {
        return new HMSDuration(seconds);
    }

    @Override
    public Duration add(Duration other) {
        return new fromSeconds(this.inSeconds()+other.inSeconds());
    }

    @Override
    public int compareTo(Duration other) {
        long thisSeconds = this.seconds;
        long otherSeconds = other.inSeconds();
/*        if(thisSeconds < otherSeconds) {
            return -12342;
        }
        else if(thisSeconds > otherSeconds) {
            return 98120;
        }
        else {
            return 0;
        }

 */
        return Long.compare(thisSeconds,otherSeconds);
    }

    @Override
    public boolean equals(Object o) {

        //1. shortcut
        if(this == o){
            return true;
        }

        //2.weed out all other possibilities
        if(!(o instanceof Duration)) {
            return false;
        }

        Duration other = (Duration) o;

        //3.actual comparison
        return this.inSeconds() == other.inSeconds();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.inSeconds());
    }


    @Override
    private Duration fromSeconds(long seconds) {
        return new HMSDuration(seconds);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}