---
description: ''
sidebar: 'docs'
prev: '/docs/settings/'
---

# Sidebar

In order to have a sidebar visible on the side of the page (like on this one for example) or on mobile devices as an off-canvas navigation, you are required to do some global configuration, as well as some configuration per markdown file.

## Global Configuration
Open the `gridsome.config.js`. The configuration for the sidebar is located under `settings > sidebar`.

```js
// gridsome.config.js
module.exports = {
  // ...
  settings: {
    sidebar: []
  },
  // ...
}
```

Please note that the sidebar option is an array, since you can define multiple sidebars for different sections of your website. For example you might have a sidebar for your guide and another one for your Api reference.

### The Sidebar Config Object

A single item in this array needs to have the following properties:
- `name`: The identifier of the sidebar. This will be referenced in your markdown frontmatter.
- `sections`: The sidebar is divided into several sections. On this page we have **Getting Started** and **Configuration**

```js
// gridsome.config.js
module.exports = {
  // ...
  settings: {
    sidebar: [
      name: 'docs',
      sections: []
    ]
  },
  // ...
}
```

An item for the `sections` array might look like this:

```js
// gridsome.config.js
module.exports = {
  // ...
  settings: {
    sidebar: [
      name: 'docs',
      sections: [
        {
          title: 'Getting Started',
          items: [
            '/docs/',
            '/docs/installation/',
            '/docs/writing-content/',
          ]
        },
      ]
    ]
  },
  // ...
}
```

As you can see, we need a `title` for the sections, as well as an array of `items` which are the links to the given pages.

The sidebar performs a static query to get all pages. This is how we automatically put the title of the given page in the sidebar.

## Frontmatter setup

After your global configuration is all done, we only need to tell the markdown page which sidebar to use.

In order to do that we simply reference the `name` of the sidebar in our frontmatter:

```md
---
sidebar: 'docs'
---

# I use the docs sidebar
```