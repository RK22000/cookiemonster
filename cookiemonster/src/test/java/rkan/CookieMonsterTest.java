package rkan;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CookieMonsterTest {

    File logFile = new File("cookie_log_1.csv");

    @Test
    void mostActiveCookie() throws FileNotFoundException {
        assertTrue(logFile.exists());
        LocalDate date = LocalDate.parse("2018-12-09");
        ArrayList<Cookie> mostActive = CookieMonster.mostActiveCookie(logFile, date);
        assertEquals("AtY0laUfhglK3lC7", mostActive.get(0).getCOOKIE());
    }

    @Test
    void mosActiveCookies() throws FileNotFoundException {
        assertTrue(logFile.exists());
        LocalDate date = LocalDate.parse("2018-12-08");
        ArrayList<Cookie> mostActive = CookieMonster.mostActiveCookie(logFile, date);
        assertEquals(3, mostActive.size());
        String cookies = mostActive.stream().map(c -> c.getCOOKIE()+'\n').sorted().collect(Collectors.joining());
        assertEquals("4sMM2LxV07bPJzwf\nSAZuXPGUrfbcn5UA\nfbcn5UAVanZf6UtG\n",
                cookies);
    }
}