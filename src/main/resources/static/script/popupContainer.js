document.getElementById('showPopupBtn').addEventListener('click', function () {
    document.getElementById('popupContainer').style.display = 'flex';
});

document.getElementById('popupContainer').addEventListener('click', function (event) {
    if (event.target === this) {
        document.getElementById('popupContainer').style.display = 'none';
    }
});
