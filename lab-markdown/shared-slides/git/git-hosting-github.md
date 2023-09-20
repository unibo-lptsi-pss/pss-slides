## Centralized Version Control Systems

![Centralized VCS](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/git/centralized-vcs.svg)

---

## Decentralized VCS

![Decentralized VCS](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/git/decentralized-vcs.svg)

---

## Real-world DVCS

![Real-world Decentralized VCS](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/git/dvcs-sink.svg)

---

## Git repository hosting

Several services allow the creation of *shared repositories on the cloud*.
They *enrich* the base git model with services built around the tool:

* **Forks**: copies of a repository associated to different users/organizations
* **Pull requests** (or **Merge requests**): formal requests to *pull* updates from *forks*
  * repositories do not allow pushes from everybody
  * what if we want to contribute to a project we cannot push to?
    * *fork* the repository (we *own* that copy)
    * write the contribution and push to our *fork*
    * ask the maintainers of the *original repository* to *pull from* our fork
* **Issue tracking**

---

## Most common services

* <i class="fa-brands fa-github"></i> **GitHub**
  * Replaced Sourceforge as the *de-facto standard* for open source projects hosting
  * *Academic plan*
* <i class="fa-brands fa-gitlab"></i> **GitLab**
  * Available for free as *self-hosted*
  * Userbase grew when Microsoft acquired GitHub
* <i class="fa-brands fa-bitbucket"></i> **Bitbucket**
  * From Atlassian
  * Well integrated with other products (e.g., Jira)


---

## <i class="fa-brands fa-github"></i> GitHub

* *Hosting* for git repositories
* *Free for open source*
* *Academic accounts*
* *De-facto standard* for open source projects
* One *static website* per-project, per-user, and per-organization
  * (a feature exploited by these slides)

---

## <i class="fa-brands fa-github"></i> repositories as remotes: authentication

<i class="fa-brands fa-github"></i> repositories are uniquely identified by an **owner** and a **repository name**
* `owner/repo` is a name unique to every repository

<i class="fa-brands fa-github"></i> supports two kind of authentications:
### **HTTPS** -- Requires authentication via token
* The <i class="fab fa-windows"></i> port of <i class="fa-brands fa-git"></i> should include a graphical authenticator, otherwise:
    * a token must be generated with `repo` access scope at https://github.com/settings/tokens/new
    * the URL `https://github.com/owner/repo.git` becomes: `https://token@github.com/owner/repo.git`
* Recommended to <i class="fab fa-windows"></i> users with no Unix shell

### **Secure Shell (SSH)** -- Requires authentication via public/private key pair
* Recommended to <i class="fab fa-linux"></i>/<i class="fab fa-apple"></i> users and to those with a working SSH installation
* The same protocol used to open remote terminals on other systems
* Tell Github your **public** key and use the **private** (and *secret*) key to authenticate

---

## Configuration of OpenSSH for <i class="fa-brands fa-github"></i>

**Disclaimer**: this is a "quick and dirty" way of generating and using SSH keys.
<!-- markdown-link-check-disable-next-line -->
You are warmly recommended to learn how it works and [the best security practices](https://archive.ph/3Pn0L).

1. If you don't already have one, generate a new key pair
    * `ssh-keygen`
    * You can confirm the default options
    * You can pick an empty password
        * <i class="fa-solid fa-arrow-up"></i> your private key will be stored *unencrypted* on your file system
        * please understand the associated security issues, if you don't, use a password.
2. Obtain your **public key**
    * `cat ~/.ssh/id_rsa.pub`
    * Looks something like:
    ```text
    ssh-rsa AAAAB3Nza<snip, a lot of seemingly random chars>PIl+qZfZ9+M= you@your_hostname
    ```
3. Create a new key at https://github.com/settings/ssh/new
    * Provide a title that allows you to identify the key
    * Paste your key

You are all set! Enjoy your secure authentication.
