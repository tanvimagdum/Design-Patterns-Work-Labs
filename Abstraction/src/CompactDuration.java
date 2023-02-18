/** This class represents a duration in time int terms of seconds.
 *
 */


public class CompactDuration extends AbstractDuration{


    @Override
    public String asHms() {
      return String.format("%d:%02d:%02d",
              hoursOf(this.seconds),
              minutesOf(this.seconds),
              secondsOf(this.seconds));
    }

    @Override
    public Duration add(Duration other) {
        return new CompactDuration(this.inSeconds()+other.inSeconds());
    }

    @Override
    private Duration fromSeconds(long seconds) {
        return new CompactDuration(seconds);
    }

    @Override
    public long inSeconds() {
        return 0;
    }


    @Override
    public int compareTo(Duration other) {
        return 0;
    }
}
