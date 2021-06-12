import React from "react";
import { Grid, Tab } from "semantic-ui-react";
import CurriculumVitae from "../pages/CurriculumVitaeList";
import CvEducationList from "../pages/CvEducationList";
import CvExperienceList from "../pages/CvExperienceList";
import CvSkillList from "../pages/CvSkillList";
import EmployerList from "../pages/EmployerList";
import JobAdvertisementList from "../pages/JobAdvertisementList";
import JobPositionList from "../pages/JobPositionList";
import JobSeekerList from "../pages/JobSeekerList";
import PhotographList from "../pages/PhotographList";
import SystemPersonnelList from "../pages/SystemPersonnelList";
import Categories from "./Categories";



export default function DashBoard() {
  const panes=[
    {
      menuItem:"Sistem Personelleri",
      render:() => <Tab.Pane attached={false}><SystemPersonnelList/></Tab.Pane>
    },
   
    {
      menuItem:"İş Verenler",
      render:() => <Tab.Pane attached={false}><EmployerList/></Tab.Pane>
    },
    {
      menuItem:"İş İlanları",
      render:() => <Tab.Pane attached={false}><JobAdvertisementList/></Tab.Pane>
    },
    {
      menuItem:"Pozisyonlar",
      render:() => <Tab.Pane attached={false}><JobPositionList/></Tab.Pane>
    },
    {
      menuItem:"İş Arayanlar",
      render:() => <Tab.Pane attached={false}><JobSeekerList/></Tab.Pane>
    },
    {
      menuItem:"CV",
      render:() => <Tab.Pane attached={false}><CurriculumVitae/></Tab.Pane>
    },
    {
      menuItem:"Okul Bilgileri",
      render:() => <Tab.Pane attached={false}><CvEducationList/></Tab.Pane>
    },
    {
      menuItem:"İş Deneyimleri",
      render:() => <Tab.Pane attached={false}><CvExperienceList/></Tab.Pane>
    },
    
  ]
  return (
    <div>
      <Grid>
                <Grid.Row>
                    <Grid.Column width={3}>
                        <Categories />
                    </Grid.Column>

                    <Grid.Column width={13}>
                      <Tab panes={panes}/>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
    </div>
  );
}
