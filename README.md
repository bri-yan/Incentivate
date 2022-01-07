# Incentivate 💰

## Table Of Contents

* [Project Description](#project-description)
* [Setup](#setup)
* [App Walkthrough](#app-walkthrough)
* [Technologies](#technologies)

## Project Description

We have designed an Android fitness App called Incentivate. The premise of our app is that users can set daily fitness goals that last for however long they want. They could be long term goals that last for a year, or short term goals that last for weeks or even days. For example, a user can commit to walking 5000 steps per day for the next year, or doing 400 pushups across a month. When a user sets a goal, they will also commit a certain amount of money to deposit. Then by completing their goals, the users can slowly earn back their money. This is their incentive to work and meet their goals.  

## Setup

### Prerequisites 

1) [`Java`](https://www.java.com/en/download/manual.jsp) must be installed on your device.
2) [`Gradle`](https://gradle.org/install/) must also be install on your device to install other packages.
3) [`Android Studio`](https://developer.android.com/studio?gclid=Cj0KCQiAw9qOBhC-ARIsAG-rdn4-htjsLqgaXd6EQ5gu3EbhXF43hMPNWXZhxJRfYtXiz8XCLVxx_Z4aAkmqEALw_wcB&gclsrc=aw.ds) is needed to build and run the code.

Then, use Git to clone this respository in Android Studio and run the code.
[`Here`](https://developer.android.com/training/basics/firstapp/running-app) are some instructions to run the code using an emulator, or your own Android Device.

## App Walkthrough

When you first launch the app, you see a log in screen. The user will only see this screen once, when they first open the app. The app will then store the user’s name, email, card number, and expiry date so they can use the app’s features.

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928869209121886218/unknown.png">

Once you log in, you are taken to the main page, where the user can see the progress of their goals and other statistics, such as the number of steps they have taken the past week. What is shown on the screen here is an example of what that could look like.

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928869578224836618/unknown.png">

You can tap the "+" button on the bottom right of the any page or to set a nwe goal and add it to the "Goals" page.

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928883214355951646/unknown.png">

When you do this, you are prompted with a form. Here you can choose all the specifications for your goal such as the number of daily steps you want to take and the duration of your goal. As of this moment, steps is the only activity that can be monitored (using the built in Android phone pedometer), but we plan to include other activities that can be tracked. Some of these activties include distance ran, push-ups, jumping jacks, plank duration, etc. We plan to track exercises such as push-ups using the phone camera and computer vision to verify that the user is truthfully completing their goals.

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928870897975181352/unknown.png">

The last feature is the leaderboard page. Here users can add their friends to their fitness group. By doing this, you may work towards goals together, for a more collaborative experience. Shown on the top of this page, is a weekly event that says the winner of the leaderboard this week will receive $10 from us. This is used to further incentivize users to complete their goals, so they can all stay on track and become healthier together!

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928870091263713290/unknown.png">

## Technologies

* [Java](https://www.java.com/en/)
* [Gradle](https://gradle.org/)
