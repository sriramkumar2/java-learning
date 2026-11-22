# How to Install and Run – RequestDispatcher Practice 2 (Passing Data Between Servlets)

This guide shows how to set up the tools and run this project, either from **Eclipse** (easiest) or from the **command line** (no IDE).

---

## 1. Prerequisites

| Tool | Version | Download |
|------|---------|----------|
| JDK | 17 or newer (project is configured for Java 26) | https://adoptium.net or https://www.oracle.com/java/ |
| Apache Tomcat | **10.1.x** (needed for `jakarta.servlet.*`) | https://tomcat.apache.org/download-10.cgi |
| Eclipse IDE | *Eclipse IDE for Enterprise Java and Web Developers* | https://www.eclipse.org/downloads/packages/ |
| Git | any | https://git-scm.com/downloads |

> **Note:** Tomcat 9 and older use `javax.servlet` and will **not** run this project. Use Tomcat 10.1 or newer.

### Install the JDK
1. Download and install the JDK.
2. Set the `JAVA_HOME` environment variable to the JDK folder (for example `C:\Program Files\Java\jdk-26`).
3. Add `%JAVA_HOME%\bin` to `PATH`.
4. Check it works:
   ```
   java -version
   javac -version
   ```

### Install Tomcat
1. Download the **zip** (Windows) or **tar.gz** (Linux/macOS) of Tomcat 10.1.
2. Extract it to a folder, for example `C:\apache-tomcat-10.1.x`. This folder is called `CATALINA_HOME` below.

---

## 2. Get the Code

```
git clone https://github.com/sriramkumar2/java-learning.git
cd java-learning/adv-java/03-RequestDispatcherPractice2
```

---

## 3. Option A – Run in Eclipse (Recommended)

### Step 1: Add Tomcat to Eclipse
1. Open Eclipse → **Window → Preferences → Server → Runtime Environments**.
2. Click **Add…** → choose **Apache Tomcat v10.1** → **Next**.
3. Browse to your Tomcat folder (`CATALINA_HOME`) and choose your JDK → **Finish**.

### Step 2: Import the project
1. **File → Import… → General → Existing Projects into Workspace** → **Next**.
2. **Select root directory** → browse to `adv-java/03-RequestDispatcherPractice2`.
3. Make sure `RequestDispatcherPractice2` is ticked → **Finish**.

> If you see errors on `jakarta.servlet` imports: right-click the project → **Properties → Targeted Runtimes** → tick **Apache Tomcat v10.1** → **Apply and Close**.
>
> If your JDK is older than 26: right-click the project → **Properties → Project Facets** → set **Java** to your JDK version, and update **Java Build Path → Libraries → JRE System Library** to match.

### Step 3: Run
1. Right-click the project → **Run As → Run on Server**.
2. Select **Tomcat v10.1 Server** → **Finish**.
3. The browser opens at:
   ```
   http://localhost:8080/RequestDispatcherPractice2/
   ```
4. Click **Submit**. You should see:
   ```
   Welcome,Sriram
   ```
   (shown as a heading). The name `Sriram` was stored by `FirstServlet` with `request.setAttribute("username", name)` and read by `SecondServlet` with `request.getAttribute("username")`.

---

## 4. Option B – Run from the Command Line (No IDE)

Run these commands from inside `03-RequestDispatcherPractice2`.

### Windows (PowerShell)
```powershell
$env:CATALINA_HOME = "C:\apache-tomcat-10.1.x"   # change to your Tomcat path

# 1. Create the web app folder structure
New-Item -ItemType Directory -Force build\RequestDispatcherPractice2\WEB-INF\classes | Out-Null

# 2. Compile the servlets against Tomcat's servlet API
javac -cp "$env:CATALINA_HOME\lib\servlet-api.jar" `
      -d build\RequestDispatcherPractice2\WEB-INF\classes `
      src\main\java\com\practice\controller\*.java

# 3. Copy the web pages
Copy-Item -Recurse -Force src\main\webapp\* build\RequestDispatcherPractice2\

# 4. Deploy to Tomcat and start it
Copy-Item -Recurse -Force build\RequestDispatcherPractice2 "$env:CATALINA_HOME\webapps\"
& "$env:CATALINA_HOME\bin\startup.bat"
```

### Linux / macOS
```bash
export CATALINA_HOME=/path/to/apache-tomcat-10.1.x   # change to your Tomcat path

mkdir -p build/RequestDispatcherPractice2/WEB-INF/classes
javac -cp "$CATALINA_HOME/lib/servlet-api.jar" \
      -d build/RequestDispatcherPractice2/WEB-INF/classes \
      src/main/java/com/practice/controller/*.java
cp -r src/main/webapp/* build/RequestDispatcherPractice2/
cp -r build/RequestDispatcherPractice2 "$CATALINA_HOME/webapps/"
"$CATALINA_HOME/bin/startup.sh"
```

### Open the app
```
http://localhost:8080/RequestDispatcherPractice2/
```
Click **Submit** → the page shows the heading **Welcome,Sriram**.

### Stop Tomcat
- Windows: `& "$env:CATALINA_HOME\bin\shutdown.bat"`
- Linux/macOS: `"$CATALINA_HOME/bin/shutdown.sh"`

---

## 5. URLs in This Project

| URL | What it does |
|-----|--------------|
| `/RequestDispatcherPractice2/` | Opens `index.html` with the Submit button |
| `/RequestDispatcherPractice2/FirstServlet` | Stores `username = "Sriram"` as a request attribute, then **forwards** the request to `SecondServlet` |
| `/RequestDispatcherPractice2/SecondServlet` | Reads the `username` attribute and writes `<h2>Welcome,Sriram</h2>` to the browser |

Notice that after clicking Submit the browser address bar still shows `/FirstServlet` — that is because `forward()` happens on the server and the browser never knows about `SecondServlet`. Because it is the **same request** object, the attribute set in `FirstServlet` is still available in `SecondServlet`.

> If you open `/SecondServlet` directly, the page shows **Welcome,null** — no one set the `username` attribute on that request.

---

## 6. Troubleshooting

| Problem | Fix |
|---------|-----|
| `package jakarta.servlet does not exist` | Use Tomcat **10.1+**, and add it as the Targeted Runtime (Eclipse) or put `servlet-api.jar` on the `-cp` (command line). |
| `404 Not Found` | Check the context path is `/RequestDispatcherPractice2/` (case-sensitive) and that the app deployed (look in Tomcat logs). |
| `Port 8080 already in use` | Stop the other program, or change the port in `CATALINA_HOME/conf/server.xml` (`<Connector port="8080" …>`). |
| `UnsupportedClassVersionError` | Tomcat is running on an older Java than the one you compiled with. Make `JAVA_HOME` point to the same JDK, or compile with `javac --release 17 …`. |
| Eclipse shows "Unbound classpath container: JavaSE-26" | Install JDK 26, or change the project's Java facet and JRE library to the JDK you have (see Step 2 above). |
