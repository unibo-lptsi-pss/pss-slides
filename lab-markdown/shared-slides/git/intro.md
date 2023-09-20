

## Reference DVCS: Git

De-facto reference distributed version control system

* *Distributed*
* Born in *2005* to replace BitKeeper as SCM for the Linux kernel
  * Performance was a major concern
  * Written in C
* Developed by Linus Torvalds
  * Now maintained by others
* *Unix-oriented*
  * Tracks Unix file permissions
* Very *fast*
  * At conception, 10 times faster than Mercurial¹, 100 times faster than Bazaar

¹ Less difference now, Facebook vastly improved Mercurial

---

## Funny historical introduction

{{< youtube id="4XpnKHJAok8" autoplay="false" title="Linus Torvalds introduces Git at Google" >}}

---

## Approach: terminal-first

#### (actually: terminal-only)

**Git is a command line tool**

Although graphical interfaces exsist, it makes no sense to learn a GUI:
* they are more prone to future changes than the CLI
* they add a level of interposition between you and the tool
* unless they are incomplete, they expose *more complexity* than what we can deal with in this course
  * what do you do with a checkbox labeled "squash when merging"?
  * and what about *recursively checkout submodules*?
* as soon as you learn *the CLI*, you become so proficient that you get *slower* when there is a graphical interface in-between

**I am assuming minimal knowledge of the shell, please let me know NOW if you've never seen it**

