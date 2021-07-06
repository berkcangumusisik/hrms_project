import React from 'react'
import EmployerService from '../../services/EmployerService'

export default function EmployerList() {

    const [employers, setEmployers] = useState([]);

    useEffect(() => {
        let employerService = new EmployerService()
        employerService.getEmployers().then(result => setEmployers(result.data.data))
    }, [])


    return (
        <div>
            
        </div>
    )
}
