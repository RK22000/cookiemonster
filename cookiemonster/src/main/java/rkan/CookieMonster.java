package rkan;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

/**
 * Class that performs all the analysis.
 */
public class CookieMonster {

    /**
     * Gets a list of the most active cookies logged in a file on a particular date.
     * @param file The log file containing all the cookies
     * @param date The date to on which to find the most active cookie
     * @return An ArrayList of the most active cookies on the given date
     * @throws FileNotFoundException
     */
    public static ArrayList<Cookie> mostActiveCookie(File file, LocalDate date) throws FileNotFoundException {
        CookieScanner cookieJar = new CookieScanner(file);
        Cookie cookie;
        Map<String, Cookie> map = new HashMap<>();
        // Go through the file and get the cookies of interest
        while (cookieJar.hasNextLine()) {
            cookie = cookieJar.nextCookie();
            LocalDate cookieDate = cookie.getTimeStamps().first().toLocalDate();

            // Skip or end if wrong section of the file is being read
            if (cookieDate.isBefore(date)) break;
            else if (cookieDate.isAfter(date)) continue;

            // Record all the cookies of interest and their time stamps
            if (map.containsKey(cookie.getCOOKIE())) {
                map.get(cookie.getCOOKIE())
                        .getTimeStamps()
                        .addAll(cookie.getTimeStamps());
            } else  {
                map.put(cookie.getCOOKIE(), cookie);
            }
        }


        PriorityQueue<Cookie> maxHeap = new PriorityQueue<>( (c0, c1) -> c1.getActivity() - c0.getActivity() );

        maxHeap.addAll(map.values());
        int maxActivity = 0;
        ArrayList<Cookie> mostActive = new ArrayList<>();
        Cookie sweetCookie;
        while ((sweetCookie = maxHeap.poll()) != null){
            //System.out.println("sus")
            if (sweetCookie.getActivity() >= maxActivity) {
                maxActivity = sweetCookie.getActivity();
                mostActive.add(sweetCookie);
            }
        }

        cookieJar.close();

        return mostActive;
    }
}
