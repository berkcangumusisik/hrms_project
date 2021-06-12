import React, { useEffect, useState } from 'react'
import { Dropdown } from 'semantic-ui-react'
import UniversityService from '../services/UniversityService'

export default function UniversityList() {
    const [universities, setUniversities] = useState([])

    useEffect(() => {
        let universityService = new UniversityService()
        universityService.getUniversities().then(result => setUniversities(result.data.data))},[])

    const university = universities.map(university => (
        {
            key: 'university.universityId',
            text: (university.universityName),
            value: (university.universityId)
        }
    ))
    
    return (
        <Dropdown icon='university' labeled
        button className='icon' placeholder='Üniversiteler' multiple selection search options={university} />
    )
}
