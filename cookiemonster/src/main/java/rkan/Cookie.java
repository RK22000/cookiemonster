package rkan;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.TreeSet;


public class Cookie {
    private final String COOKIE;
    private final TreeSet<OffsetDateTime> timeStamps;

    /**
     * Constructor to create a Cookie.
     * @param cookie The cookie string of this cookie
     * @param timeStamp The string time stamp formatted in UTC with time offset
     */
    public Cookie(String cookie, String timeStamp) throws DateTimeParseException {
        COOKIE = cookie;
        timeStamps = new TreeSet<>();
        timeStamps.add(OffsetDateTime.parse(timeStamp));
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "COOKIE='" + COOKIE + '\'' +
                ", timeStamps=" + timeStamps +
                '}';
    }

    /**
     * Getter for the cookie string
     * @return the cookie string
     */
    public String getCOOKIE() {
        return COOKIE;
    }

    public TreeSet<OffsetDateTime> getTimeStamps() {
        return timeStamps;
    }

    public int getActivity() {
        return timeStamps.size();
    }

    @Override
    public int hashCode() {
        return COOKIE.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        try {
            return ((Cookie) o).getCOOKIE().equals(COOKIE);
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Method to parse then add a string time stamp formatted in
     * @param timeStamp The string time stamp formatted in UTC with time offset
     * @return true if this cookie did not already have this time stamp
     */
    public Boolean parseAddTimeStamp(String timeStamp) {
        return timeStamps.add(OffsetDateTime.parse(timeStamp));
    }
}
