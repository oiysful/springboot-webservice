const updateForm = document.getElementById("form-update");
const postId = updateForm.querySelector("#id").value;
const updateBtn = document.getElementById("btn-update");

updateBtn.addEventListener("click", () => { fetchPosts("PUT", new FormData(updateForm), `/${postId}`); });