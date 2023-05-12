const saveForm = document.getElementById("form-save");
const saveBtn = document.getElementById("btn-save");

saveBtn.addEventListener("click", () => { fetchPosts("POST", new FormData(saveForm)); });