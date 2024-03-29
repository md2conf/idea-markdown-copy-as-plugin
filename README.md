# idea-markdown-copy-as-plugin

![Build](https://github.com/md2conf/idea-markdown-copy-as-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/20487)](https://plugins.jetbrains.com/plugin/20487)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/20487)](https://plugins.jetbrains.com/plugin/20487)

<!-- Plugin description -->
Copy **Markdown** as **JIRA** formatted text or as **HTML** formatted text.

- The plugin provides additional editor context action available in markdown context. 
- Copy as **HTML** formatted text action useful for pasting rendered markdown into e-mails or word processor
  applications.
- Copy as **JIRA** formatted text action useful for pasting text to descriptions/comments of Jira issues.
- Conversion performed using [flexmark](https://github.com/vsch/flexmark-java) library.
- The idea taken from [markdown-navigator-enhanced](https://plugins.jetbrains.com/plugin/7896) which is not compatible
  with recent versions of IDEA since 2021.2.

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  idea-markdown-copy-as-plugin"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/md2conf/idea-markdown-copy-as-plugin/releases/latest) and install it
  manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
