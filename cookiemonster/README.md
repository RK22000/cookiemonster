### Main directory structure

src

|-main

|  |-java/rakn

|  |  |-Cookie.java

|  |  |-CookieLogFormatException.java

|  |  |-CookieMonster.java

|  |  |-CookieScanner.java

|  |  \-CookiemonsterCommand.java

|  \resources (empty for now)

\-test/java/rkan

|-CookieMonsterTest.java

|-CookieScannerTest.java

|-CookieTest.java

\-CookiemonsterCommandTest.java

cookie_log_1.csv  (file used in testing)

# Build instructions
To build the project run 

  .\gradlew --no-daemon assemble
 
 in the terminal in this directory. This will build the project in build/libs directory. The jar named like \*-all.jar will be a jar file that can be run with java -jar command.
