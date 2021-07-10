import React from "react";


export default function Sidebar() {
  return (
    <>
      <nav className="md:left-0 md:block md:fixed md:top-0 md:bottom-0 md:overflow-y-auto md:flex-row md:flex-nowrap md:overflow-hidden shadow-xl bg-purple-200 flex flex-wrap items-center justify-between relative  z-10 py-4 px-6">
            <h6 className="md:min-w-full text-red text-large uppercase font-bold block pt-1 pb-4 no-underline" style={{marginTop:"6em"}}>
              İŞ VEREN MENÜSÜ
            </h6>

            <ul className="md:flex-col md:min-w-full flex flex-col list-none md:mb-4">
            <li className="inline-flex">
                <a
                  href="/"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-home mr-2 text-black text-base"></i>
                  Ana Sayfa
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/jobAdvertisement"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-list mr-2 text-black text-base"></i>
                  İş İlanları
                </a>
              </li>

              <li className="inline-flex">
                <a
                  href="/jobAdvertisementAdd"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-plus mr-2 text-black text-base"></i>
                  İş İlanı Ekle
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/jobAdvertisementForEmployer/1"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-clipboard-list mr-2 text-black text-base"></i>
                  Firmaya Ait Tüm İş İlanları
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/activeJobAdvertisement/1"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-check-circle mr-2 text-black text-base"></i>
                   Aktif İş İlanları
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/passiveJobAdvertisement/1"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-times mr-2 text-black text-base"></i>
                  Pasif İş İlanları
                </a>
              </li>
              </ul>
            <h6 className="md:min-w-full text-red text-large uppercase font-bold block pt-1 pb-4 no-underline" style={{marginTop:"6em"}}>
              SİSTEM PERSONELİ MENÜSÜ
            </h6>

            <ul className="md:flex-col md:min-w-full flex flex-col list-none md:mb-4">
            <li className="inline-flex">
                <a
                  href="/"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-home mr-2 text-black text-base"></i>
                  Ana Sayfa
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/approvedJobAdvertisement"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-check-circle mr-2 text-black text-base"></i>
                  Onaylanmış İş İlanları
                </a>
              </li>

              <li className="inline-flex">
                <a
                  href="/unApprovedJobAdvertisement"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-times mr-2 text-black text-base"></i>
                  Onaylanmamış İş İlanları
                </a>
              </li>
          
              <li className="inline-flex">
                <a
                  href="/approvedEmployerList"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-check-circle mr-2 text-black text-base"></i>
                   Onaylanmış İş Verenler
                </a>
              </li>
              <li className="inline-flex">
                <a
                  href="/unApprovedEmployerList"
                  className="text-black hover:text-black text-sm block mb-4 no-underline font-semibold"
                >
                  <i className="fas fa-times mr-2 text-black text-base"></i>
                  Onaylanmamış İş Verenler
                </a>
              </li>
              </ul>
      </nav>
    </>
  );
}