## Branches as labels

To be able to start new development lines,
we need to *create* a **branch**.

In Git, branches work like *movable labels*:
* Upon creation, they are attached to the same commit `HEAD` refers to
* If a new commit is made when `HEAD` is attached to them, they **move along with `HEAD`**

---

## Branch creation

Branches are created with `git branch branch_name`

```mermaid
flowchart RL
%%  HEAD{{"HEAD fas:fa-unlink"}}
  HEAD{{"HEAD"}}
  b1(master)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o b1

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

⬇️ `git branch new-experiment` ⬇️

{{% fragment %}}

```mermaid
flowchart RL
%%  HEAD{{"HEAD fas:fa-unlink"}}
  HEAD{{"HEAD"}}
  b1(master)
  b2(new-experiment)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10
  b2 -.-> C10

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o b1

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

`HEAD` does not attach to the new branch by default,
an explicit `checkout` is required.

{{% /fragment %}}

---

## Creating branches when in **DETACHED_HEAD**

Creating new branches allows to store changes made when we are in **DETACHED_HEAD** state.

```mermaid
flowchart RL
%%  HEAD{{"HEAD fas:fa-unlink"}}
  HEAD{{"HEAD"}}
  b1(master)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o b1

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

{{% fragment %}}
⬇️ `git checkout HEAD~4` ⬇️

{{% /fragment %}}

{{% fragment %}}

```mermaid
flowchart RL
  HEAD{{"HEAD fas:fa-unlink"}}
  b1(master)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

* **DETACHED_HEAD**: our changes will be discarded, unless...
{{% /fragment %}}

{{% fragment %}}
➡️ Next: `git branch new-experiment` ➡️
{{% /fragment %}}

---

## Creating branches when in **DETACHED_HEAD**

⬇️ `git branch new-experiment` ⬇️

```mermaid
flowchart RL
  HEAD{{"HEAD fas:fa-unlink"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6
  b2 -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

{{% fragment %}}
`HEAD` is still *detached* though, we need to *attach it to the new branch* for it to store our commits
{{% /fragment %}}

{{% fragment %}}
➡️ Next: `git checkout new-experiment` ➡️
{{% /fragment %}}

---

## Creating branches when in **DETACHED_HEAD**

⬇️ `git checkout new-experiment` ⬇️

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

* New commits will now be stored!

{{% fragment %}}

⬇️ [changes] + `git add` + `git commit` ⬇️

{{% /fragment %}}

{{% fragment %}}

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])
  C11([11]) --> C6

  b1 -.-> C10

  HEAD -.-> C11
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C11

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11 commit;
```

$\Rightarrow$ `HEAD` brings our branch forward with it!

{{% /fragment %}}

---

## One-shot branch creation

As you can imagine, creating a *new branch* and *attaching `HEAD`* to the freshly created branch is pretty common

As customary for common operations, a short-hand is provided: `git checkout -b new-branch-name`
* Creates `new-branch-name` from the current position of `HEAD`
* Attaches `HEAD` to `new-branch-name`

```mermaid
flowchart RL
  HEAD{{"HEAD fas:fa-unlink"}}
  b1(master)

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

⬇️ `git checkout -b new-experiment` ⬇️

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10 commit;
```

---

## Merging branches

Reunifying diverging development lines is *much trickier* than spawning new development lines

In other words, *merging* is **much trickier** than *branching*

* Historically, with *centralized* version control systems, merging was considered extremely delicate and difficult
* The *distributed* version control systems promoted *frequent*, *small-sized* merges, much easier to deal with
* **Conflicts** *can still arise!*
  * what if we change the same line of code in two branches differently?

In Git, `git merge target` merges the branch named `target` into the current branch (`HEAD` must be attached)

---

## Merge visual example

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])
  C12([12]) --> C11([11]) --> C6 

  b1 -.-> C10

  HEAD -.-> C12
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C12

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12 commit;
```

⬇️ `git merge master` ⬇️

{{% fragment %}}

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])
  C13([13]) --> C12([12]) --> C11([11]) --> C6 
  C13 --> C10

  b1 -.-> C10

  HEAD -.-> C13
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C13

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13 commit;
```

{{% /fragment %}}

---

## Fast forwarding

Consider this situation:

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C6
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C6

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13 commit;
```

* We want `new-experiment` to also have the changes from `C7`, to `C10` (to be up to date with `master`)
* `master` contains all the commits of `new-experiment`
* We don't really need a merge commit, we can just move `new-experiment` to point it to `C6`
* $\Rightarrow$ This is called a **fast-forward**
  * It is the *default behavior* in Git when merging branches where the target is the head plus something

{{% fragment %}}

```mermaid
flowchart RL
  HEAD{{"HEAD"}}
  b1(master)
  b2("new-experiment")

  C10([10]) --> C9([9]) --> C8([8]) --> C7([7]) --> C6([6]) --> C5([5]) --> C4([4]) --> C3([3]) --> C2([2]) --> C1([1])

  b1 -.-> C10

  HEAD -.-> C10
  HEAD --"fas:fa-link"--o b2
  b2 -.-> C10

  class HEAD head;
  class b1,b2 branch;
  class C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13 commit;
```

{{% /fragment %}}

---

## Merge conflicts

Git tries to resolve most conflicts by *itself*
* It's *pretty good* at it
* but things can still require *human intervention*

In case of conflict on one or more files, Git marks the subject files as *conflicted*, and modifies them adding *merge markers*:

```text
<<<<<<< HEAD
Changes made on the branch that is being merged into,
this is the branch currently checked out (HEAD).
=======
Changes made on the branch that is being merged in.
>>>>>>> other-branch-name
```

* The user should *change the conflicted files* so that they reflect the *final desired status*
* The (now fixed) files should get added to the stage with `git add`
* The merge operation can be concluded through `git commit`
  * In case of merge, the message is pre-filled in
  * If the message is okay, `git commit --no-edit` can be used to use it without editing

---

## Good practices

**Avoiding merge conflicts is *much* better than solving them**

Although they are unavoidable in some cases, they can be *minimized* by following a few *good practices*:

* **Do not** *track files that can be generated*
  * This is harmful under many points of view, and merge conflicts are one
* **Do** *make many small commits*
  * Each coherent change should be reified into a commit
  * Even very small changes, like modification of the whitespaces
  * Smaller commits help Git better figure out what changed and in which order,
  generally leading to finer grained (and easier to solve) conflicts
* **Do** *enforce style rules* across the team
  * Style changes are legitimate changes
  * Style is often enforced at the IDE level
  * Minimal logical changes may cause widespread changes due to style modifications
* **Do** *pay attention to newlines*
  * Different OSs use different newline characters
  * Git tries to be smart about it, often failing catastrophically
