import React from 'react'
import { Menu,  Input, } from 'semantic-ui-react'
import CityList from '../pages/CityList'
import UniversityList from '../pages/UniversityList'
import FacultyList from '../pages/FacultyList'
import SectionList from '../pages/SectionList'


export default function Categories() {

 

  return (
    <div>

      <Menu vertical>
        <Menu.Item>
          <Input placeholder='Search...' />
        </Menu.Item>

        <Menu.Item>
          <Menu.Menu>

            <CityList />
            <UniversityList/>
            <FacultyList/>
            <SectionList/>
          </Menu.Menu>
        </Menu.Item>

      </Menu>

    </div>
  )
}