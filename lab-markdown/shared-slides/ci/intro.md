# Continuous Integration

The practice of integrating code with a main development line **continuously**
<br>
_Verifying_ that the build remains intact
* Requires *build automation* to be in place
* Requires *testing* to be in place
* Pivot point of the *DevOps* practices
* Historically introduced by the extreme programming (XP) community
* Now widespread in the larger DevOps community

---

# Traditional integration

![integration-traditional](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/ci/integration-traditional.png)

---

# The Integration Hell

* Traditional software development takes several months for *“integrating”* a couple of years of development
* The longer there is no integrated project, the higher the **risk**

---

# Continuous integration

![integration-traditional](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/ci/integration-continuous.png)

---

## Microreleases and protoduction

* High frequency integration may lead to high frequency releases
    * Possibly, *one per commit*
    * Of course, *versioning* must be appropriate...

Traditionally, **protoduction** is jargon for a *prototype that ends up in production*

<div style="display:inline-block;vertical-align:top;">

![](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/ci/protoduction.jpg)

</div>
<div style="display:inline-block;">

* Traditionally used with a *negative* meaning
    * It implied software
        * *unfinished*,
        * *unpolished*,
        * *badly designed*
    * Very common, unfortunately
* This si different in a continuously integrated environment
    * *Incrementality* is fostered
    * Partial features are *up to date* with the mainline
</div>

---

## Intensive operations should be elsewhere
* The build process should be *rich* and *fast*
* Operations requiring a long time should be *automated*
    * And run somewhere else than devs' PCs

![](https://raw.githubusercontent.com/DanySK/shared-slides/6824b93d3d52b841386a744f57953a73ccb67378/ci/compiling.png)

---

## Continuous integration software

Software that promotes CI practices should:
* Provide *clean environments* for compilation/testing
* Provide a *wide range* of environments
    * Matching the relevant specifications of the actual targets
* High degree of *configurability*
* Possibly, *declarative configuration*
* A *notification system* to alert about failures or issues
* Support for *authentication* and deployment to external services

**Plenty** of integrators on the market

Circle CI, Travis CI, Werker, done.io, Codefresh, Codeship, Bitbucket Pipelines, GitHub Actions, GitLab CI/CD Pipelines, JetBrains TeamCity...
