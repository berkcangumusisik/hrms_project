import React, { useEffect, useState } from 'react'
import { Dropdown } from 'semantic-ui-react'
import FacultyService from '../services/FacultyService'

export default function FacultyList() {

    const [faculties, setFaculties] = useState([])

    useEffect(() => {
        let facultyService = new FacultyService()
        facultyService.getFaculties().then(result => setFaculties(result.data.data))
    })

    const faculty = faculties.map(faculty => (
        {
            key: 'faculty.facultyId',
            text: (faculty.facultyName),
            value: (faculty.facultyName)
        }
    ))

    return (
        <Dropdown icon='graduation cap' labeled
        button className='icon' placeholder='Fakülteler' multiple selection search options={faculty} />
    )
}