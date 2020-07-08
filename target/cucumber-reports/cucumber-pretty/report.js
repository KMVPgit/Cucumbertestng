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
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});