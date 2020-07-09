# Documentation page 'How To'

Main documentation page is based on Jekyll, static page generator. 

### Local development

In order to run it locally you need to go to a folder `page` and run the command:

```bash
$ bundle exec jekyll serve

Configuration file: .../library-hexagonal/docs/page/_config.yml
            Source: .../library-hexagonal/docs/page
       Destination: .../library-hexagonal/docs/page/_site
 Incremental build: disabled. Enable with --incremental
      Generating...
                    done in 3.431 seconds.
  Please add the following to your Gemfile to avoid polling for changes:
    gem 'wdm', '>= 0.1.0' if Gem.win_platform?
 Auto-regeneration: enabled for '.../library-hexagonal/docs/page'
    Server address: http://127.0.0.1:4000
  Server running... press ctrl-c to stop.
```

In order to make it work, you need to have installed Jekyll CLI, instructions could be found on [the official website](https://jekyllrb.com/docs/installation/#requirements).

And the page will be available under http://localhost:4000 address.

