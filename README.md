# Lemon Challenge 🍋
This project was created to complete the automation challenge.

## Built with 🛠️
* JDK 1.8
* Gradle
* Cucumber

## Configurations ⚙️
It is necessary to have installed the Java JDK and Gradle, as well as the environment variables configured in the operating system: `JAVA_HOME` and `GRADLE_HOME`.
<br>Then run the command `gradle clean install` to download all the necessary dependencies.

## Test execution 🚀
To run the automated tests, run the following command in the Terminal: `./gradlew clean test --tests [runner] -Dcucumber.options="--tags @[tag]" aggregate --info`

### Site 
https://demo.testim.io/

### Disclaimer 😲
In order to speed up the correction, the properties file was not created to store sensitive development information, such as: 

- URL
- Credentials 
- Sensitive test information

### Contributing ✒️
1. Clone the repository
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Run the tests or make changes
4. Commit your changes (`git add .` , `Git commit -m "Add some feature"`)
5. Push the branch (`git push origin my-new-feature`)
6. Create a new pull request


