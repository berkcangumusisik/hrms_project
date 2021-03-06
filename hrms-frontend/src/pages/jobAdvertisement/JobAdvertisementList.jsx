import React, { useEffect, useState } from 'react'
import { NavLink } from 'react-router-dom';
import { Image, Segment, Button } from 'semantic-ui-react'
import JobAdvertisementService from '../../services/JobAdvertisementService';

export default function JobAdvertisementList() {

    const [jobAdvertisements, setJobAdvertisements] = useState([]);

    useEffect(() => {
        let jobAdvertisementService = new JobAdvertisementService()
        jobAdvertisementService.getJobAdvertisements().then(result => setJobAdvertisements(result.data.data))
    }, [])


    return (
        <div>
                <br/>
                <div className="container mx-auto px-4 h-full " style={{margin:"2em" , marginTop:"5em"}}>
                <h1  style={{ backgroundColor: "black", color: "white", fontSize:"30px", textAlign: "center"}}>
                                İş İlanları </h1>
                {jobAdvertisements.map(jobAdvertisement => (
                    <Segment.Group piled>
                        <Segment style={{ backgroundColor: "purple" }}>
                            <h3 style={{ backgroundColor: "purple", color: "white", textAlign: "center"}}>
                                İş İlanı - {jobAdvertisement.position.positionName}</h3></Segment>
                        <Segment  >
                            <Segment.Group horizontal>
                                <div style={{ margin: "1em", marginLeft: "1em", marginTop: "3em" }}>
                                    <Image src='https://png.pngtree.com/png-vector/20190412/ourlarge/pngtree-vector-office-building-icon-png-image_931181.jpg' size="small"/>
                                </div>
                                <Segment>
                                    <div style={{ textAlign: "left"}} key={jobAdvertisement.jobAdvertisementId}>
                                        <h2 style={{ marginLeft: "1em" }}>  {jobAdvertisement.position.positionName}</h2>
                                        <p style={{ marginLeft: "1em", marginTop: "1em" }}> {jobAdvertisement.jobDescription}</p>
                                        <p style={{ marginLeft: "1em", marginTop: "1em", marginBottom: "1em" }}>{jobAdvertisement.employer.companyName}</p>
                                        <Button as={NavLink} to={`/jobAdvertisement/${jobAdvertisement.jobAdvertisementId}`} style={{ backgroundColor: "green", color: "white", marginLeft: "1em" }} >İncele </Button>
                                    </div>
                                </Segment>
                            </Segment.Group> </Segment>
                    </Segment.Group>
                ))
                }
            </div>

        </div>
    )
}