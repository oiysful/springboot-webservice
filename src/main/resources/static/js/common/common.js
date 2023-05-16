function fetchPosts(reqMethod = '', data = {}, id = '') {
    const url = `/api/v1/posts${id}`;
    let param;
    if(data) param = JSON.stringify(Object.fromEntries(data));
    if(reqMethod.toUpperCase === "DELETE") alert("게시글을 삭제하시겠습니까?")
    fetch(url, {
        method: reqMethod.toUpperCase(),
        body: param,
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.status === 200) {
            location.href = "/posts";
        } else {
            alert("ERR CODE: " + response.status);
        }
    })
    .catch(error => alert(error));
};