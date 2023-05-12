function fetchPosts(reqMethod = '', data = {}, id = '') {
    const url = `/api/v1/posts${id}`;
    const param = JSON.stringify(Object.fromEntries(data));
    alert(param);
    fetch(url, {
        method: reqMethod,
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