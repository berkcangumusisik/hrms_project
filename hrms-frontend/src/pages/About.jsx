import React from 'react'
import { Image } from 'semantic-ui-react'
import  img  from "../assets/img/hrms_logo.png";

export default function About() {
    return (
        <>
        <section className="pb-20 relative block bg-purple-200">
        <div style={{ marginTop:"5em"}}>
            <br/>
            <h1 className="text-xl font-bold text-dark" style={{ fontSize:"25px"}}>
                    HAKKIMIZDA SAYFASI
            </h1>
            <br/>
            <div>
                <div>
                <p  style={{ fontSize:"25px", margin:"3em"}}>
                Bu proje Berkcan Gümüşışık tarafından Temmuz 2021 yılında Engin Demiroğ'un hazırlamış olduğu Yazılım Geliştirici Yetiştirme Kampı 
                (JAVA + REACT) kapsamında hazırlanmıştır. Bu projeyi bizlere destek olduğu için Engin Demiroğ hocama çok teşekkür ederim.
                </p>
                <br/>
                </div>
                <div>
                <Image src={img} style={{marginLeft:"150px"}}/>

                </div>
            </div>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5295.447309627257!2d32.84930349172434!3d39.94017631197348!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14d34e6000a09047%3A0xc9b7204dec17d330!2zS8SxesSxbGF5IEF2bQ!5e0!3m2!1str!2str!4v1625855868683!5m2!1str!2str" style={{width:"1200px",height:"450px", marginLeft:"60px", marginTop:"60px"}}></iframe>
        </div>
        </section>
        </>
    )
}
