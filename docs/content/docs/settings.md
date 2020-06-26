---
description: ''
sidebar: 'docs'
prev: '/docs/deploying/'
next: '/docs/sidebar/'
---

# Settings

When creating your markdown files, there is some configuration to do, if we want to utilise all features of this starter theme.

## Sidebar

The sidebar, unfortunately, is not generated automatically but rather configured in your frontmatter and the `gridsome.config.file`.
Check out the [sidebar](/docs/sidebar/) section for more information.

## Next and Previous Navigation

If you scroll to the bottom of the page, you will notice some buttons which link to the previous pages in these docs. These are also not automatically generated but configured in the frontmatter of your markdown file like this:

```md
prev: '/docs/previous-link/'
next: '/docs/next-link/'
```

Just like the sidebar, you only need to specify the link to the page and the title will be fetched via a graphql query.

## Navigation

The standard navigation on the top left is defined in the `gridsome.config.js` file. The configuration is very simple. It just needs a `settings > nav` property which takes a `links` property that defines every link that should be displayed at the top.

```js
module.exports = {
  settings: {
    nav: {
      links: [
        { path: '/docs/', title: 'Docs' }
      ]
    },
  }
}
```

Each link item needs a `path` and a `title` for the link.

## Description

The description of each page goes to the frontmatter of said page. It is an optional value but is recommended since this value is used to fill some meta properties of your page.

```md
---
description: 'your description'
---
```

## Social Links

At the top of the page, you can see some icons which link to Twitter/GitHub or personal website. These links are also defined in your `gridsome.config.js` like this:

```js

module.exports = {
  settings: {
    web: process.env.URL_WEB,
    twitter: process.env.URL_TWITTER,
    github: process.env.URL_GITHUB,
  }
```

By default these are defined in your `.env` file but can be hardcoded if you want to.

## On this Page

On the right side of the page is an overview of every headline of the current viewed page. Fortunately this list is auto-generated and you don't need to do anything.

## Google Analytics

Google Analytics is integrated via the `@gridsome/plugin-google-analytics` plugin. It needs your tracking id in order to work correctly, which can also be defined via `.env` file or hardcoded as needed.

If you don't want to use Google Analytics, simply delete this entry from your `plugins`.

Read more [here](https://gridsome.org/plugins/@gridsome/plugin-google-analytics).

```js
// ...
{
  use: '@gridsome/plugin-google-analytics',
  options: {
    id: (process.env.GA_ID ? process.env.GA_ID : 'XX-999999999-9')
  }
}
// ...
```