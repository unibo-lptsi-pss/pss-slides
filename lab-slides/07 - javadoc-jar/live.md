JAR

1. Open lab07 in eclipse
2. Compile packages it.unibo.oop.jar.packages.pkg1,pkg2,pkg3 in bin/ (manually or from IDE)
3. Go to bin/
4. Create a jar
    - `jar cf jar-file.jar it/unibo/oop/jar/*`
    - JAR is a ZIP: `unzip jar-file.jar -d jar-dir`
    - Just show JAR content: `jar tf jar-file.jar`
    - Inspect created `META-INF/MANIFEST.MF`
    - Try to run the JAR -> error
5. Create with a `MYMANIFEST`
    - Content of `MYMANIFEST`: `Main-Class: it.unibo.oop.jar.packages.pkg3.UseDummies`
    - `jar cfm jar-file.jar MYMANIFEST *`
        - Notice that, independently of the name of `MYMANIFEST`, its content will go to `META-INF/MANIFEST.MF`
    - `java -jar jar-file.jar`
6. Go to project root dir and try to build the jar with command: `jar cfm jar-file.jar bin/MANIFEST.MF bin/it/unibo/oop/jar/*`
    - Show content by unzipping it
    - Note the issue when trying to run the Java application
    - Try to fix by specifying `Class-Path: bin/` in MANIFEST.MF
7. Generate JAR file via Eclipse
    - Project -> Export -> java | JAR file
        - Export Java Source files and resources
    - Project -> Export -> java | Runnable JAR file
        - NB: you need a run configuration

JavaDoc

- Show Comments `/** ... */`
- Generate JavaDoc from Eclipse: Project -> Generate JavaDoc
    - Notice that you do not want to check it into version control
- Observe generated JavaDoc
    - Documentation for `toString` of `DummyClass` and `MinionDummy`
    - Write docstring for `DummyClass#toString` with `@return` keyword
    - `{@inheritDoc}`: the doc is not inherited from `Object#toString` since its source is not included
    - `javadoc -sourcepath src -link http://download.oracle.com/javase/6/docs/api com.example.test`
- Show `package-info.java` for describing packages
- Add docstring to `UseDummies#main` with a *link* `{@link it.unibo.oop.jar.packages.pkg1.DummyClass}`
- Show generation via cmdline `javadoc -d docs/ -sourcepath src/ -subpackages it.unibo.oop.jar`
- `javadoc -sourcepath src -link https://docs.oracle.com/en/java/javase/11/docs/api -subpackages it.unibo.oop.jar -d docs/`
    - An important property of an external referenced class is that its source comments are normally not available to the Javadoc run. In this case, these comments cannot be inherited.
