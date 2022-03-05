package rkan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CookieScannerTest {

    @Test
    void nextCookie() throws IOException {
        File cookieTestLogFile = new File("cookie_log_1.csv");
        assertTrue(cookieTestLogFile.exists());
        System.out.println(cookieTestLogFile.getAbsolutePath());

        CookieScanner scanner = new CookieScanner(cookieTestLogFile);
        Cookie firstCookie = scanner.nextCookie();
        scanner.close();

        assertEquals("Cookie{COOKIE='AtY0laUfhglK3lC7', timeStamps=[2018-12-09T14:19Z]}"
                , firstCookie.toString());

    }

    @Test
    void readAllCookies() throws FileNotFoundException {
        File cookieTestLogFile = new File("cookie_log_1.csv");
        assertTrue(cookieTestLogFile.exists());
        CookieScanner scanner = new CookieScanner(cookieTestLogFile);
        int cookies = 0;
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextCookie());
            cookies++;
        }
        assertEquals(8, cookies);
    }
}