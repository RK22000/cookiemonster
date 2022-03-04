package rkan;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

    @Test
    void getCOOKIE() {
        Cookie cookie = new Cookie("AtY0laUfhglK3lC7", "2018-12-09T14:19:00+00:00");
        assertEquals("Cookie{COOKIE='AtY0laUfhglK3lC7', timeStamps=[2018-12-09T14:19Z]}",
                cookie.toString());
    }

    @Test
    void testTimeStamps() {
        Cookie cookie = new Cookie("AtY0laUfhglK3lC7", "2018-12-09T14:19:00+00:00");
        cookie.getTimeStamps().add(OffsetDateTime.parse("2018-12-09T06:19:00+00:00"));

        assertEquals("[2018-12-09T06:19Z, 2018-12-09T14:19Z]",
                cookie.getTimeStamps().toString());

        cookie.parseAddTimeStamp("2018-12-08T09:30Z");

        assertEquals("[2018-12-08T09:30Z, 2018-12-09T06:19Z, 2018-12-09T14:19Z]",
                cookie.getTimeStamps().toString());
    }

    @Test
    void getActivity() {
        Cookie cookie = new Cookie("AtY0laUfhglK3lC7", "2018-12-09T14:19:00+00:00");
        cookie.getTimeStamps().add(OffsetDateTime.parse("2018-12-09T06:19:00+00:00"));

        assertEquals(2,
                cookie.getActivity());

        cookie.parseAddTimeStamp("2018-12-08T09:30Z");

        assertEquals(3,
                cookie.getActivity());
    }
}