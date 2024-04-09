

/**
 * Login as a student
 * @param session
 */
function loginAsStudent(session) {
  sync({request : Event("start(loginAsStudent)")})
  with (session) {
    click(xpaths.welcomeWindow.moveToLoginWindow);
    session.writeText(xpaths.loginWindow.username, "student")
    session.writeText(xpaths.loginWindow.password, "sandbox")
    click(xpaths.loginWindow.loginButton)
  }
  sync({request: Event("end(loginAsStudent)",  session.name)})
}

/**
 * Login as a teacher
 */

function loginAsTeacher(session) {
  sync({request : Event("start(loginAsTeacher)")})
  with (session) {
    click(xpaths.welcomeWindow.moveToLoginWindow);
    session.writeText(xpaths.loginWindow.username, "teacher")
    session.writeText(xpaths.loginWindow.password, "sandbox")
    click(xpaths.loginWindow.loginButton)
  }
  sync({request: Event("end(loginAsTeacher)",  session.name)})
}

/**
 * Enter a course from the main window
 */
function enterCourse(session) {
  sync({request : Event("start(enterCourseTeacher)")})
  with (session) {
    click(xpaths.mainWindow.courseButton)
  }
  sync({request: Event("end(enterCourseTeacher)",  session.name)})
}

/**
 * Enter to messages page from course page
 */
function enterAnno(session) {
  sync({request : Event("start(enterToAnno)")})
  with(session) {
    click(xpaths.courseWindow.startButton)
  }
  sync({request: Event("end(enterToAnno)",  session.name)})
}


/**
 * Enter to Middle message
 */
function enterMidAnno(session) {
  sync({request : Event("start(enterToMidAnno)")})
  with(session) {
    click(xpaths.courseWindow.startButton)
  }
  sync({request: Event("end(enterToMidAnno)",  session.name)})
}
/**
 * Enter to first annotation
 */
function enterfirstAnno(session) {
  sync({request : Event("start(enterfirstAnno)")})
  with(session) {
    click(xpaths.AnnoWindow.NewsForum)
  }
  sync({request: Event("end(enterfirstAnno)",  session.name)})
}
/**
 * Delete previous message
 */
function DeletePrevAnno(session) {
  sync({request : Event("start(DeletePreviousAnno)")})
  with(session) {
    click(xpaths.AnnoWindow.myCoursesButton)
    click(xpaths.AnnoWindow.courseButton)
    click(xpaths.AnnoWindow.NewsForum)

  }
  sync({request: Event("end(DeletePreviousAnno)",  session.name)})
}
/**
 * Move From Welcome Window to the User Login Window
 */
function welcomeWindowToLoginWindow(session) {
  sync({request : Event("start(welcomeWindowToLoginWindow)")})
  with (session) {
    click(xpaths.welcomeWindow.moveToLoginWindow);
  }
  sync({request: Event("end(welcomeWindowToLoginWindow)", session.name)})
}

