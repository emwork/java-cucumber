# Behavior-Driven Development (BDD) example, using Cucumber and Java
BDD is very useful in development, especially when you don't have clear requirements and documentation.
Cucumber test reports will be able to flush out any business process misunderstandings, improve collaboration, QA team will be able to collaborate on the test plan and corner cases.

Additionally, using BDD will save days of manual testing (and thousands of dollars for the project) - due to the fact that it's automated from the very beginning. 

Then - the feature files are the living examples of business scenarios and can serve as documentation for the future users and developers.

Code quality improves by a lot - since a developer is forced to write the code in a decoupled, testable manner. This in turn leads to a better design.
And with that comes one more benefit - ability to refactor, without the fear that something gets broken in the process.
The solution can be delivered continuously and incrementally - with business participation and being able to correct the course even before the app is actually running for the first time.

----

### Building and running:
mvn clean test


----
Screenshots are below
----
<span style="color:IndianRed; font-size: 150%; font-weight: bold;"> Report sample when all tests pass:</span>

![Alt text](report-samples/tests-pass.png?raw=true "Report sample when all tests pass")

<span style="color:IndianRed; font-size: 150%; font-weight: bold;"> Report sample when a user filters for a specific scenario:</span>

![Alt text](report-samples/report-filtering.png?raw=true "Report sample when a user filters for a specific scenario")

<span style="color:IndianRed; font-size: 150%; font-weight: bold;"> Report sample when some tests pass, and one fails:</span>

![Alt text](report-samples/failed-tests.png?raw=true "Report sample when some tests pass, and one fails")
