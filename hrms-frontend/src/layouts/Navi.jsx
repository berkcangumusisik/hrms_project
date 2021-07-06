import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom';
import {Image} from "semantic-ui-react";
import Login from './Login';
import Logout from './Logout';
import  img  from "../assets/img/hrms_logo.png";
import "../css/Navi.css";


export default function Navi() {

    const [isAuthenticated, setIsAuthenticated] = useState(false)

    const history = useHistory()

    function handleSingOut() {
        setIsAuthenticated(false)
        history.push("/home")

    }
    function handleSingIn() {
        setIsAuthenticated(true)
    }

    const [navbarOpen, setNavbarOpen] = React.useState(false);
  return (
    <>
      <nav className="top-0 fixed z-50 w-full flex flex-wrap items-center justify-between px-2 py-3 navbar-expand-lg bg-purple-200 shadow">
        <div className="container px-4 mx-auto flex flex-wrap items-center justify-between">
          
          <div className="w-full relative flex justify-between lg:w-auto lg:static lg:block lg:justify-start">
            <Link
              to="/"
              className="text-black-700 text-sm font-bold leading-relaxed inline-block mr-4 py-2 whitespace-nowrap uppercase"
            >
              <Image src={img} style={{width:"150px"}}/>
            </Link>
            <button
              className="cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-transparent rounded bg-transparent block lg:hidden outline-none focus:outline-none"
              type="button"
              onClick={() => setNavbarOpen(!navbarOpen)}
            >
              <i className="fas fa-bars"></i>
            </button>
          </div>
          <div
            className={
              "lg:flex flex-grow items-center bg-white lg:bg-opacity-0 lg:shadow-none" +
              (navbarOpen ? " block" : " hidden")
            }
            id="example-navbar-warning"
          >
            <ul className="flex flex-col lg:flex-row list-none mr-auto">
              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="/"
                >
                  <i className="text-black fas fa-home text-lg leading-lg mr-2" />{" "}
                  Ana Sayfa
                </a>
              </li>
              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="/jobAdvertisement"
                >
                  <i className="text-black-400 far fa-file-alt text-lg leading-lg mr-2" />{" "}
                  İş İlanları
                </a>
              </li>
              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="/about"
                >
                  <i className="text-black-400 far fa-address-card text-lg leading-lg mr-2" />{" "}
                  Hakkımızda
                </a>
              </li>
              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="/contact"
                >
                  <i className="text-black-400 far fa-phone text-lg leading-lg mr-2" />{" "}
                  İletişim
                </a>
              </li>
            </ul>
            <ul className="flex flex-col lg:flex-row list-none lg:ml-auto">
              <li className="flex items-center">
              </li>
              

              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="https://tr.linkedin.com/in/berkcan-g%C3%BCm%C3%BC%C5%9F%C4%B1%C5%9F%C4%B1k-20452b199"
                  target="_blank"
                >
                  <i className="text-black-400 fab fa-linkedin text-lg leading-lg " />
                  <span className="lg:hidden inline-block ml-2">Linkedin</span>
                </a>
              </li>

              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="https://www.instagram.com/berkcangumusisik/"
                  target="_blank"
                >
                  <i className="text-black-400 fab fa-instagram text-lg leading-lg " />
                  <span className="lg:hidden inline-block ml-2">Instagram</span>
                </a>
              </li>
              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="https://www.youtube.com/c/TeknolojiSepeti/videos"
                  target="_blank"
                >
                  <i className="text-black-400 fab fa-youtube text-lg leading-lg " />
                  <span className="lg:hidden inline-block ml-2">Youtube</span>
                </a>
              </li>

              <li className="flex items-center">
                <a
                  className="hover:text-black-500 text-black-700 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold"
                  href="https://github.com/berkcangumusisik"
                  target="_blank"
                >
                  <i className="text-black-400 fab fa-github text-lg leading-lg " />
                  <span className="lg:hidden inline-block ml-2">Star</span>
                </a>
              </li>

              <li className="flex items-center">
                <button
                  className=" bg-purple-600 text-white text-xs font-bold uppercase px-4 py-2 rounded shadow hover:shadow-lg outline-none focus:outline-none lg:mr-1 lg:mb-0 ml-3 mb-3 ease-linear transition-all duration-150"
                  type="button"
                >
                  {isAuthenticated ?
                            <Login logOut={handleSingOut} />
                            : <Logout logIn={handleSingIn} />}
                </button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  );
}