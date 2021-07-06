import { useFormik } from 'formik'
import React from 'react'
import * as Yup from "yup";
import JobSeekerService from "../../services/JobSeekerService";
export default function JobSeekerRegister() {
    let jobSeekerService = new JobSeekerService();

    const formik = useFormik({
    initialValues: {
        firstName: "",
        lastName: "",
        identityNumber: "",
        dateOfBirth: 0,
        email: "",
        password: "",
        passwordAgain: "",
        validationCode: ""
    },
    validationSchema: Yup.object({
        firstName: Yup.string().min(2, "İsim minimum 2 karakter olmalıdır!").required("İsim boş bırakılamaz!"),
        lastName: Yup.string().min(2, "Soyisim minimum 2 karakter olmalıdır!").required("Soyisim boş bırakılamaz!"),
        identityNumber: Yup.number().required("TC Kimlik Numarası boş bırakılamaz!"),
        dateOfBirth: Yup.number().required("Doğum tarihi boş bırakılamaz!"),
        email: Yup.string().email("Geçerli bir email adresi giriniz!").required("Email boş bırakılamaz!"),
        password: Yup.string().required("Şifre boş bırakılamaz!"),
        passwordAgain: Yup.string().required("Şifre tekrarı boş bırakılamaz!"),
        validationCode: Yup.string().required("Doğrulama kodu boş bırakılamaz!"),
    }),
    onSubmit: (values) => {
        console.log(values);
        let jobSeeker = {
            firstName: values.firstName,
            lastName: values.lastName,
            identityNumber: values.identityNumber,
            dateOfBirth: values.dateOfBirth,
            email: values.email,
            password: values.password,
        };
        let passwordAgain = values.passwordAgain;
        let validationCode = values.validationCode;
        console.log(jobSeeker, passwordAgain, validationCode);
        jobSeekerService.register(jobSeeker, passwordAgain, validationCode).then((result) => console.log(result.data.message));
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
                
                  <h1 className=" text-xl font-bold ">
                    İŞ ARAYAN KAYIT SAYFASI
                  </h1>
                </div>
                <hr className="mt-6 border-b-1 border-blue-300" />
              </div>
              <div className="flex-auto px-4 lg:px-10 py-10 pt-0">
                  
                  <form onSubmit={formik.handleSubmit}>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      İsim
                    </label>
                    <input
                      id="firstName"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="İsminizi Giriniz.."
                      values={formik.values.firstName}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.firstName && formik.touched.firstName && (
                                    <p style={{ color: "red" }}>{formik.errors.firstName}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Soyad
                    </label>
                    <input
                      id="lastName"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Soyadınızı Giriniz..."
                      values={formik.values.lastName}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.lastName && formik.touched.lastName && (
                                    <p style={{ color: "red" }}>{formik.errors.lastName}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                    TC Kimlik Numarası
                    </label>
                    <input
                      id="identityNumber"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="TC Kimlik Numaranızı Giriniz..."
                      values={formik.values.identityNumber}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.identityNumber && formik.touched.identityNumber && (
                                    <p style={{ color: "red" }}>{formik.errors.identityNumber}</p>
                    )}
                  </div>
                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Doğum Tarihi
                    </label>
                    <input
                      id="dateOfBirth"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Doğum Yılınızı Giriniz..."
                      values={formik.values.dateOfBirth}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.dateOfBirth && formik.touched.dateOfBirth && (
                                    <p style={{ color: "red" }}>{formik.errors.dateOfBirth}</p>
                    )}
                  </div>

                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Mail Adresi
                    </label>
                    <input
                      id="email"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Mail Adresinizi Giriniz..."
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

                  <div className="relative w-full mb-3">
                    <label className="text-red-600 text-xl font-bold ">
                      Doğrulama Kodu
                    </label>
                    <input
                      id="validationCode"
                      fluid
                      className="border-0 px-3 py-3 placeholder-blue-1000 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Doğrulama Kodunu Giriniz..."
                      values={formik.values.validationCode}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.validationCode && formik.touched.validationCode && (
                                    <p style={{ color: "red" }}>{formik.errors.validationCode}</p>
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
