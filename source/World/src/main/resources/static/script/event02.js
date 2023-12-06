function slidesPlugin() {
  const slides = document.querySelectorAll(".slide");

  for (const slide of slides) {
    slide.addEventListener("click", () => {
      clearActiveClasses();
      slide.classList.add("active");
    });
  }

  function clearActiveClasses() {
    slides.forEach((slide) => {
      slide.classList.remove("active");
    });
  }
}

// 페이지가 로드되면 slidesPlugin() 함수 호출
window.addEventListener("load", slidesPlugin);