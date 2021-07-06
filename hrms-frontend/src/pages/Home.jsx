import React from "react";
import { NavLink } from 'react-router-dom'
import { Button, Dropdown } from 'semantic-ui-react'

export default function Home() {
    return(
    <>
    <div className=" bg-purple-200 w-screen">
    <section className="header relative pt-14 items-center flex h-screen max-h-860-px bg-purple-200">
        <div className="container mx-auto items-center flex flex-wrap">
          <div className="w-full md:w-8/12 lg:w-6/12 xl:w-6/12 px-4">
            <div className="pt-32 sm:pt-0">
              <h2 className="font-semibold text-4xl" style={{color:"purple"}}>
                HAYALİNDEKİ İŞİ Mİ ARIYORSUN?
              </h2>
              <p className="mt-4 text-xl leading-relaxed" style={{color:"blue"}}>
                Site site gezip iş ilanı aramaktan ve CV doldurmaktan sıkıldıysanız  
                <mark> HRMS</mark> yanınızda 10000+ ilan ile
                işsiz kimse kalmaması için çabalıyoruz. Eğer aramıza halen katılmadıysan <mark> Kayıt Ol </mark>
                butonuna tıklayarak kayıt olabilirsiniz. Sizi de aramızda görmek için sabırsızlanıyoruz
              </p>
              <div className="mt-12">
              <Button style={{ backgroundColor: "purple", color: "white", marginBottom: "0.001em" }}>
                    <Dropdown pointing="top right" text="Kayıt Ol">
                        <Dropdown.Menu >
                            <Dropdown.Item as={NavLink} to="/employerRegister" text="İş Veren" icon="angle double right" />
                            <Dropdown.Item as={NavLink} to="/jobSeekerRegister" text="İş Arayan" icon="angle double right" />
                        </Dropdown.Menu>
                    </Dropdown>
                </Button>
              </div>
            </div>
          </div>
        </div>

        <img
          className="absolute top-0 b-auto right-0 pt-16 sm:w-6/12 -mt-48 sm:mt-0 w-10/12 max-h-860px bg-purple-200"
          src={require("../assets/img/pattern_react.png").default}
          alt="..."
        />
      </section>

      <section className="mt-48 md:mt-40 pb-40 relative bg-purple-200">
        <div
          className="-mt-20 top-0 bottom-auto left-0 right-0 w-full absolute h-20 bg-purple-200"
          style={{ transform: "translateZ(0)" }}
        >
          <svg
            className="absolute bottom-0 overflow-hidden "
            xmlns="http://www.w3.org/2000/svg"
            preserveAspectRatio="none"
            version="1.1"
            viewBox="0 0 2560 100"
            x="0"
            y="0"
          >
           
          </svg>
        </div>
        <div className="container mx-auto bg-purple-200">
          <div className="flex flex-wrap items-center">
            <div className="w-10/12 md:w-6/12 lg:w-4/12 px-12 md:px-4 mr-auto ml-auto -mt-32 bg-purple-200">
              <div className="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-lg bg-purple-200" style={{color:"purple-200"}}>
                <img
                  alt="..."
                  src="https://fiverr-res.cloudinary.com/images/q_auto,f_auto/gigs/107473316/original/77f3bb0b1c8852cf6a4f27522d5fb3766fd68b82/human-resources-management-system.jpg"
                  className="w-full align-middle rounded-t-lg bg-purple-200"
                />
                <blockquote className="relative p-8 mb-4 bg-purple-200">
                  <svg
                    preserveAspectRatio="none"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 583 95"
                    className="absolute left-0 w-full block h-95-px -top-94-px "
                  >
                    
                  </svg>
                  <h4 className="text-xl font-bold text-dark">
                    Sistem Nasıl İşliyor?
                  </h4>
                  <p className="text-md font-light mt-2 text-dark">
                    HRMS projesiyle birlikte iş verenler ile iş arayanları bir 
                    araya getiren bir platformdur. Sistemde iş verenler ilanlarını 
                    yayınlayabiliyor. İş arayanlar ise sisteme kayıt olarak önce CV 
                    oluşturuyor daha sonra ilanlara başvurabilmektedirler.
                  </p>
                </blockquote>
              </div>
            </div>

            <div className="w-full md:w-6/12 px-4">
              <div className="flex flex-wrap">
                <div className="w-full md:w-6/12 px-4">
                  <div className="relative flex flex-col mt-4">
                    <div className="px-4 py-5 flex-auto">
                      <div className="text-blueGray-500 p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-white">
                        <i className="fas fa-sign-in-alt" style={{color:"green"}}></i>
                      </div>
                      <h6 className="text-xl mb-1 font-semibold text-red-600"style={{color:"green"}}>
                        Kayıt Ol
                      </h6>
                      <p className="mb-4 text-blueGray-500">
                        Hayalinizdeki işi bulmak için sisteme kayıt olun
                      </p>
                    </div>
                  </div>
                  <div className="relative flex flex-col min-w-0">
                    <div className="px-4 py-5 flex-auto">
                      <div className="text-blueGray-500 p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-white">
                        <i className="fas fa-file-signature" style={{color:"blue"}}></i>
                      </div>
                      <h6 className="text-xl mb-1 font-semibold" style={{color:"blue"}}>
                        CV oluştur
                      </h6>
                      <p className="mb-4 text-blueGray-500">
                        Şirketlerin ilgisini çekecek ve gerçekçi özelliklerden oluşan bir
                        CV hazırla.
                      </p>
                    </div>
                  </div>
                </div>
                <div className="w-full md:w-6/12 px-4">
                  <div className="relative flex flex-col min-w-0 mt-4">
                    <div className="px-4 py-5 flex-auto">
                      <div className="text-blueGray-500 p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-white">
                        <i className="fas fa-search" style={{color:"red"}}></i>
                      </div>
                      <h6 className="text-xl mb-1 font-semibold" style={{color:"red"}}>İş Ara</h6>
                      <p className="mb-4">
                        Kişisel ilgi alanlarına göre hayalindeki işi bul.
                      </p>
                    </div>
                  </div>
                  <div className="relative flex flex-col min-w-0">
                    <div className="px-4 py-5 flex-auto">
                      <div className="text-blueGray-500 p-3 text-center inline-flex items-center justify-center w-12 h-12 mb-5 shadow-lg rounded-full bg-white">
                        <i className="fas fa-file-alt" style={{color:"purple"}}></i>
                      </div>
                      <h6 className="text-xl mb-1 font-semibold"style={{color:"purple"}}>
                        Başvur
                      </h6>
                      <p className="mb-4 text-blueGray-500">
                        Hayalindeki işi bulduğun an ilana başvurunu yap
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>


        
      </section>
      <section className="py-20 bg-blueGray-600 overflow-hidden">
        <div className="container mx-auto pb-64">
          <div className="flex flex-wrap justify-center">
            <div className="w-full md:w-5/12 px-12 md:px-4 ml-auto mr-auto md:mt-64 ">
              <div className="text-blueGray-500 p-3 text-center inline-flex items-center justify-center w-16 h-16 mb-6 shadow-lg rounded-full bg-white">
                <i className="fas fa-code-branch text-xl"></i>
              </div>
              <h3 className="text-3xl mb-2 font-semibold leading-normal text-white">
                Açık Kaynak Kodludur
              </h3>
              <p className="text-lg font-light leading-relaxed mt-4 mb-4 text-blueGray-400">
                HRMS uygulaması Engin Demiroğ ile Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
                ile birlikte geliştirilmiştir. Proje kapsamında Backend kısmı JAVA, Spring Boot gibi yapılar
                kullanılmıştır. Frontend kısmında ise React kullanılmıştır. Veri tabanı içinse PostgreSQL'den 
                yararlanılmıştır. Eğer projeye destek olmak isterseniz aşağıdaki butona tıklayarak yıldız vererek 
                gelişimine katkıda bulunabilirsiniz.
              </p>
              <a
                href="https://github.com/berkcangumusisik/hrms_project"
                className="github-star mt-4 inline-block text-white font-bold px-6 py-4 rounded outline-none focus:outline-none mr-1 mb-1 bg-blueGray-700 active:bg-blueGray-600 uppercase text-sm shadow hover:shadow-lg"
              >
                Github 
              </a>
            </div>

            <div className="w-full md:w-4/12 px-4 mr-auto ml-auto mt-32 relative">
              <i className="fab fa-github text-blueGray-700 absolute -top-150-px -right-100 left-auto opacity-80 text-55"></i>
            </div>
          </div>
        </div>
      </section>
      </div>
</>
  );
}