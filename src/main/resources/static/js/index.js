const loginSection = document.querySelector(".login-section");
const signupModal = document.querySelector(".signup-modal");
const signupBtn = document.querySelector("#sign-up-btn");
const signupCloseBtn = document.querySelector("#close-modal");

function toggleModal() {
    loginSection.classList.toggle("hidden");
    signupModal.classList.toggle("hidden");
}

signupBtn.addEventListener("click", toggleModal);
signupCloseBtn.addEventListener("click", toggleModal);

const signupForm = document.querySelector("#signup-form");

signupForm.addEventListener("submit", e => {
	e.preventDefault();
    const data = new FormData(signupForm);
    const param = JSON.stringify(Object.fromEntries(data));
    fetch('/auth/join', {
        method: 'POST',
        body: param,
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        console.log(response.status);
    })
    .catch(error => console.log(error))
});