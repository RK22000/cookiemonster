package rkan;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import io.micronaut.context.annotation.Parameter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Command(name = "most_active_cookie", description = "Gets the most active cookie in a log file on a given day",
        mixinStandardHelpOptions = true)
public class CookiemonsterCommand implements Runnable {

    @Parameters(paramLabel = "FILE", description = "The file containing logs to read")
    File logFile;

    @Option(names = {"-d", "--date"}, description = "The date for the most active log")
    LocalDate date;


    public static void main(String[] args) throws Exception {
        PicocliRunner.run(CookiemonsterCommand.class, args);
    }

    public void run() {
        try {
            ArrayList<Cookie> cookies = CookieMonster.mostActiveCookie(logFile, date);
            String cookieString = cookies.stream().map(c -> c.getCOOKIE()+'\n').sorted().collect(Collectors.joining());
            System.out.println(cookieString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
