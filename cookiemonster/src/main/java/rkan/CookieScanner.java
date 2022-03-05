package rkan;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.OffsetDateTime;
import java.util.Scanner;

public class CookieScanner {
    private final File cookieFile;
    private final Scanner scanner;


    /**
     * Creates an instance of CookieScanner that reads cookies from file.
     * Call close after scanner has been used.
     * @param cookieFile The file to read cookies from
     * @throws FileNotFoundException if cookieFile is not found
     */
    public CookieScanner(File cookieFile) throws FileNotFoundException {
        this.cookieFile = cookieFile;
        scanner = new Scanner(cookieFile);
        scanner.nextLine(); // Skip the first header line of the file
    }

    /**
     * Reads a line from the cookieFile and returns the cookie logged on that line
     * @return the cookie that was read
     */
    public Cookie nextCookie() {
        String line = scanner.nextLine();
        String[] logEntry = line.split(",");
        try {
            OffsetDateTime stamp = OffsetDateTime.parse(logEntry[1]);
            return new Cookie(logEntry[0], logEntry[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CookieLogFormatException(String.format("Expected format was 'cookiestring,UTCtimestampwithoffset', actual log was '%s'", line ));
        }
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public void close(){
        scanner.close();
    }
}
















