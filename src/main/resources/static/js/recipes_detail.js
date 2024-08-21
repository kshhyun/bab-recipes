function toggleBookmark() {
    var bookmarkIcon = document.getElementById('bookmark-icon');
    if (bookmarkIcon.src.includes('bookmark.png')) {
        bookmarkIcon.src = 'images/bookmark_filled.png';
    } else {
        bookmarkIcon.src = 'images/bookmark.png';
    }
}

function toggleDetails(id) {
    var content = document.getElementById(id);
    var icon = document.getElementById(id + '-icon');
    
    if (content.style.display === "none" || content.style.display === "") {
        content.style.display = "block";
        icon.src = 'images/Chevronup.png';
    } else {
        content.style.display = "none";
        icon.src = 'images/Chevrondown.png';
    }
}


