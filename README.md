# Web Automation Task by Rashmi Solanki (Employee ID : 3656)

**Overview**: Completed Scenario 1 and Scenario 2 in BDD Serenity Framework. This Framework have lot of improvement scope. 

Repository url - https://github.com/rashmi-qb/UKAutomationTestRashmi.git

**Note**: This code is currently executable on Windows machine (win 10 latest chrome browser)
 
**SYSTEM REQUIREMENT**:
 * JDK 1.8 or above : https://www.oracle.com/technetwork/java/javase/downloads/index.html
 * Eclipse : https://www.eclipse.org/downloads/
 * TestNg/JUnit : Eclipse(Market place)
 * Maven : https://maven.apache.org/download.cgi
 * Selenium WebDrives
 
**Steps To Execute Scenario 1 in Code**: 
* Navigate to src/test/java > com.test.rashmi.cucumber
* Right Click on TshirtpageRunner.java in order to execute Scenario 1
* Click on 'Run As' and then 'JUnit test'
* Checkout console for execution
* Navigate to target\site\reports and click on .html file to view execution report

**Steps To Execute Scenario 2 in Code**: 
* Navigate to src/test/java > com.test.rashmi.cucumber
* Right Click on UpdatedPersonalInfomationRunner.java in order to execute Scenario 2
* Click on 'Run As' and then 'JUnit test'
* Checkout console for execution
* Navigate to target\site\reports and click on .html file to view execution report

**Successfully Execution Report screenshot**:
* Scenario 1 - UKAutomationTestRashm\Scenario_1_ExecutionReportScreenShot.png
* Scenario 2 - UKAutomationTestRashm\Scenario_2_ExecutionReportScreenShot.png

**Basic info**:
* Feature files mentioned under src/test/resources> features> Tshirt.feature --- (Feature file of scenario 1)
* Feature files mentioned under src/test/resources> features> UpdatedPersonalInfo.feature --- (Feature file of scenario 1)
* Step definition in src/test/java > com.test.rashmi.cucumber.steps
* Serenity step definition in src/test/java > com.test.rashmi.cucumber.steps.serenity
* Page Action and web locators mentioned in classes under package com.test.rashmi.pages which is available under src/main/java
* Application URL mentioned in file 'serenity.properties'

**Scope of Improvement**:
* History page verification can include T-Shirt - size and quantity
* Update Personal Info : Timestamp can be combine with value in order keep it unique at every execution

