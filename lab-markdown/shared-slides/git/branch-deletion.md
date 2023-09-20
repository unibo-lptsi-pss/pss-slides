## Branches as labels: deletion

*Branches* work like *special labels* that **move** if a commit is performed when `HEAD` is **attached**.

Also, the *history* tracked by git is a *directed acyclic graph* (each commit has a reference to its parents)

$\Rightarrow$ *Branches can be removed without information loss*, as far as there is at least *another branch* from which *all the commits* of the deleted branch are *reachable*

*Safe* branch deletion is performed with `git branch -d branch-name` (fails if there is information loss).

---

## Branch deletion example

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  master(master)
  bug22(fix/bug22)
  serverless(feat/serverless)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])
  C11([11]) --> C7

  master -.-> C10
  bug22 -.-> C3
  serverless -.-> C11

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o master

  class HEAD head;
  class master,bug22,serverless branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13 commit;
```

⬇️ `git branch -d fix/bug22` ⬇️


```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  master(master)
  serverless(feat/serverless)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])
  C11([11]) --> C7

  master -.-> C10
  serverless -.-> C11

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o master

  class HEAD head;
  class master,bug22,serverless branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13 commit;
```
No commit is lost, branch `fix/bug22` is removed

What about `git branch -d feat/serverless`?

It would **fail** with an error message, as `11` would be lost
