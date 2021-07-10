import React from 'react'
import { Route } from 'react-router'
import About from '../pages/About'
import ContactUs from '../pages/ContactUs'
import Home from '../pages/Home'
import JobAdvertisementAdd from '../pages/jobAdvertisement/JobAdvertisementAdd'
import JobAdvertisementDetails from '../pages/jobAdvertisement/JobAdvertisementDetails'
import JobAdvertisementList from '../pages/jobAdvertisement/JobAdvertisementList'
import ApprovedEmployerList from '../pages/systemUser/ApprovedEmployerList'
import JobAdvertisementDetailsForPersonnel from '../pages/systemUser/ApprovedEmployerList'
import ApprovedJobAdvertisementList from '../pages/systemUser/ApprovedJobAdvertisementList'
import UnApprovedEmployerList from '../pages/systemUser/UnApprovedEmployerList'
import UnapprovedJobAdvertisementList from '../pages/systemUser/UnApprovedJobAdvertisementList'
import Login from './Login'
import EmployerRegister from './register/EmployerRegister'
import JobSeekerRegister from './register/JobSeekerRegister'


export default function MainLayout() {
    return (
        <div>
            <Route exact path="/jobAdvertisement" component={JobAdvertisementList} />
            <Route exact path="/jobAdvertisementAdd" component={JobAdvertisementAdd} />
            <Route exact path="/jobAdvertisement/:jobAdvertisementId" component={JobAdvertisementDetails} />
            <Route exact path="/approvedJobAdvertisement" component={ApprovedJobAdvertisementList} />
            <Route exact path="/unApprovedJobAdvertisement" component={UnapprovedJobAdvertisementList} />
            <Route exact path="/jobAdvertisementDetailForPersonnel/:jobAdvertisementId" component={JobAdvertisementDetailsForPersonnel} />
            <Route exact path="/employerRegister" component={EmployerRegister} />
            <Route exact path="/approvedEmployerList" component={ApprovedEmployerList} />
            <Route exact path="/unApprovedEmployerList" component={UnApprovedEmployerList} />
            <Route exact path="/jobSeekerRegister" component={JobSeekerRegister} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/" component={Home} />
            <Route exact path="/home" component={Home} />
            <Route exact path="/about" component={About} />
            <Route exact path="/contact" component={ContactUs} />


        </div>
    )
}
