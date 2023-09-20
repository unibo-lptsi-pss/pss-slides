## GitHub Actions: Structure

* **Workflows** react to events, launching *jobs*
    * Multiple workflows run in parallel, unless explicitly restricted
* **Jobs** of the same workflow run a sequence of *steps*
    * Multiple jobs run in parallel, unless a dependency among them is explicitly declared
    * Concurrency limits can be imposed across workflows
    * They can communicate via outputs
* **Steps** of the same job run *sequentially*
    * They can communicate via outputs

---

## GitHub Actions: Configuration

Workflows are configured in YAML files located in the default branch of the repository in the `.github/workflows` folder.

One configuration file $\Rightarrow$ one workflow

For security reasons, workflows may need to be manually activated in the *Actions* tab of the GitHub web interface.

---

## GitHub Actions: Runners

Executors of GitHub actions are called *runners*: virtual machines
(hosted by GitHub)
with the GitHub Actions runner application installed.

**Note**: the GitHub Actions application is open source and can be installed locally,
creating "*self-hosted runners*". Self-hosted and GitHub-hosted runners can work together.

Upon their creation, runners have a default environment, which depends on their *operating system*
* Documentation available at [https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners#preinstalled-software](https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners#preinstalled-software)

---

## Convention over configuration

Several CI systems inherit the "*convention over configuration* principle.

For instance, by default (with an empty configuration file) Travis CI builds a Ruby project using `rake`.

GitHub actions **does not** adhere to the principle:
if left unconfigured, the runner does nothing
(it does not even clone the repository locally).

Probable reason: Actions is an *all-round* repository automation system for GitHub,
not just a "plain" CI/CD pipeline

$\Rightarrow$ It can react to many different events, not just changes to the git repository history

---

## GHA: basic workflow structure

Minimal, simplified workflow structure:

```yaml
# Mandatory workflow name
name: Workflow Name
on: # Events that trigger the workflow
jobs: # Jobs composing the workflow, each one will run on a different runner
    Job-Name: # Every job must be named
        # The type of runner executing the job, usually the OS
        runs-on: runner-name
        steps: # A list of commands, or "actions"
            - # first step
            - # second step
    Another-Job: # This one runs in parallel with Job-Name
        runs-on: '...'
        steps: [ ... ]
```

---

### DRY with YAML

We discussed that automation / integration pipelines **are** part of the software
* They are subject to the same (or even higher) quality standards
* All the good engineering principles apply!

YAML is often used by CI integrators as preferred configuration language as it enables some form of DRY:
1. Anchors (`&` / `*`)
2. Merge keys (`<<:`)

```yaml
hey: &ref
  look: at
  me: [ "I'm", 'dancing' ]
merged:
  foo: *ref
  <<: *ref
  look: to
```

Same as:

```yaml
hey: { look: at, me: [ "I'm", 'dancing' ] }
merged: { foo: { look: at, me: [ "I'm", 'dancing' ] }, look: to, me: [ "I'm", 'dancing' ] }
```

---

## GitHub Actions' actions

GHA's YAML parser *does not support standard YAML anchors and merge keys*

(it is a well-known limit with [an issue report open since ages](https://github.com/actions/runner/issues/1182))

GHA achieves reuse via:
* "**actions**": *reusable parameterizable **steps***
    * *JavaScript* (working on any OS)
    * *Docker container*-based (linux only)
    * *Composite* (assemblage of other actions)
* "**reusable workflows**": *reusable and parameterizable **jobs***

Many actions are provided by GitHub directly,
and many are developed by the community.

---

## Workflow minimal example

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-example.yml" to=20 >}}

---

## Workflow minimal example

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-example.yml" from=22 to=39 >}}

---

## Workflow minimal example

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-example.yml" from=40 to=60 >}}

---

## Workflow minimal example

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-example.yml" from=61 >}}

---

## GHA expressions

GitHub Actions allows *expressions* to be included in the workflow file
* Syntax: `${{ <expression> }}`
* Special rule: `if:` conditionals are automatically evaluated as expressions, so `${{ }}` is unnecessary
    * `if: <expression>` works just fine

The language is rather limited, and documented at
* [https://docs.github.com/en/actions/learn-github-actions/expressions](https://docs.github.com/en/actions/learn-github-actions/expressions)

* The language performs a *loose equality*
    * Equal types are compared
    * Different types are *coerced to integers* when compared

* When a string is required, any type is *coerced to string*
    * String comparison ignores case

---

### GHA Expressions Types

| Type | Literal | Number coercion | String coercion
|---|---|---|---|
| Null | `null` | `0` | `''` |
| Boolean | `true` or `false` | `true`: `1`, `false`: `0` | `'true'` or `'false'` |
| String | `'...'` (mandatorily single quoted) | Javascript's `parseInt`, with the exception that `''` is `0` | none |
| JSON Array | unavailable | `NaN` | error |
| JSON Object | unavailable | `NaN` | error |

Arrays and objects exist and can be manipulated, but cannot be created

---

### GHA Expressions Operators

* Grouping with `( )`
* Array access by index with `[ ]`
* Object deference with `.`
* Logic operators: not `!`, and `&&`, or `||`
* Comparison operators: `==`, `!=`, `<`, `<=`, `>`, `>=`

---

### GHA Expressions Functions

Functions *cannot be defined*. Some are *built-in*, their expressivity is *limited*. They are documented at

[https://docs.github.com/en/actions/learn-github-actions/expressions#functions](https://docs.github.com/en/actions/learn-github-actions/expressions#functions)

#### Job status check functions

* `success()`: `true` if none of the previous steps failed
    * By default, every step has an implicit `if: success()` conditional
* `always()`: always `true`, causes the step evaluation even if previous failed, but supports combinations
    * `always() && <expression returning false>` evaluates the expression and does not run the step
* `cancelled()`: `true` if the workflow execution has been canceled
* `failure()`: `true` if a previous step of any previous job has failed

---

## The GHA context

The expression can refer to some objects provided by the context. They are documented at

[https://docs.github.com/en/actions/learn-github-actions/contexts](https://docs.github.com/en/actions/learn-github-actions/contexts)

Some of the most useful are the following

* `github`: information on the workflow context
    * `.event_name`: the event that triggered the workflow
    * `.repository`: repository name
    * `.ref`: branch or tag that triggered the workflow
        * e.g., `refs/heads/<branch>` `refs/tags/<tag>`
* `env`: access to the environment variables
* `steps`: access to previous step information
    * `.<step id>.outputs.<output name>`: information exchange between steps
* `runner`:
    * `.os`: the operating system
* `secrets`: access to secret variables (in a moment...)
* `matrix`: access to the build matrix variables (in a moment...)

---

## Checking out the repository

By default, GitHub actions' *runners do **not** check out the repository*
* Actions may not need to access the code
    * e.g., Actions automating issues, projects

It is a *common* and *non-trivial* operation (the checked out version must be the version originating the workflow), thus GitHub provides an action:

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-example.yml" from=46 to=47 >}}

Since actions typically do not need the entire history of the project, by default the action checks out *only the commit that originated the workflow* (`--depth=1` when cloning)
* *Shallow cloning* has better *performance*
* $\Rightarrow$ It may break operations that rely on the entire history!
    * e.g., the git-sensitive semantic versioning system

Also, *__tags__ don't get checked out*

---

## Checking out the whole history

{{< github owner="DanySK" repo="action-checkout" path="action.yml" from=19 >}}

(code from a custom action, ignore the `if`)

* Check out the repo with the maximum *depth*
* Recursively check out all *submodules*
* Checkout all *tags*

---

## Writing outputs

Communication with the runner happens via *[workflow commands](https://docs.github.com/en/actions/using-workflows/workflow-commands-for-github-actions)*
<br>
The simplest way to send commands is to print on standard output a message in the form:
<br>
`::workflow-command parameter1={data},parameter2={data}::{command value}`

In particular, actions can set outputs by printing:
<br>
`::set-output name={name}::{value}`

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/use-step-outputs.yml" from=6 >}}

---

## Build matrix

Most software products are meant to be *portable*
* Across operating systems
* Across different frameworks and languages
* Across runtime configuration

A good continuous integration pipeline should test *all the supported combinations*
* or a sample, if the performance is otherwise unbearable

The solution is the adoption of a **build matrix**
* Build variables and their allowed values are specified
* The CI integrator generates the *cartesian product* of the variable values, and launches a build for each!
* Note: there is no built-in feature to exclude some combination
    * It must be done manually using `if` conditionals

---

## Build matrix in GHA

{{< github owner="DanySK" repo="Tutorial-GitHub-Actions-Minimal" path=".github/workflows/workflow-matrix.yml" from=19 >}}

---

## Private data and continuous integration

We would like the CI to be able to
* Sign our artifacts
* Delivery/Deploy our artifacts on remote targets

Both operations **require private information to be shared**

Of course, private data *can't be shared*
* Attackers may steal the identity
* Attackers may compromise deployments
* In case of open projects, attackers may exploit *pull requests*!
    * Fork your project (which has e.g. a secret environment variable)
    * Print the value of the secret (e.g. with `printenv`)

How to *share a secret* with the build environment?

---

## Secrets

Secrets can be stored in GitHub at the repository or organization level.

GitHub Actions can access these secrets from the context:
* Using the `secrets.<secret name>` context object
* Access is allowed only for workflows generated by local events
    * Namely, no secrets for pull requests

Secrets can be added from the web interface (for mice lovers), or via the GitHub API.

```ruby
#!/usr/bin/env ruby
require 'rubygems'
require 'bundler/setup'
require 'octokit'
require 'rbnacl'
repo_slug, name, value = ARGV
client = Octokit::Client.new(:access_token => 'access_token_from_github')
pubkey = client.get_public_key(repo_slug)
key = Base64.decode64(pubkey.key)
sodium_box = RbNaCl::Boxes::Sealed.from_public_key(key)
encrypted_value = Base64.strict_encode64(sodium_box.encrypt(value))
payload = { 'key_id' => pubkey.key_id, 'encrypted_value' => encrypted_value }
client.create_or_update_secret(repo_slug, name, payload)
```
