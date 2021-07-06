import { useFormik } from 'formik'
import React from 'react'
import * as Yup from "yup";
import EmployerService from "../../services/EmployerService";
export default function EmployerRegister() {

    let employerService = new EmployerService();

    const formik = useFormik({
        initialValues: {
            companyName: "",
            webAddress: "",
            phoneNumber: "",
            email: "",
            password: "",
            passwordAgain: ""
        },
        validationSchema: Yup.object({
            companyName: Yup.string().min(2, "Şirket ismi minimum 2 karakter olmalıdır!").required("Şirket ismi boş bırakılamaz!"),
            webAddress: Yup.string().required("Web Adresi boş bırakılamaz!"),
            phoneNumber: Yup.number().required("Telefon Numarası boş bırakılamaz!"),
            email: Yup.string().email("Geçerli bir email adresi giriniz!").required("Email boş bırakılamaz!"),
            password: Yup.string().required("Şifre boş bırakılamaz!"),
            passwordAgain: Yup.string().required("Şifre tekrarı boş bırakılamaz!"),
        }),
        onSubmit: (values) => {
            console.log(values);
            let employer = {
                companyName: values.companyName,
                webAddress: values.webAddress,
                phoneNumber: values.phoneNumber,
                email: values.email,
                password: values.password,
            };
            let passwordAgain = values.passwordAgain
            console.log(employer, passwordAgain);
            employerService.register(employer, passwordAgain).then((result) => console.log(result.data.message));
        }
    });

    return (
        <>
        <div className="container mx-auto px-4 h-full" style={{marginTop:"4em", marginLeft:"3.5em"}}>
        <div className="flex content-center items-center justify-center h-full bg-purple-200">
          <div className="w-full lg:w-6/12 px-4 bg-purple-200">
          <br/>
          <br/>
          <br/>
          <br/>
            <div className="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-200 border-0">
              <div className="rounded-t mb-0 px-6 py-6 ">
                <div className="text-center mb-3 text-pink-600">
                
                  <h1 className=" text-xl font-bold">
                    İŞ VEREN KAYIT SAYFASI
                  </h1>
                </div>
                <hr className="mt-6 border-b-1 border-blue-300" />
              </div>
              <div className="flex-auto px-4 lg:px-10 py-10 pt-0">
                  
                  <form onSubmit={formik.handleSubmit}>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şirket İsmi
                    </label>
                    <input
                      id="companyName"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şirket İsminizi Giriniz.."
                      values={formik.values.companyName}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.companyName && formik.touched.companyName && (
                                    <p style={{ color: "red" }}>{formik.errors.companyName}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şirket Web Adresi
                    </label>
                    <input
                      id="webAddress"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şirket Web Sitesini Giriniz..."
                      values={formik.values.webAddress}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.webAddress && formik.touched.webAddress && (
                                    <p style={{ color: "red" }}>{formik.errors.webAddress}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şirket Telefon Numarası
                    </label>
                    <input
                      id="phoneNumber"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şirket Telefon Numarasını Giriniz..."
                      values={formik.values.phoneNumber}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.phoneNumber && formik.touched.phoneNumber && (
                                    <p style={{ color: "red" }}>{formik.errors.phoneNumber}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şirket Mail Adresi
                    </label>
                    <input
                      id="email"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şirket Mail Adresinizi Giriniz..."
                      values={formik.values.email}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.email && formik.touched.email && (
                                    <p style={{ color: "red" }}>{formik.errors.email}</p>
                    )}
                  </div>

                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şifre
                    </label>
                    <input
                      id="password"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şifre Giriniz..."
                      values={formik.values.password}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.password && formik.touched.password && (
                                    <p style={{ color: "red" }}>{formik.errors.password}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Şifre Tekrar
                    </label>
                    <input
                      id="passwordAgain"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Şifrenizi Tekrar Giriniz..."
                      values={formik.values.passwordAgain}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.passwordAgain && formik.touched.passwordAgain && (
                                    <p style={{ color: "red" }}>{formik.errors.passwordAgain}</p>
                    )}
                  </div>


                  <div className="text-center mt-6">
                    <button
                      className="bg-blueGray-800 text-white active:bg-blueGray-600 text-sm font-bold uppercase px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 w-full ease-linear transition-all duration-150"
                      type="submit"
                    >
                      Kayıt Ol
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
        </>
  );
}
