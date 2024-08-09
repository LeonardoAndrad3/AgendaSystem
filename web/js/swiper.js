const swiper = new Swiper('.swiper',{

    slidesPerView: 1,
    spaceBetween: 10,

    pagination: {
        el: '.swiper-pagination',
        type: 'bullets',
      },

      grid:{
        rows:4
      },

      a11y: {
        prevSlideMessage: 'Previous slide',
        nextSlideMessage: 'Next slide',
      },

    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
})