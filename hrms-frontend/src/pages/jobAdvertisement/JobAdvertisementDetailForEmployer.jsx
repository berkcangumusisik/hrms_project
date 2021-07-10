import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router'
import { Segment, Table,Button } from 'semantic-ui-react'
import JobAdvertisementService from '../../services/JobAdvertisementService'
import { toast } from 'react-toastify'

export default function JobAdvertisementDetailForEmployer() {

    let { jobAdvertisementId } = useParams()

    const [jobAdvertisement, setJobAdvertisement] = useState({})
    let jobAdvertisementService = new JobAdvertisementService()

    useEffect(() => {
        jobAdvertisementService.getJobAdvertisementByJobAdvertisementId(jobAdvertisementId).then(result => setJobAdvertisement(result.data.data))
    }, [])

    function setStatus(employerId, jobAdvertisementId , status) {
        jobAdvertisementService.closeTheJobAdvertisement(employerId, jobAdvertisementId , status).then(result => console.log(result.data.message))
        toast.success(`İşlem Başarılı.`)
    }


    return (
        <div>
            <Segment.Group>
                <Segment style={{ backgroundColor: "black" }}><h3 style={{ backgroundColor: "black", color: "white", marginLeft: "1em", fontFamily: "Arial, Helvetica, sans-serif" }} >İş İlanı - {jobAdvertisement.position?.positionName}</h3></Segment>
                <Table className="jobAdvertisementTable">
                    <tr>
                        <td className="leftTd" >
                            <p>İş Tanımı:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.jobDescription}</p>
                        </td>
                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Pozisyon Adı:</p>
                        </td>
                        <td className="rightTd">
                            <p>{jobAdvertisement.position?.positionName}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Şehir:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.city?.cityName}</p>
                        </td>
                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Maksimum Maaş:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.maxSalary}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Minimum Maaş:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.minSalary}</p>
                        </td>
                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Son Başvuru Tarihi:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.applicationDeadline}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Alınacak Kişi Sayısı:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.positionAmount}</p>
                        </td>
                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Çalışma Türü:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.workType?.workTypeName}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Çalışma Zamanı Türü:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.workTimeType?.workTimeTypeName}</p>
                        </td>
                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Firma Adı:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.employer?.companyName}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>Web Sitesi:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.employer?.webAddress}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>İlan Durumu:</p>
                        </td>
                        <td className="rightTd" >
                            <p>{jobAdvertisement.advertisementStatus}</p>
                        </td>

                    </tr>
                    <tr>
                        <td  >

                        </td>
                        <td>
                            <Button onClick={() =>setStatus(7,jobAdvertisementId,true)} style={{ backgroundColor: "#780000", color: "white", marginBottom: "0.001em" }}>İlanı Aktif Et</Button>
                            <Button onClick={() =>setStatus(7,jobAdvertisementId,false)} style={{ backgroundColor: "#505050", color: "white", marginBottom: "0.001em", marginLeft:"2em" }}>İlanı Kapat</Button>
                        </td>

                    </tr>

                </Table>

            </Segment.Group>
        </div>
    )
}
