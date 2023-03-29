$(".schedule-carousel").slick({
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3500,
    dots: true,
    prevArrow: `<button type='button' class='slick-prev pull-left'><i style = "font-size : 20px; color : white" class="fas fa-angle-double-left"></i></button>`,
    nextArrow: `<button type='button' class='slick-next pull-right'><i style = "font-size : 20px; color : white" class="fas fa-angle-double-right"></i></button>`,
    responsive: [
        {
            breakpoint: 1024,
            settings: {
                slidesToShow: 2,
                slidesToScroll: 1,
                infinite: true,
                arrows: false,
            },
        },
        {
            breakpoint: 768,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1,
                infinite: true,
                arrows: false,
            },
        },
        {
            breakpoint: 480,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1,
                infinite: true,
                arrows: false,
            },
        },
    ],
});