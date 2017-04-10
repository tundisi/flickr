# Flickr

This application shows the use of the Flickr API without the need to use its SDK.

# Run Project!

To run the project you only have to do the following steps:

  - Clone project.
  - Import project in android studio with sdk compile version + 25.
  - Build project.
  - Run project.
  - Done! :)

### Run Unit Test

Steps to run the unit tests:

* In android studio you must click on run and then edit configurations.
* You must click on Add new configuration (simbol +) and then android test.
* In module select app, and in especific instrumentation runner to write `com.etermax.flickr.mock.MockTestRunner`
* Put the phone in airplane mode
* Run!

### About Flickr

Flickr uses an architecture based on an model view presenter custom (MVP), composed as follows:

> **api**: This folder contains the calls to retrofit and their respective manipulation in the controllers.

> **data**: Contains the retrofit responses and models.

> **di**: Contains all components and modules the dagger.

> **ui**: Contains adapters, dialogs, bases and all views the application.

> **utils**: Contains all utils the application.


### Dependencies used

* [Dagger 2](https://google.github.io/dagger/) - dependency injection framework!
* [Butterknife](http://jakewharton.github.io/butterknife/) - injection views framework!
* [RxJava](https://github.com/ReactiveX/RxJava) - a library for composing asynchronous and event-based.
* [RxAndroid](https://github.com/ReactiveX/RxAndroid) - Reactive Extensions for Android
* [Retrofit 2](http://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
* [Logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - An OkHttp interceptor which logs HTTP request and response data.
* [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework for Android.
* [RxJava Adapter](https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava) - An Adapter for adapting RxJava 1.x types.
* [TabGroup](https://github.com/2dxgujun/AndroidTagGroup) - A beautiful android tag group widget.
* [Mockito](http://site.mockito.org/) - Tasty mocking framework for unit tests in Java.

### Why use model view presenter?

The presenter view model prevents the view from saturating in the waiting for logical responses, dividing the logical layer and the design layer.

### Why inject dependences?

Because to inject a dependency avoids the creation of instances in the classes, avoiding the bad use of memory.

### Why use dagger?

Dagger allows you to inject dependencies throughout the application so that you can reuse instances and avoid creating them every time you need to use them.

### Why use RxJava?

http://blog.feedpresso.com/2016/01/25/why-you-should-use-rxjava-in-android-a-short-introduction-to-rxjava.html
