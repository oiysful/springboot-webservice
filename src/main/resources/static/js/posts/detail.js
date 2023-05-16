const postId = document.getElementById("id").value;
const deleteBtn = document.getElementById("btn-delete");

deleteBtn.addEventListener("click", () => { fetchPosts("DELETE", null, `/${postId}`); });