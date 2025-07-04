// Theme Toggle Script
document.addEventListener("DOMContentLoaded", () => {
    const toggle = document.getElementById("themeToggle");
    const icon = toggle.querySelector("i");
    const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;

    // Load from localStorage or use system preference
    if (localStorage.getItem("theme") === "dark" || (!localStorage.getItem("theme") && prefersDark)) {
        document.body.classList.add("dark-mode");
        icon.classList.remove("fa-sun");
        icon.classList.add("fa-moon");
    }

    toggle.addEventListener("click", () => {
        document.body.classList.toggle("dark-mode");
        const isDark = document.body.classList.contains("dark-mode");

        // Animate icon
        icon.classList.add("fade-out");
        setTimeout(() => {
            icon.classList.toggle("fa-sun", !isDark);
            icon.classList.toggle("fa-moon", isDark);
            icon.classList.remove("fade-out");
        }, 200);

        // Save preference
        localStorage.setItem("theme", isDark ? "dark" : "light");
    });
});