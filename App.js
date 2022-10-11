// import logo from './logo.svg';
// import './App.css';
// import './style.css'

import React, { useState } from "react";
import HorizontalTimeline from "react-horizontal-timeline";
import "./App.css";

function App() {
  const [value, setValue] = useState(0);
  const [previous, setPrevious] = useState(0);
  
  // Values should be only date
  const VALUES = ["2021-01-01", "2021-01-15", "2021-03-22"];
  
  // Description array corresponding to values
  const description = [
    "The event of 1 Jan 2021 : Happy New Year",
    "The event of 15 Jan 2021 : Festival",
    "The event of 22 March 2021 : Board Exam",
  ];
  return (

    <div className="root-div">
      <div style={{ width: "60%",
                    height: "100px", 
                    margin: "0 auto" }}>
        <HorizontalTimeline
          styles={{ outline: "#DFA867", foreground: "#19295C" }}
          index={value}
          indexClick={(index) => {
            setValue(index);
            setPrevious(value);
          }}
          values={VALUES}
        />
      </div>
      <div className="text-center">{description[value]}</div>
    </div>

    
    // <div className="App">
    //   <nav id="navbar">
    //     <ul>
    //         <li><a href="#">myTunes</a></li>
    //         <li><a href="#showcase">Overview</a></li>
    //         <li><a href="#music">Music</a></li>
    //         <li><a href="#videos">Videos</a></li>
    //         <li><a href="#giftcards">Gift Cards</a></li>
    //     </ul>
    // </nav>

    // <div id="showcase" class="showcase">
    //     <div class="container">
    //         <div class="main-content">
    //             <h1>my<span>Tunes.</span></h1>
    //             <h2>Your music, movies, and TV shows take center stage.</h2>
    //             <p class="lead">myTunes is the best way to organize and enjoy the music, movies, and TV shows you
    //                 already have — and shop for the ones you want. Enjoy all the entertainment myTunes has to offer on
    //                 your Mac and PC.</p>
    //         </div>
    //     </div>
    // </div>

    // <div id="music" class="music">
    //     <div class="container">
    //         <div class="music-content">
    //             <h1>Music</h1>
    //             <h2>45 million songs. Zero ads.</h2>
    //             <p class="lead">Stream over 45 million songs, ad-free. Or download albums and tracks to listen to
    //                 offline. All the music in your personal myTunes library — no matter where it came from — lives right
    //                 alongside the Orange Music catalog. Start your free three-month trial with no commitment, and cancel
    //                 anytime.</p>
    //             <button class="btn">Start Your Free Trial</button>
    //             <p>Orange Music is available in myTunes, and for iOS and Android devices.</p>
    //             {/* <img src="images/undraw_progressive_app_m-9-ms.svg" alt=""> */}
    //         </div>
    //     </div>
    // </div>

    // <div id="videos" class="videos">
    //     <div class="container">
    //         <div class="videos-content">
    //             <h1>The movie and TV collection you always wished for. Granted.</h1>
    //             <p class="lead">With over 100,000 movies and TV shows to choose from, there’s always something great to
    //                 watch on myTunes and if you watch on Orange TV 4K, you’ll be able to enjoy a tremendous selection of
    //                 your favorite content in 4K HDR. So get ready to enjoy episodes of your favorite TV shows or hit
    //                 movies you’ve been waiting to see — anytime, anywhere. Just tap to play, or even download if you’re
    //                 going somewhere you won’t have Wi-Fi.</p>
    //             <button class="btn">Read More</button>
    //             {/* <img src="https://i.postimg.cc/763XvZQN/roberto-nickson-h-Lg-Yt-X0r-Pgw-unsplash.jpg" alt=""> */}
    //         </div>
    //     </div>
    // </div>

    // <section id="entertain">
    //     <div class="container">
    //         <h2>A world of entertainment. Available wherever you are.</h2>
    //         <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem veniam nobis, nisi ut
    //             expedita, doloribus reprehenderit explicabo non velit repellat alias saepe inventore repellendus?
    //             Molestias suscipit eos tempora? Quae quaerat cumque in veritatis impedit dolorum sapiente recusandae
    //             minima quo aperiam quam, excepturi quasi totam ad quas? Ipsam laudantium soluta delectus!</p>
    //         {/* <img src="https://i.postimg.cc/XJZK3c73/tijs-van-leur-Qnlp3-FCO2vc-unsplash.jpg" alt=""> */}
    //     </div>
    // </section>

    // <section id="giftcards">
    //     <div class="container">
    //         <div class="gift-content">
    //             <div>
    //                 {/* <img src="https://i.postimg.cc/T2QY8gxh/MockUp1.png" alt=""> */}
    //             </div>
    //             <div>
    //                 <h2>Gift Cards</h2>
    //                 <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Neque expedita tempore quasi omnis a
    //                     aut et totam illo fuga accusamus dolorum vero, ut harum consectetur. Minima molestias officiis
    //                     culpa non sed dicta itaque. Et aliquam illo obcaecati molestias veritatis porro.</p>
    //                 <p>Already have an Orange MyTunes Music Gift Card?</p>
    //                 {/* <hr> */}
    //                 <a href="#">
    //                     <i class="fa-solid fa-chevron-right"></i> Redeem

    //                 </a>
    //             </div>
    //         </div>
    //     </div>
    // </section>

    // <footer>
    //     <div class="container">
    //         <div class="footer-links">
    //             <ul>
    //                 <li>Shop and Learn</li>
    //                 <li><a href="">Music</a></li>
    //                 <li><a href="">Movies</a></li>
    //                 <li><a href="">Shows</a></li>
    //                 <li><a href="">Apps</a></li>
    //                 <li><a href="">Gift cards</a></li>
    //             </ul>
    //             <ul>
    //                 <li>Orange Store</li>
    //                 <li><a href="">Find a Store</a></li>
    //                 <li><a href="">Today at orange</a></li>
    //                 <li><a href="">Orange camp</a></li>
    //                 <li><a href="">Financing</a></li>
    //                 <li><a href="">Order Staus</a></li>
    //             </ul>
    //             <ul>
    //                 <li>Education and Business</li>
    //                 {/* <li><a href="">Orange & Education</a></li> */}
    //                 <li><a href="">Shop for College</a></li>
    //                 <li><a href="">Shop for Business</a></li>
    //                 <li><a href="">Apps</a></li>
    //                 <li><a href="">Jobs</a></li>
    //             </ul>
    //             <ul>
    //                 <li>About myTunes</li>
    //                 <li><a href="">Newdroom</a></li>
    //                 <li><a href="">Investors</a></li>
    //                 <li><a href="">Leadership</a></li>
    //                 <li><a href="">Events</a></li>
    //                 <li><a href="">Contact</a></li>
    //             </ul>
    //         </div>
    //     </div>

    //     <div class="footer-bottom">
    //         Copyright &copy; 2018 Orange myTunes
    //     </div>
    // </footer>
    // </div>
  );
}

export default App;
