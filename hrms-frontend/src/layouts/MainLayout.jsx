import React from 'react'
import { Route } from 'react-router'
import About from '../pages/About'
import ContactUs from '../pages/ContactUs'
import Home from '../pages/Home'
import JobAdvertisementAdd from '../pages/jobAdvertisement/JobAdvertisementAdd'
import JobAdvertisementDetails from '../pages/jobAdvertisement/JobAdvertisementDetails'
import JobAdvertisementDetailsForPersonnel from '../pages/systemUser/JobAdvertisementDetailsForPersonnel'
import Login from './Login'
import EmployerRegister from './register/EmployerRegister'
import JobSeekerRegister from './register/JobSeekerRegister'


export default function MainLayout() {
    return (
        <div>
            <Route exact path="/jobAdvertisementDetailForPersonnel/:jobAdvertisementId" component={JobAdvertisementDetailsForPersonnel} />
            <Route exact path="/jobAdvertisementAdd" component={JobAdvertisementAdd} />
            <Route exact path="/:jobSeekerId/jobAdvertisement/:jobAdvertisementId" component={JobAdvertisementDetails} />
            <Route exact path="/employerRegister" component={EmployerRegister} />
            <Route exact path="/jobSeekerRegister" component={JobSeekerRegister} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/" component={Home} />
            <Route exact path="/home" component={Home} />
            <Route exact path="/about" component={About} />
            <Route exact path="/contact" component={ContactUs} />


        </div>
    )
}
