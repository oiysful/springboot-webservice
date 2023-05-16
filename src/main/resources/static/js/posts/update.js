const updateForm = document.getElementById("form-save");
const postId = updateForm.querySelector("#id").value;
const updateBtn = document.getElementById("btn-save");

updateBtn.addEventListener("click", () => { fetchPosts("PUT", new FormData(updateForm), `/${postId}`); });