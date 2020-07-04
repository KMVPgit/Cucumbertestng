$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/venka/eclipse-workspace/cucumberTng/src/test/java/Features/01_login.feature");
formatter.feature({
  "name": "login into application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Positive login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.User_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click SignUp",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.Click_SignUp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Clicks SignUp via gmail",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.Clicks_SignUp_via_gmail()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [Sign in – Google Accounts] but found [Sign in – Google accounts]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\r\n\tat org.testng.Assert.assertEquals(Assert.java:116)\r\n\tat org.testng.Assert.assertEquals(Assert.java:190)\r\n\tat org.testng.Assert.assertEquals(Assert.java:200)\r\n\tat StepDefinition.Stepdef.Clicks_SignUp_via_gmail(Stepdef.java:104)\r\n\tat ✽.Clicks SignUp via gmail(C:/Users/venka/eclipse-workspace/cucumberTng/src/test/java/Features/01_login.feature:5)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});