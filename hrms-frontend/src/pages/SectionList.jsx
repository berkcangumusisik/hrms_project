import React, { useEffect, useState } from 'react'
import { Dropdown } from 'semantic-ui-react'
import SectionService from '../services/SectionService'


export default function SectionList() {

    const [sections, setSections] = useState([])

    useEffect(() => {
        let sectionService = new SectionService()
        sectionService.getSection().then(result => setSections(result.data.data))},[])

    const section = sections.map(section => (
        {
            key: 'section.sectionId',
            text: (section.sectionName),
            value: (section.sectionId)
        }
    ))

    return (
        <Dropdown icon='book' labeled button className='icon' placeholder='Bölümler' multiple selection search options={section} />
    )
}