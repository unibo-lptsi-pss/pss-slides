## Git flow structure

```mermaid
%%{init: { 'gitGraph': { 'mainBranchName': 'master', 'showCommitLabel': false }} }%%
gitGraph
commit tag: "initial commit"
branch develop
commit
commit
branch release/1.0.0
checkout develop
commit
checkout release/1.0.0
commit
checkout master
merge release/1.0.0 tag: "1.0.0"
checkout develop
merge release/1.0.0
commit
branch feature/foo
checkout master
branch hotfix/1.0.1
commit
commit
checkout master
merge hotfix/1.0.1 tag: "1.0.1"
checkout develop
merge hotfix/1.0.1
commit
checkout feature/foo
commit
checkout develop
commit
branch feature/bar
checkout develop
commit
checkout feature/foo
merge develop
checkout develop
commit
checkout feature/bar
commit
merge develop
commit
checkout develop
merge feature/bar
commit
checkout feature/foo
commit
merge develop
commit
checkout develop
merge feature/foo
commit
branch release/1.1.0
commit
checkout develop
commit
checkout release/1.1.0
commit
checkout master
merge release/1.1.0 tag: "1.1.0"
checkout develop
merge release/1.1.0
commit
```

---

## Git flow: feature branches

sprouts from `develop` $\Rightarrow$ dies in `develop`

* Should remain up-to-date with develop
* There can be multiple ongoing feature branches

```mermaid
%%{init: { 'gitGraph': { 'mainBranchName': 'master', 'showCommitLabel': false }} }%%
gitGraph
commit tag: "initial commit"
branch develop
commit
checkout master
commit type: highlight
checkout develop
commit type: highlight
commit
branch feature/foo
commit
checkout develop
commit
commit
checkout feature/foo
merge develop
checkout develop
commit
commit
commit
checkout develop
commit
checkout feature/foo
commit
merge develop
commit
checkout develop
merge feature/foo
commit
checkout master
commit type: highlight
checkout develop
commit type: highlight
```

---

## Git flow: release branches

sprouts from `develop` $\Rightarrow$ dies in `master` and `develop`

* Pre-release changes (fixing hardcoded version numbers, changelogs, etc)

```mermaid
%%{init: { 'gitGraph': { 'mainBranchName': 'master', 'showCommitLabel': false }} }%%
gitGraph
commit tag: "initial commit"
branch develop
commit
checkout master
commit type: highlight
checkout develop
commit type: highlight
commit
branch release/1.2.3
commit
commit
checkout develop
commit
commit
checkout release/1.2.3
commit
checkout master
merge release/1.2.3 tag: "1.2.3"
checkout develop
merge release/1.2.3
commit
commit
commit
```

---

## Git flow: hotfix branches

sprouts from `master` $\Rightarrow$ dies in `master` and `develop`

* Fix errors that reached the mainline

```mermaid
%%{init: { 'gitGraph': { 'mainBranchName': 'master', 'showCommitLabel': false }} }%%
gitGraph
commit tag: "initial commit"
branch develop
commit
checkout master
commit type: highlight
checkout develop
commit type: highlight
checkout master
commit tag: "1.2.3"
branch hotfix/1.2.4
commit
commit
commit
checkout develop
commit
commit
checkout hotfix/1.2.4
commit
checkout master
merge hotfix/1.2.4 tag: "1.2.4"
checkout develop
merge hotfix/1.2.4
commit
```
