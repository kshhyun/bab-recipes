document.addEventListener('DOMContentLoaded', () => {
    // DOM객체 -> 태그 입력 값 및 태그 가져오는 곳
    const fridgeInput = document.getElementById('fridge-items');
    const excludeInput = document.getElementById('exclude-items');
    const fridgeTagsContainer = document.querySelector('.fridge-tags');
    const excludeTagsContainer = document.querySelector('.exclude-tags');
    const searchButton = document.querySelector('.search-button');

    //태그를 저장할 set객체 생성
    const fridgeTags = new Set();
    const excludeTags = new Set();

    // 태그 요소를 생성하는 함수
    function createTagElement(tag, container, tagsSet) {
        const tagElement = document.createElement('div');
        tagElement.classList.add('tag');
        tagElement.textContent = tag;

        // 태그의 닫기 버튼 생성
        const closeElement = document.createElement('span');
        closeElement.classList.add('close');
        closeElement.textContent = '×';

        // 닫기 버튼 클릭 시 태그 삭제 이벤트 설정
        closeElement.addEventListener('click', () => {
            container.removeChild(tagElement);
            tagsSet.delete(tag);
        });

        tagElement.appendChild(closeElement);
        container.appendChild(tagElement);
    }

    // 냉장고 속 재료 입력 시 태그 추가
    fridgeInput.addEventListener('keydown', (event) => {//사용자가 키보드를 입력했을때 이벤트 발생
        if (event.key === 'Enter' && fridgeInput.value.trim() !== '') { //Enter키를 눌렀고, 입력필드가 공백이 아닌경우
            const tag = fridgeInput.value.trim(); //입력 값을 가져옴.
            if (!fridgeTags.has(tag)) {
                fridgeTags.add(tag); //기존에 중복되는 태그가 없는경우 set객체에 태그 추가.
                createTagElement(tag, fridgeTagsContainer, fridgeTags);
            }
            fridgeInput.value = ''; //완료 후 입력필드 초기화.
        }
    });

    // 못 먹는 재료 입력 시 태그 추가
    excludeInput.addEventListener('keydown', (event) => {
        if (event.key === 'Enter' && excludeInput.value.trim() !== '') {
            const tag = excludeInput.value.trim();
            if (!excludeTags.has(tag)) {
                excludeTags.add(tag);
                createTagElement(tag, excludeTagsContainer, excludeTags);
            }
            excludeInput.value = '';
        }
    });

    //태그 전송
    function sendTags(){
        const fridgeItems = Array.from(fridgeTags);
        const excludedItems = Array.from(excludeTags);

        fetch('/search', {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({fridgeItems,excludedItems}), //tag 전송
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success: ', data);
            })
            .catch((error) => {
                console.error('Error: ', error)
            });
    }

    //전송
    searchButton.addEventListener('click', () =>{
        sendTags();
    });

});
