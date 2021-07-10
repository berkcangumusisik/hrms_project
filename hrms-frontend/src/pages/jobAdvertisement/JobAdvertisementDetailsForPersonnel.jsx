import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router'
import { Segment, Table, Button } from 'semantic-ui-react'
import JobAdvertisementService from '../../services/JobAdvertisementService'
import '../../../css/JobAdvertisement.css'
import { toast } from 'react-toastify'
import moment from 'moment'

export default function JobAdvertisementDetailsForPersonnel() {

    let { jobAdvertisementId } = useParams()

    const [jobAdvertisement, setJobAdvertisement] = useState({})
    let jobAdvertisementService = new JobAdvertisementService()

    useEffect(() => {
        jobAdvertisementService.getJobAdvertisementByJobAdvertisementId(jobAdvertisementId).then(result => setJobAdvertisement(result.data.data))
    }, [])

    function changeStatus(jobAdvertisementId, status) {
        jobAdvertisementService.changeApprovalStatusForJobAdvertisementId(jobAdvertisementId, status).then(result => console.log(result.data.message))
        {
            status == true &&
                toast.success('İş İlanı Onaylandı.', {
                    position: "bottom-right",
                    autoClose: 3000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    });
        }
        {
            status == false && 
            toast.success('İş İlanı Reddedildi.', {
                position: "bottom-right",
                autoClose: 3000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                });
        }

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
                            <p>{moment(jobAdvertisement.applicationDeadline).format("DD.MM.yyyy")}</p>
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
                            <p>{jobAdvertisement.employer?.website}</p>
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>İlanın Aktiflik Durumu:</p>
                        </td>
                        <td className="rightTd" >
                            {
                                jobAdvertisement.advertisementStatus == true && <p>Aktif</p>
                            }
                            {
                                jobAdvertisement.advertisementStatus == false && <p>Pasif</p>
                            }
                        </td>

                    </tr>
                    <tr>
                        <td className="leftTd" >
                            <p>İlanın Onaylanma Durumu:</p>
                        </td>
                        <td className="rightTd" >
                            {
                                jobAdvertisement.approvalStatus == true && <p>Aktif</p>
                            }
                            {
                                jobAdvertisement.approvalStatus == false && <p>Pasif</p>
                            }
                        </td>

                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            {
                                jobAdvertisement.approvalStatus == false &&
                                <Button onClick={() => changeStatus(jobAdvertisementId, true)} style={{ backgroundColor: "#780000", color: "white", marginBottom: "0.001em" }}>İlanı Onayla</Button>
                            }
                            {
                                jobAdvertisement.approvalStatus == true &&
                                <Button onClick={() => changeStatus(jobAdvertisementId, false)} style={{ backgroundColor: "#505050", color: "white", marginBottom: "0.001em" }}>İlanı Reddet</Button>
                            }
                        </td>

                    </tr>

                </Table>

            </Segment.Group>
        </div>
    ) 
}