function toggleBookmark() {
    var bookmarkIcon = document.getElementById('bookmark-icon');
    var currentSrc = bookmarkIcon.src;

    var bookmarkSrc = currentSrc.replace('bookmark_filled.png', 'bookmark.png');
    var bookmarkFilledSrc = currentSrc.replace('bookmark.png', 'bookmark_filled.png');

    if (currentSrc.includes('bookmark.png')) {
        bookmarkIcon.src = bookmarkFilledSrc;
    } else {
        bookmarkIcon.src = bookmarkSrc;
    }
}

function toggleDetails(id) {
    var content = document.getElementById(id);
    var icon = document.getElementById(id + '-icon');

    // 현재 아이콘의 경로 가져오기
    var currentSrc = icon.src;

    // 경로에서 파일 이름만 교체
    var upIconSrc = currentSrc.replace('Chevrondown.png', 'Chevronup.png');
    var downIconSrc = currentSrc.replace('Chevronup.png', 'Chevrondown.png');

    // 토글 동작 수행
    if (content.style.display === "none" || content.style.display === "") {
        content.style.display = "block";
        icon.src = upIconSrc;
    } else {
        content.style.display = "none";
        icon.src = downIconSrc;
    }
}


