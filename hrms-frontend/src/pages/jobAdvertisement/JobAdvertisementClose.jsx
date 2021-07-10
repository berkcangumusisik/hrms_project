import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router'
import JobAdvertisementService from '../../services/JobAdvertisementService'
import JobAdvertisementDetails from './JobAdvertisementDetails'

export default function JobAdvertisementClose() {

    const { jobAdvertisementId, employerId} = useParams()

    const [jobAdvertisement, setJobAdvertisement] = useState({})

    useEffect(()=>{
        let jobAdertisemetService = new JobAdvertisementService()
        jobAdertisemetService.closeTheJobAdvertisement(jobAdvertisementId, employerId).then(result => setJobAdvertisement(result.data.data))

    },[])


    return (
        <div>
            
            <JobAdvertisementDetails/>
            
        </div>
    )
}