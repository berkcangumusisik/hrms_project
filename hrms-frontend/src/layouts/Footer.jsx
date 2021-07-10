import React from "react";

export default function Footer() {
    return (
      <>
      <div className="relative bg-purple-200 pt-8 pb-7 w-1/5">
      <footer className="relative bg-purple-200 pt-7 pb-8">
        <div
          className="bottom-auto top-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden -mt-20 h-20"
          style={{ transform: "translateZ(0)" }}
        >
          <svg
            className="absolute bottom-0 overflow-hidden"
            xmlns="http://www.w3.org/2000/svg"
            preserveAspectRatio="none"
            version="1.1"
            viewBox="0 0 2560 100"
            x="0"
            y="0"
          >

          </svg>
        </div>
        <div className="container mx-auto px-4">
          <div className="flex flex-wrap text-center lg:text-left">
            <div className="w-full lg:w-6/12 px-4">
              <h4 className="text-3xl font-semibold">İnsan Kaynakları Bilgi Sistemi</h4>
              <h5 className="text-lg mt-0 mb-2 text-blueGray-600">
                Bu proje Berkcan Gümüşışık tarafından Engin Demiroğ'un hazırlamış olduğu Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT) kapsamında hazırlanmıştır.
              </h5>
              <div className="mt-6 lg:mb-0 mb-6">
                <button
                  className="bg-white text-gray-400 shadow-lg font-normal h-10 w-10 items-center justify-center align-center rounded-full outline-none focus:outline-none mr-2"
                  type="button"
                >
                  <a  href="https://github.com/berkcangumusisik">
                  <i className="fab fa-github"></i>
                  </a>
                </button>
                <button
                  className="bg-white text-lightBlue-600 shadow-lg font-normal h-10 w-10 items-center justify-center align-center rounded-full outline-none focus:outline-none mr-2"
                  type="button"
                >
                  <a href="https://tr.linkedin.com/in/berkcan-g%C3%BCm%C3%BC%C5%9F%C4%B1%C5%9F%C4%B1k-20452b199">
                  <i className="fab fa-linkedin"></i>
                  </a>
                </button>
                <button
                  className="bg-white text-pink-400 shadow-lg font-normal h-10 w-10 items-center justify-center align-center rounded-full outline-none focus:outline-none mr-2"
                  type="button"
                >
                  <a href="https://www.instagram.com/berkcangumusisik/">
                  <i className="fab fa-instagram"></i>
                  </a>
                </button>
                <button
                  className="bg-white text-pink-400 shadow-lg font-normal h-10 w-10 items-center justify-center align-center rounded-full outline-none focus:outline-none mr-2"
                  type="button"
                >
                  <a href="https://www.youtube.com/c/TeknolojiSepeti/videos">
                  <i className="fab fa-youtube"></i>
                  </a>
                  
                </button>
              </div>
            </div>
            <div className="w-full lg:w-6/12 px-4">
              <div className="flex flex-wrap items-top mb-6">
                <div className="w-full lg:w-4/12 px-4 ml-auto">
                  <span className="block uppercase text-blueGray-500 text-sm font-semibold mb-2">
                    SİTE HARİTASI
                  </span>
                  <ul className="list-unstyled">
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/"
                      >
                        Ana Sayfa
                      </a>
                    </li>
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/jobAdvertisements"
                      >
                        İş İlanları
                      </a>
                    </li>
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/cv"
                      >
                        CV
                      </a>
                    </li>
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/career"
                      >
                        Kariyer Tavsiyeleri
                      </a>
                    </li>
                  </ul>
                </div>
                <div className="w-full lg:w-4/12 px-4">
                  <span className="block uppercase text-blueGray-500 text-sm font-semibold mb-2">
                    DİĞER
                  </span>
                  <ul className="list-unstyled">
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/about"
                      >
                        Hakkımızda
                      </a>
                    </li>
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="/contact"
                      >
                        İletişim
                      </a>
                    </li>
                    <li>
                      <a
                        className="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm"
                        href="https://www.kodlama.io/courses/"
                      >
                        Kodlama.io
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <hr className="my-6 border-blueGray-300" />
          <div className="flex flex-wrap items-center md:justify-between justify-center">
            <div className="w-full md:w-4/12 px-4 mx-auto text-center">
              <div className="text-sm text-blueGray-500 font-semibold py-1">
                <h4>Copyright © {new Date().getFullYear()} 
                <br/>Berkcan Gümüşışık
                </h4>
              </div>
            </div>
          </div>
        </div>
      </footer>
      </div>
    </>
  );
}
