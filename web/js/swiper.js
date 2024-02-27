const swiper = new Swiper('.swiper',{

    slidesPerView:1,
    spaceBetween: 1,

    pagination: {
        el: '.swiper-pagination',
        type: 'bullets',
      },

      hiden:true,
      a11y: {
        prevSlideMessage: 'Previous slide',
        nextSlideMessage: 'Next slide',
      },

    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
})