# AGENTS.md

Slides for the course *Progettazione e Sviluppo del Software* (C.d.L. in Tecnologie dei Sistemi Informatici, UniBo).
Published at <https://unibo-lptsi-pss.github.io/>.
Slide content is written in **Italian**; keep it that way.

## Repository layout

- `lecture-markdown/`: the live slides (Hugo + reveal-hugo). **Almost all work happens here.**
  - `content/<NN-topic>/`: one deck per folder.
  - `content/_index.md`: the course home page, with the **main menu** (lectures and labs).
  - `content/lab/`: lab decks, linked from the `#/lab` slide of the home page.
  - `front-page.md`, `cover.md`: shared fragments imported by every deck.
  - `layouts/shortcodes/`: custom shortcodes (`import`, `import-raw`, `menu`, `menu-group`, `smaller`, …).
  - `assets/custom-theme.scss`: the theme, including the menu styling (`.deck-menu*`).
  - `config.toml`: Hugo config. Output goes to `build/` (git-ignored).
  - Submodules: `shared-slides` (reusable slides + `preprocess.rb`), `pss-code` (code shown in slides),
    `themes/reveal-hugo`, `PPS-ci-examples`.
- `lecture-slides/`, `lab-slides/`: legacy LaTeX sources. Do not edit them unless asked.
- `replacer.rb`: one-off LaTeX → markdown converter.

## Before you change anything

Several people push to `master` (often several times a day).
**Run `git fetch` and compare against `origin/master` first.**
A "missing" slide or menu entry is often already fixed upstream.
After pulling, run `git submodule update --init --recursive`.

## Generated files: `generator.md` vs `_index.md`

- A deck folder holds **either** a hand-written `_index.md` **or** a `generator.md`.
- When `generator.md` exists, `_index.md` is **generated** from it and is git-ignored (`content/.gitignore`).
  **Edit `generator.md`, never the generated `_index.md`.**
- Hugo ignores `generator.md` (`ignoreFiles` in `config.toml`), so run the pre-processor before building.
- The pre-processor replaces `<!-- write-here "path" --> … <!-- end-write -->` blocks with the content of `path`.
  This works recursively, and paths are relative to `lecture-markdown/`.

## Building and previewing

From `lecture-markdown/`:

```sh
shared-slides/preprocess.rb   # regenerate _index.md from every generator.md (Ruby required)
hugo                          # build into build/
hugo server                   # live preview at http://localhost:1313/
```

- You need Hugo **extended** (for the SCSS theme). CI pins the version in `.github/workflows/markdown-slides.yml`.
- Mermaid diagrams render badly locally. CI inlines them (`cric96/inline-mermaid`), so do not "fix" them by hand.
- To check layout, render a slide headless, e.g.
  `google-chrome-stable --headless=new --window-size=1600,900 --virtual-time-budget=5000 --screenshot=out.png http://localhost:1313/`.

## Conventions

- Each deck's front matter sets `outputs = ["Reveal"]` and a short URL alias, e.g. `aliases = ["/guis-javafx/"]`.
  The menu links to the **alias** (`guis-javafx/`), not to the folder name.
- Slides are separated by `---`. Use `{{< slide ... >}}` for per-slide options.
- Include code from `pss-code` with `{{% import-raw path="pss-code/..." %}}` inside a fenced code block.
  Prefer this over pasting code into the slides.
- Main menu entries in `content/_index.md`:
  `* [<i class="fa-solid fa-ICON"></i> N. Title](alias/)`, inside a `{{% menu-group title="..." icon="..." %}}`.
  - Numbers follow the order the lectures are taught in. When you insert a lecture, renumber the following ones.
  - Hide a lecture that is not taught this year with an HTML comment (`<!-- ... -->`). Do not delete it.
  - Icons come from Font Awesome (`fa-solid` / `fa-brands`).
- Mark decks under construction with 🚧 in the title.

## CI / deployment

On every push, `.github/workflows/markdown-slides.yml` does the following:

1. Runs `preprocess.rb`.
2. Builds with Hugo.
3. Inlines Mermaid.
4. Deploys to the `gh-pages` branch of `unibo-lptsi-pss/unibo-lptsi-pss.github.io`.

Printable PDFs are then generated and attached to the releases.
Renovate keeps action versions up to date; do not bump them by hand.

## Commits

- Use conventional-commit style when it fits (`feat:`, `fix:`, `chore:`, `ci(deps):`).
- Do not commit `build/`, `public/`, or generated `_index.md` files.
