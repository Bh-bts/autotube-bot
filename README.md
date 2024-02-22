# YouTube Automation
This Repository contains the Automation testcases for YouTube.

---
## Run YouTube Test using GitHub Actions

### Test Execution

To execute YouTube tests using GitHub Actions, follow these steps:

1. Go to the "Actions" tab of your Lufthansa repository.
2. Click on "Workflow" from the side menu.
3. Click on Run workflow dropdown button.
3. Select the branch you want to execute (e.g., "master").
4. Click on the "Run workflow" button.


## Run YouTube Test Locally

### Installation

1. Install java 8 jdk : I use java 11: https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html ( need free account )
2. Download Maven : https://maven.apache.org/install.html
3. clone autotube-bot repository
4. Run this command in project folder :

`mvn clean compile`

### Running Test

This command run the test in parallel mode

`mvn test -Dtest="testcases.**`

### Test Report

After the tests, you can generate a report using

`mvn surefire-report:report-only`

then

`mvn site -DgenerateReports=false`

After, go to `target/site/surefire-report.html` and you can see the report.