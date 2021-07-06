import React, { Component } from 'react'
import Footer from './Footer'
import { ToastContainer } from 'react-toastify'
import MainLayout from './MainLayout'
import Sidebar from './SideBar'

export default class Dashboard extends Component {
    render() {
        return (
            <div>
                 <ToastContainer
                    position="bottom-left"
                    autoClose={3000}
                    hideProgressBar={false}
                    newestOnTop={false}
                    closeOnClick
                    rtl={false}
                    pauseOnFocusLoss
                    draggable
                    pauseOnHover
                />
                <div className="bg-purple-200">
                    <Sidebar/>
                </div>
                <div className="bg-purple-200" style={{ marginLeft:" 14em"}}>
                    <MainLayout/>
                    <Footer/>
                </div>
            </div>
        )
    }
}