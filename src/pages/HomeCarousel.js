import React from 'react';
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import './style.css'

    const photos = [
        {name: 'Movie 1', url: "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/1/b/1bd4e194444eb910e05f_1_.jpg", alt: "Movie 1"},
        {name: 'Movie 2', url: "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/r/e/relic-poster_1_.jpg", alt: "Movie 2"},
        {name: 'Movie 3', url: "https://www.cgv.vn/media/catalog/product/cache/3/image/c5f0a1eff4c394a251036189ccddaacd/z/_/z_main-poster_bcvh.jpg", alt: "Movie 3"},
        {name: 'Movie 4', url: "https://www.cgv.vn/media/catalog/product/cache/3/image/c5f0a1eff4c394a251036189ccddaacd/r/s/rsz_phim-scoob-2020_2.jpg", alt: "Movie 4"},
        {name: 'Movie 5', url: "https://www.cgv.vn/media/catalog/product/cache/3/image/c5f0a1eff4c394a251036189ccddaacd/r/s/rsz_pee_nak2_main_poster_2.jpg", alt: "Movie 5"},
    ]

class HomeCarousel extends React.Component {
    render() {
        const settings = {
            centerMode: true,
            dots: true,
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 3000,
            pauseOnHover: true
        };
        return (
            <div className="slides">
            <Slider {...settings}>
                {photos.map((photo) => {
                    return(
                    <div>
                        <img width="500px" height="700px" src={photo.url}/>
                    </div>
                    )
                })}
            </Slider>
            </div>
        )
    }
}

export default HomeCarousel