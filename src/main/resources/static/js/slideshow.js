// Add this to main.js or register-specific JS

document.addEventListener('DOMContentLoaded', function () {
    const slides = document.querySelectorAll('.slideshow-background img');
    let current = 0;

    function nextSlide() {
        slides[current].classList.remove('active');
        current = (current + 1) % slides.length;
        slides[current].classList.add('active');
    }

    slides[current].classList.add('active');
    setInterval(nextSlide, 5000); // Change every 5 seconds
});