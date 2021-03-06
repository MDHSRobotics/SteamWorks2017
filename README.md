#SteamWorks2017

###Description

This project is intended to be the base project from which this season's Java RoboRio controller project is derived from. All contributions made will be added to this project moving forward. Learn how to push changes in the guide [How to Git](https://github.com/MDHSRobotics/TeamWiki/wiki/How%20to%20Git).

__important__ after cloning your repository make sure that all of the contents of the tools folder of this repository are copied to the C:\Users\<USERNAME>\wpilib\user folder on your local computer, see [3rd Party Libraries screenstepslive article](http://wpilib.screenstepslive.com/s/4485/m/13503/l/682619-3rd-party-libraries) _The Mechanism - Java_ section for more details.


###Features
* Improved Configuration
* MDConsole Support
* Improved Logging
* Core Subsystem
* WebSockets Subsystem
* Diagnostics Subsystem
* Drive Subsystem
* ADIS16448_IMU Gyro Implementation


##Subsystem Info

###Motor Ports for the RoboRIO

| Port Number | Motor      |
|-------------|------------|
|0            |Right Drive |
|1            |Left Drive  |
|2            |Ball Pickup |
|3            |N/A         |
|4            |N/A         |
|5            |N/A         |
|6            |Winch       |
|7            |Shoot       |
|8            |Feed        |
|9            |N/A         |

####Shooter

| Feet from Boiler (Back of shooter) | Power Level Needed |
|------------------------------------|--------------------|
| 11                                 | 50                 |
| 8' 4"                              | 45                 |
| 5                                  | 43                 |

We had the most success with the lower powers. We will work on getting the shooter to be more consistent, probably by making the curve more sticky.

See [Understanding Materbot](https://github.com/MDHSRobotics/TeamWiki/wiki/Understanding%20MaterBot) for more information (current example for future FIRST competitions).

###Backlog
Currently N/A.
