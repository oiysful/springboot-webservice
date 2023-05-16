const userIcon = document.getElementById("user-icon");
const userInfoModal = document.getElementById("user-info-modal");

userIcon.addEventListener("mouseenter", () => {
    userIcon.classList.add("hidden");
    userInfoModal.classList.remove("hidden");
    userInfoModal.classList.add("show-user-info-modal");
});

userInfoModal.addEventListener("mouseleave", () => {
    userIcon.classList.remove("hidden");
    userInfoModal.classList.add("hidden");
    userInfoModal.classList.remove("show-user-info-modal");
})