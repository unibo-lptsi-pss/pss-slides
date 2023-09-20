## Going to a new line is more complicated than it seems

Going to a new line is a two-phased operation:
1. Bring the cursor back to the begin of the line
2. Bring the cursor down one line

In *electromechanic teletypewriters* (and in typewriters, too), they were two distinct operations:
1. *Carriage Return* (bringing the carriage to its leftmost position)
2. *Line Feed* (rotating the carriage of one step)

---

## A teletypewriter

![teletypewriter](https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Telescrivente_CEP_-_Calcolatrice_Elettronica_Pisana.jpg/1080px-Telescrivente_CEP_-_Calcolatrice_Elettronica_Pisana.jpg)

* driving them text without drivers required to *explicitly send* *carriage return* and *line feed* commands

---

## Newlines in the modern world

Terminals were designed to behave like virtual teletypewriters
* Indeed, they are still called **TTY** (**T**ele**TY**pewriter)
* In Unix-like systems, they are still implemented as *virtual devices*
  * If you have MacOS X or Linux, you can see which virtual device backs your current terminal using `tty`
* At some point, Unix decided that `LF` was sufficient in virtual TTYs to go to a new line
  * Probably *inspired by the C language*, where `\n` means "newline"
  * The behaviour can still be disabled
```text
we would get
            lines
                 like these
```

####  Consequence:
* Windows systems go to a new line with a `CR` character followed by an `LF` character: `\r\n`
* Unix-like systems go to a new line with an `LF` character: `\n`
* Old Mac systems used to go to a new line with a `CR` character: `\r`
  * Basically they decided to use a single character like Unix did, but made the opposite choice
  * MacOS X is POSIX-compliant, uses `\n`

---

## Newlines and version control

If your team uses *multiple OSs*, it is likely that, by default, the text editors use either `LF` (on Unix) or `CRLF`

It is also very likely that, upon saving, the whole file gets rewritten with the "*locally* correct" *line endings*

* This however would result in *all the lines being changed*!
* The differential would be huge
* *Conflicts would arise everywhere*!

Git tries to tackle this issue by converting the line endings so that they match the initial line endings of the file,
resulting in repositories with *illogically mixed line endings*
(depending on who created a file first)
and loads of warnings about `LF`/`CRLF` conversions.

Line endings should instead be **configured per file type!**

---

## `.gitattributes`

* A sensible strategy is to use `LF` everywhere, but for Windows scripts (`bat`, `cmd`, `ps1`)
* Git can be configured through a `.gitattributes` file in the repository root
  * It can do [much more than enforcing line endings](https://git-scm.com/docs/gitattributes), actually
* Example: 
```text
* text=auto eol=lf
*.[cC][mM][dD] text eol=crlf
*.[bB][aA][tT] text eol=crlf
*.[pP][sS]1 text eol=crlf
```
