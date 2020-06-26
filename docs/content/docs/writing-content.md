---
description: ''
sidebar: 'docs'
prev: '/docs/installation/'
next: '/docs/settings/'
---

# Writing Content

After installing, head to `content/docs`. This is where all the documentation for this theme is located.
You can look into it if you want, to get a sense, of how this theme works but generally the first action you take, is to delete that folder and create your own content.

## Writing Markdown

This theme uses the default `@gridsome/source-filesystem` plugin to look for `.md` files in the `content` folder to create pages. If you want to rename the folder, simply open the `gridsome.config.js`, navigate to the options of the plugin and change the `baseDir` option.

```js
plugins: [
  {
    use: '@gridsome/source-filesystem',
    options: {
      // Change the option below.
      baseDir: './content',
      path: '**/*.md',
      typeName: 'MarkdownPage',
      remark: {
        externalLinksTarget: '_blank',
        externalLinksRel: ['noopener', 'noreferrer'],
        plugins: [
          '@gridsome/remark-prismjs'
        ]
      }
    }
  },
  // ...
]
```

If you have never worked with markdown, just search the internet for a guide. It is very simple to pick up.
