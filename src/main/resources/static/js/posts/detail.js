const postId = document.getElementById("id").innerText;
const deleteBtn = document.getElementById("btn-delete");

deleteBtn.addEventListener("click", () => { fetchPosts("DELETE", {}, `/${postId}`); });