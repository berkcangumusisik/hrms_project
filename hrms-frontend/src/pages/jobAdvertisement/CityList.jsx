import React from 'react'
import { Dropdown } from 'semantic-ui-react';
import CityService from '../../services/CityService'

export default function CityList() {

    const [cities, setCities] = useState([]);

    useEffect(() => {
        let cityService = new CityService()
        cityService.getCities().then(result => setCities(result.data.data))
    }, [])

    const getCities = cities.map((city, index) => ({
        key: index,
        text: city.cityName,
        value: city.id,
      }));


    return (
        <div>
            <Dropdown
                placeholder='State'
                fluid
                multiple
                search
                selection
                options={getCities}
            />
        </div>
    )
}