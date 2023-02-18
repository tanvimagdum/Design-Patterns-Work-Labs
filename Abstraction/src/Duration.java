public interface Duration {

    public String asHms();


    public long inSeconds();

    public Duration add(Duration other);

    public int compareTo(Duration other);
}
