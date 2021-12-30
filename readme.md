For this project the following tech stack has been used:
- Java 11
- Maven 3.6.3

In order to run the project follow the below instructions:
1. mvn clean install
2. mvn exec:java -Dexec.mainClass=com.xm.chess.ChessApplication -Dexec.args="{starting position} {ending position}"

For example if we want the path for the starting position E4 and ending position A3 the command should be the following:
- mvn exec:java -Dexec.mainClass=com.xm.chess.ChessApplication -Dexec.args="E4 A3"

For running only the junit tests: 
- mvn test