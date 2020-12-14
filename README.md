# seven-senders-automation-suite
This test suite is created according to page object pattern using Selenium to test various scenarios of [Komoot](https://www.komoot.com/) (majorly home screen and login/signup functionality).

### Test Cases Description
- **Verify Home Page Title** -> This test case compares the actual title of home screen as per the expected one using assertions.
- **Verify Sign Up Link Url** ->  When `Sign up or Login` link is clicked on homepage, this test case compares the current url of website with the expected one.
- **Verify Sign Up Login Title** -> When `Sign up or Login` link is clicked on homepage, this test case compares the title of sign up screen with the expected one.
- **Verify Logged In username** -> When the user logs in with the provided credentials, this test case compares the actual username after successful login with the expected one using assertions.
- **Verify Invalid Login message** -> When user tries to login with invalid credentials, then error message is thrown, same is compared with the expected one in this test case.

## Prerequisites
In order to utilise this project you need to have the following installed locally:
* Maven 3
* Chrome browser (UI tests are configured to use Chrome by default)
* Java 1.8
* IDE (Eclipse, Intellij, etc.)

## Running Tests
1. Make sure all the project dependencies are getting resolved and build being successful
```bash
$  mvn test-compile
```
2. Run the test cases from command line
```bash
$  mvn clean test
```

## Report Generation
1. Once all the test cases are executed, testng report is generated in target/surefire-reports directory
