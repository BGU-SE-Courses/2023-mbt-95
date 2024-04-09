/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'https://sandbox.moodledemo.net/';

const xpaths = {
  welcomeWindow: {
    moveToLoginWindow: '//*[@id="usernavigation"]/div[5]/div[1]/span[1]/a[1]',
  },

  loginWindow: {
    username: '//*[@id="username"]',
    password: '//*[@id="password"]',
    loginButton: '//*[@id="loginbtn"]'
  },
  mainWindow: {
    courseButton: '//a[text()="My first course"]'
  },
  AnnoWindow: {
    myCoursesButton:'//*[@id="moremenu-661520cef1940-navbar-nav"]/li[3]/a[1]',
    courseButton: '//a[text()="My first course"]',
    NewsForum: '//*[@id="module-1"]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]'

  },


}