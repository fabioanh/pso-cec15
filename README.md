# pso-cec15
Particle Swarm Optimization implementation to give solution to the CEC 2015 competition problems.

## Execution

### From the final JAR file

### From the Source Code
The project is a Maven project, hence the execution can be done on the command line using maven common commands. The execution plugin has been set up already in order to point the App class as the container of the main to launch the application. The command to show all possible arguments is shown below:
```
mvn exec:java -Dexec.args="-h"
```
With this in mind, all possible parameters can be set in the _exec.args_ section of the command. For instance `mvn exec:java -Dexec.args="-s 123"` will run the program setting _123_ as seed for the random number generation in the solution. 
