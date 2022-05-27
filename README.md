# APRO\_22L\_PRO\_PT\_Edytor\_obrazow
A simple, yet working Image Editor written in Java as a part of APRO2 classes on Warsaw University of Technology.

![Screenshot of this app](https://i.imgur.com/DcFlH3L.png)

## Key Features
- written in Java
[//]: # - simple image editing
[//]: # - more advanced image effects
- works on Linux and Windows

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

## Roadmap
TBA

## Directory & file structure
```
.gitignore
build.bat
build.sh
clean.bat
clean.sh
README.md
run.bat
run.sh

src
└───main
    └───java
        │   MANIFEST.mf
        │
        └───com
            └───editor
                ├───core
                │       EditorRuntime.java
                │       RGBA.java
                │       Settings.java
                │
                ├───effects
                │       Blackout.java
                │       Effect.java
                │
                ├───history
                │       Command.java
                │       EditImageCommand.java
                │       History.java
                │       Memento.java
                │
                ├───image
                │       Image.java
                │       Layer.java
                │       Workspace.java
                │
                ├───tools
                │       Pen.java
                │       Shift.java
                │       Tool.java
                │       Zoom.java
                │
                └───window
                    │   Entry.java
                    │   MainBar.java
                    │   MainWindow.java
                    │   MainWindowListener.java
                    │   Window.java
                    │
                    ├───edit
                    │       EntryRedo.java
                    │       EntryUndo.java
                    │       MenuEdit.java
                    │
                    ├───effects
                    │       EntryBlackout.java
                    │       MenuEffects.java
                    │
                    ├───file
                    │       EntryExit.java
                    │       EntryNew.java
                    │       EntryOpen.java
                    │       EntrySave.java
                    │       EntrySaveAs.java
                    │       MenuFile.java
                    │
                    └───tools
                            EntryShift.java
                            EntryZoom.java
                            MenuTools.java
```

## License
TBA

