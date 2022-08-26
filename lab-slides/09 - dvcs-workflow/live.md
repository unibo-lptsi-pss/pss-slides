DVCS Workflow

- Example of git flow

```
cd ~
mkdir git-flow-example && cd git-flow-example
git init
touch .gitignore
git commit -m "Empty gitignore"
git checkout -b develop
git checkout -b feature-hello-world develop
mkdir src
nano src/HelloWorld.java
git commit -am "Hello world class"
javac src/HelloWorld.java -d bin && java -cp bin/ HelloWorld
echo "bin/" >> .gitignore
git add .
git commit -m "Add bin/ to gitignore"
git checkout develop
git merge --no-ff feature-hello-world
git branch -d feature-hello-world
git checkout -b release-v1 develop
nano README.md
git add .
git commit -m "README"
git checkout master
git merge --no-ff release-v1
git tag 1.0
git branch -d release-v1
git checkout -b hotfix-readme
nano README
git add .
git commit -m "Fix readme"
git checkout master
git merge --no-ff hotfix-readme
git branch -d hotfix-readme
```

Gradle

- show `sample-gradle-project` source code; run it
- `./gradlew dependencies`: shows the dependency tree for the project
- Show `build.gradle.kts`
- `./gradlew projects`: list of projects
- `./gradlew tasks`
- `gradle wrapper --gradle-version=6.0`
- `./gradlew build`
- `./gradlew test`
- `./gradlew jar` (note, this is not a fat JAR)
