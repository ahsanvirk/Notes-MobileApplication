# How I worked on this project

###  This was a project in my Mobile Application class where the assignment was to build an application that takes advantage of the SQLite library to set up a database system to keep track of all the notes that are added by the user. However, the catch was that there must be two different fragments so I made the first fragment the location where the user types the note and has the option to delete the most recent entry. While the second fragment underneath it is the location where the added note is shown. Another instruction to keep note of was to use any Jetpack feature such as a ViewModel or LiveData.

# How to navigate this project

### Fully built and customized in Android Studio, the front-end and back-end are divided into two sections. While the front-end is all coded in XML and found under the res folder, the back-end consists of different files such as appWidget1, MainActivity, Stacks, etc., found in the java folder. 

# Why I built the project this way

### Due to the way Android Studio is set, it is very easy to differentiate front-end files from back-end files because of the automatic locations each one is saved to (backend java folder and frontend in res folder). Besides, that it was more logical to divide each of the two fragments and each of the two widgets into two different files so they are easier to access and navigate. All this, along with the DatabaseHelper, stacks, and MainActivity classes all being isolated into separate files for best optimization practices and effective and neat code reading.

# If I had more time I would change this

### Since this is a note taking application, there's only so much I can do in terms of the backend database management, where I would want to transform it into an application like Apple's Notes, where you can save each note with it's own sub-headings and texts with the option to go back and edit them in any order without any Stack(First In Last Out) restraints. Also, I would want to give more creative control to the user where they can not only make text notes but also have the ability to draw with a pencil/pen like many other note taking applications do nowadays.