# Demo Web Application — Maven + Java 11

A minimal Java web app to practice the core Maven lifecycle commands.

---

## Project Structure

```
demo-webapp/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/demo/
    │   │   ├── MathUtils.java            ← Business logic (pure Java)
    │   │   └── servlet/
    │   │       ├── HelloServlet.java     ← GET /hello?name=...
    │   │       └── CalculatorServlet.java← POST /calculate
    │   └── webapp/
    │       ├── index.html
    │       ├── css/style.css
    │       └── WEB-INF/web.xml
    └── test/
        └── java/com/demo/
            └── MathUtilsTest.java        ← 11 JUnit 5 tests
```

---

## Prerequisites

| Tool | Version |
|------|---------|
| JDK  | 11+     |
| Maven| 3.6+    |

---

## Maven Commands to Practice

### 1. `mvn test`
Compiles source + test code, then runs all JUnit 5 tests.
```bash
mvn test
```
Watch for: `BUILD SUCCESS`, tests run/passed/failed counts in the Surefire output.

---

### 2. `mvn package`
Runs tests, then packages everything into a WAR file.
```bash
mvn package
```
Output: `target/demo-webapp.war`

---

### 3. `mvn install`
Same as `package`, then installs the WAR into your local Maven repository (`~/.m2`).
```bash
mvn install
```
After this, other local Maven projects can declare it as a dependency.

---

### Bonus commands

```bash
mvn clean              # Delete target/ directory
mvn clean package      # Clean build from scratch
mvn test -pl .         # Run only tests (skip compile if already done)
mvn package -DskipTests# Package without running tests
```

---

## Deploying the WAR

Copy `target/demo-webapp.war` to your Tomcat `webapps/` folder, then start Tomcat:

```bash
cp target/demo-webapp.war /opt/tomcat/webapps/
$TOMCAT_HOME/bin/startup.sh
```

Open: http://localhost:8080/demo-webapp/

---

## What the App Does

| URL | Method | Description |
|-----|--------|-------------|
| `/demo-webapp/` | GET | Home page |
| `/demo-webapp/hello?name=Alice` | GET | Greeting servlet |
| `/demo-webapp/calculate` | POST | Calculator (add/sub/mul/div) |
