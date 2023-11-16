const userIcon = document.getElementById('userIcon');
const loginMenu = document.getElementById('loginMenu');

let menuVisible = false;

userIcon.addEventListener('click', () => {
    if (menuVisible) {
        loginMenu.style.display = 'none';
    } else {
        loginMenu.style.display = 'block';
    }
    menuVisible = !menuVisible;
});