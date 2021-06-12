import React, { useEffect, useState } from 'react'
import { Dropdown } from 'semantic-ui-react'
import CityService from '../services/CityService'

export default function CityList() {

    const [cities, setCity] = useState([])

    useEffect(() => {
        let cityService = new CityService()
        cityService.getCities().then(result => setCity(result.data.data))},[])

    const city = cities.map(city => (
        {
            key: 'city.id',
            text: (city.cityName),
            value: (city.cityName)
        }
    ))

    return (    
        <Dropdown icon='world' labeled button className='icon' placeholder='Şehirler' multiple selection search options={city} />
    )
}