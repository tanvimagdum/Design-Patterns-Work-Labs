public abstract class AbstractDuration implements Duration {

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

    protected int hoursOf(int seconds) {
      return (int) (seconds / 3600);
    }

    protected int minutesOf(int seconds) {
      return (int) ((seconds % 3600) / 60);
    }

    protected int secondsOf(int seconds) {
      return (int) (seconds % 60);
    }

    @Override
    public Duration add(Duration other) {
      return fromSeconds(this.inSeconds()+other.inSeconds());
    }
    protected abstract Duration fromSeconds(long seconds);

}

class DurationCreator {
  public static Duration createDuration(long seconds, String type) {
    switch (type) {
      case "HMS":
        return new HMSDuration();
      case "Compact":
        return new CompactDuration();
    }
    }
}
