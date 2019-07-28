# nearest_netprint

Python-based project.

When run on command line, prints a list of the nearest netprint-enabled printers offered by Cornell.
  - You can specify type of printer with argvs 'color' or 'bw'.
  - If you do not specify, you will receive lists for both.

Finally, full auto-gps functionality! Your computer will need selenium, and chromedriver if you wish to use chrome. Manual coordinate entry still an option (argv 'manual')

Now has safari (default) and chrome options!

Note that, as not all building hours have yet been inputted, printers suggested to you may be in buildings that are closed.
  - Building hours can typically be manually checked via Google Maps or departmental websites.
  - If anyone knows an API for that, let me know. Or try implementing it yourself.

Note also that, as most of the coordinates were extracted from another API, some of them are likely wrong.
  - Feel free to correct those errors as they arise.
