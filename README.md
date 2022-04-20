# WrapContentTabLayout

[![](https://jitpack.io/v/Josh-Owen/Wrap-Content-TabLayout.svg)](https://jitpack.io/#Josh-Owen/Wrap-Content-TabLayout)

WrapContentTabLayout is a short and simple library used to solve the novel problem
of wrapping individual tab items or entire [TabLayout's](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout)
in Native Android allowing for the creation of similar layouts present in popular applications such as WhatsApp e.g.

![](images/tablayout_image.jpg)

## Getting started

### Download

For detailed instructions please check out the official [Jitpack documentation](https://jitpack.io/#Josh-Owen/Wrap-Content-TabLayout/Tag).

Additionally you can download the project from the Github's [release's page](https://github.com/Josh-Owen/Wrap-Content-TabLayout/releases).

Or use Gradle:

```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    implementation 'com.github.Josh-Owen:Wrap-Content-TabLayout:1.0.0'
}
```

Or Maven:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.Josh-Owen</groupId>
    <artifactId>Wrap-Content-TabLayout</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Library Overview

WrapContentTabLayout contains all of the functionality available in the native [TabLayout](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout) widget
with the addition of two additional attributes:

#### wrapSelectedTabs 

This widget attribute accepts an array of integers which can either be located in a projects resource file or via data binding. 

##### XML Layout: 

``app:wrapSelectedTabs="@array/wrappedTabs"``

##### Arrays.XML (Resource File)

```
<integer-array name="wrappedTabs">
        <item>0</item>
</integer-array>
```

Or alternatively use the following referencing your array in your view model:

```app:wrapSelectedTabs="@{viewModel.wrappedTabs}"```

#### wrapAllTabs 

This widget attribute accepts a boolean which can either be declared in the widgets layout or via data binding. 

##### XML Layout: 

 ```app:wrapAllTabs="true```
 
Or alternatively use the following referencing a boolean in your view model:

 ```app:wrapAllTabs="@{viewModel.shouldTabsBeWrapped}```



Note: There are code samples demonstrating both attributes included within the project. 


### Working Code Template (Simply implement your array and replace with your image drawable)

```
<com.google.android.material.appbar.AppBarLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent">

    <com.joshowen.wrap_content_tablayout.WrapContentTabLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:wrapSelectedTabs="@array/homeWrappedTabLayoutItems">

        <com.google.android.material.tabs.TabItem
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:icon="@drawable/ic_camera"/>
            
        <com.google.android.material.tabs.TabItem
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Tab 1"/>
            
        <com.google.android.material.tabs.TabItem
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Tab 2/>
            
        <com.google.android.material.tabs.TabItem
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Tab 3"/>
            
    </com.joshowen.wrap_content_tablayout.WrapContentTabLayout>
</com.google.android.material.appbar.AppBarLayout>
```