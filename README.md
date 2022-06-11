# SIMP
![](https://img.shields.io/badge/build-passing-brightgreen) ![](https://img.shields.io/badge/version-1.0-brightgreen)
SIMP written in Java as a part of APRO2 classes on Warsaw University of Technology. What stands for **S**imple **I**mage **M**odifying **P**rogram

![Screenshot of this app](https://imgur.com/a/M9jAMo5.png)

## Key Features
- Undo / Redo
- written in Java
- no tutorials, because its dead simple
- cool and advanced image effects
- works (might work) on Linux and Windows

## Go Dark, be EMO

![Dark Theme screenshot](https://imgur.com/a/L16Q4PI.png)

## Live example
On the left side unedited photo, on the right photo after applying few effects
![](https://i.imgur.com/R5jNKZL.png)

## How To Use
To clone and run this application you'll need Git and JVM installed on your computer.
From your command line:
```bash
# Clone this repository
$ git clone https://gitlab-stud.elka.pw.edu.pl/mjurczak/apro_22l_pro_pt_edytor_obrazow.git

# Go into the repository
$ cd apro_22l_pro_pt_edytor_obrazow.git
```
On Linux:
```bash
# Build the app (Linux)
$ ./build.sh

# Run the app (Linux)
$ ./run.sh
```
On Windows:
```batch
:: Build the app (Windows)
C:\> build.bat

:: Run the app (Windows)
C:\> run.bat
```

## Download
You can dowload latest JAR version of Image Editor for Linux and Windows. In order to run them use 
```bash
# Go into the folder where you have dowloaded file 
$ cd ~/Downloads

# Run jar file
$ java -jar Editor.jar
```

## Future plans
- Finish Color Picker implementation
- Simple shapes like lines, rectangles, circles and triangles
- Layer Window (and easy way to change order of layers)
- ToolBox with all available tools
- More keybindings like Ctrl+O to open a file
- Finally learn how to use Java Executable Wrapper

## What we used in this project?
- OpenCV Libray (matrix operations, kernel generating and applying effects)
- Flatlaf (Themes)

## Authors
Matusz Jurczak | Mikołaj Matuszewski | Julia Parobczy

