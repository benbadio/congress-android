Setup
-----

When setting this up, make sure to copy keys.xml.example to res/values/keys.xml and fill in your [Sunlight API](http://services.sunlightlabs.com) key and [Google Search API key](http://code.google.com/apis/loader/signup.html) for use in the [Google Search News API](http://code.google.com/apis/newssearch/v1/jsondevguide.html).


Issue Tracking
------

Use the [Github Issues page](http://github.com/sunlightlabs/congress/issues) for this project.


Release Checklist
-----------------

Code changes:

* Bump the android:versionCode and android:versionName in AndroidManifest.xml
* Bump the android:app_version in strings.xml to match android:versionName
* Change the android:app_version_older in strings.xml to what's appropriate
* Update the changelog data in arrays.xml to what's appropriate
* Commit changes, add tag in git for version "vX.X.X" where X.X.X is the android:versionName

Then, release work:

* Check keys.xml:
  * is api_endpoint pointing to production?
  * is the distribution_channel correct? (market vs ____)
  * is the market_channel correct? (google vs amazon)
  * are all debug flags set to false?
* Produce unsigned APK version
* Produce signed APK version
* Take any screenshots needed to replace outdated ones
  * Replace any new screenshots in Sunlight S3, Dropbox
* Store APKs in Dropbox

Finally, publish.
