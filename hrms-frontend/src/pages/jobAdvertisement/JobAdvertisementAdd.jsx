import { useFormik } from 'formik';
import React, { useEffect, useState } from 'react'
import { Button, Dropdown, Form, Segment} from 'semantic-ui-react'
import CityService from '../../services/CityService';
import JobAdvertisementService from '../../services/JobAdvertisementService';
import JobPositionService from '../../services/JobPositionService';
import WorkTimeTypeService from '../../services/WorkTimeTypeService';
import WorkTypeService from '../../services/WorkTypeService';
import '../../css/JobAdvertisementAdd.css'
import * as Yup from "yup";
import * as moment from 'moment'

export default function JobAdvertisementAdd() {

    const [cities, setCities] = useState([]);
    const [jobPositions, setJobPositions] = useState([]);
    const [workTimeTypes, setWorkTimeTypes] = useState([]);
    const [workTypes, setWorkTypes] = useState([]);
    let jobAdvertisementService = new JobAdvertisementService()


    useEffect(() => {
        let cityService = new CityService()
        let jobPositionService = new JobPositionService()
        let workTimeTypeService = new WorkTimeTypeService()
        let workTypeService = new WorkTypeService()
        cityService.getCities().then(result => setCities(result.data.data))
        jobPositionService.getJobPositions().then(result => setJobPositions(result.data.data))
        workTimeTypeService.getWorkTimeTypes().then(result => setWorkTimeTypes(result.data.data))
        workTypeService.getWorkTypes().then(result => setWorkTypes(result.data.data))
    }, [])

    const getCities = cities.map((city, index) => ({
        key: index,
        text: city.cityName,
        value: city.cityId,
    }));
    const getJobPositions = jobPositions.map((position, index) => ({
        key: index,
        text: position.positionName,
        value: position.positionId,
    }));
    const getWorkTimeTypes = workTimeTypes.map((workTimeType, index) => ({
        key: index,
        text: workTimeType.workTimeTypeName,
        value: workTimeType.workTimeTypeId,
    }));
    const getWorkTypes = workTypes.map((workType, index) => ({
        key: index,
        text: workType.workTypeName,
        value: workType.workTypeId,
    }));

    const formik = useFormik({
        initialValues: {
            positionId: "",
            cityId: "",
            minSalary: "",
            maxSalary: "",
            positionAmount: "",
            jobDescription: "",
            applicationDeadline: "",
            workTypeId: "",
            workTimeTypeId: "",
            id: 1 ,
            releaseDate: moment().format("YYYY-MM-DD")
        },
        validationSchema: Yup.object({
            positionId: Yup.number().required("???? pozisyonu bilgisi se??iniz!"),
            cityId: Yup.string().required("??ehir bilgisi se??iniz!"),
            positionAmount: Yup.number().required("Al??nacak eleman say??s?? bo?? b??rak??lamaz!"),
            jobDescription: Yup.string().required("A????klama bo?? b??rak??lamaz!"),
            applicationDeadline: Yup.string().required("Son ba??vuru tarihi bo?? b??rak??lamaz!"),
            workTypeId: Yup.string().required("??al????ma tipi bilgisi se??iniz!"),
            workTimeTypeId: Yup.string().required("??al????ma zaman?? tipi bilgisi se??iniz!")
        }),
        onSubmit: (values) => {
            let jobAdvertisement = {
                applicationDeadline: values.applicationDeadline,
                city: { cityId: values.cityId },
                employer: { id: values.id },
                position: { positionId: values.positionId },
                minSalary: values.minSalary,
                maxSalary: values.maxSalary,
                positionAmount: values.positionAmount,
                jobDescription: values.jobDescription,
                workType: { workTypeId: values.workTypeId },
                workTimeType: { workTimeTypeId: values.workTimeTypeId },
                releaseDate: values.releaseDate
            };
            console.log(jobAdvertisement);
            jobAdvertisementService.add(jobAdvertisement).then((result) => console.log(result.data.message));
            
        },
    });

    return (
        <div className="container mx-auto px-4 h-full" style={{marginTop:"5em", marginLeft:"4em"}}>
            <div className="JobAdvertisementAdd">
            <Segment inverted><h3 className="headerStyle">???? ??lan?? Ekle</h3></Segment>

                    <Form onSubmit={formik.handleSubmit}>
                        <div style={{ fontWeight: "lighter", padding: "3px" ,color:"blue" }} >
                        <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>??ehir</label>
                                <Dropdown style={{ marginRight: "1em", marginTop: "1em", fontWeight: "lighter" }}
                                    button
                                    placeholder='??ehir Se??iniz...'
                                    fluid
                                    search
                                    selection
                                    id="cityId"
                                    options={getCities}
                                    onChange={(event, data) =>
                                        formik.setFieldValue("cityId", data.value)
                                    }
                                    value={formik.values.cityId}
                                />
                                {formik.errors.cityId && formik.touched.cityId && (
                                    <p style={{ color: "red" }}>{formik.errors.cityId}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>???? Pozisyonu</label>
                                <Dropdown style={{ marginRight: "1em", marginTop: "1em", fontWeight: "lighter" }}
                                    button
                                    placeholder='???? Pozisyonu Se??iniz...'
                                    fluid
                                    search
                                    selection
                                    id="positionId"
                                    options={getJobPositions}
                                    onChange={(event, data) =>
                                        formik.setFieldValue("positionId", data.value)
                                    }
                                    value={formik.values.positionId}
                                />
                                {formik.errors.positionId && formik.touched.positionId && (
                                    <p style={{ color: "red" }}>{formik.errors.positionId}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>??al????ma Tipi</label>
                                <Dropdown style={{ marginRight: "1em", marginTop: "1em", fontWeight: "lighter" }}
                                    button
                                    placeholder='??al????ma Tipini Se??iniz...'
                                    fluid
                                    search
                                    selection
                                    id="workTypeId"
                                    options={getWorkTypes}
                                    onChange={(event, data) =>
                                        formik.setFieldValue("workTypeId", data.value)
                                    }
                                    value={formik.values.workTypeId}
                                    required
                                />
                                {formik.errors.workTypeId && formik.touched.workTypeId && (
                                    <p style={{ color: "red" }}>{formik.errors.workTypeId}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>??al????ma Zaman?? Tipi</label>
                                <Dropdown style={{ marginRight: "1em", marginTop: "1em", fontWeight: "lighter" }}
                                    button
                                    placeholder='??al????ma Zaman?? Tipini Se??iniz...'
                                    fluid
                                    search
                                    selection
                                    id="workTimeTypeId"
                                    options={getWorkTimeTypes}
                                    onChange={(event, data) =>
                                        formik.setFieldValue("workTimeTypeId", data.value)
                                    }
                                    value={formik.values.workTimeTypeId}
                                />
                                {formik.errors.workTimeTypeId && formik.touched.workTimeTypeId && (
                                    <p style={{ color: "red" }}>{formik.errors.workTimeTypeId}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>Minimum Maa??</label>
                                <input id="minSalary" placeholder="Minimum Maa??..." fluid style={{ marginRight: "1em", marginTop: "1em" }} onChange={formik.handleChange} value={formik.values.minSalary}></input>
                                {formik.errors.minSalary && formik.touched.minSalary && (
                                    <p style={{ color: "red" }}>{formik.errors.minSalary}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
        
                                <label>Maksimimum Maa??</label>
                                <input id="maxSalary" placeholder="Maksimum Maa??..." fluid style={{ marginRight: "1em", marginTop: "1em" }} onChange={formik.handleChange} value={formik.values.maxSalary}></input>
                                {formik.errors.maxSalary && formik.touched.maxSalary && (
                                    <p style={{ color: "red" }}>{formik.errors.maxSalary}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>Al??nacak Personel Say??s??</label>
                                <input id="positionAmount" placeholder="Al??nacak Personel Say??s??" fluid style={{ marginRight: "1em", marginTop: "1em" }} onChange={formik.handleChange} value={formik.values.positionAmount}></input>
                                {formik.errors.positionAmount && formik.touched.positionAmount && (
                                    <p style={{ color: "red" }}>{formik.errors.positionAmount}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>Son Ba??vuru Tarihi</label>
                                <input type="date" id="applicationDeadline" placeholder="Son Ba??vuru Tarihi" fluid style={{ marginRight: "1em", marginTop: "1em" }} onChange={formik.handleChange} value={formik.values.applicationDeadline}></input>
                                {formik.errors.applicationDeadline && formik.touched.applicationDeadline && (
                                    <p style={{ color: "red" }}>{formik.errors.applicationDeadline}</p>
                                )}
                            </div>
                            <div class="relative flex w-full flex-wrap items-stretch mb-10">
                                <label>A????klama</label>
                                <textarea id="jobDescription" placeholder="A????klama..." style={{ marginRight: "1em", marginTop: "1em", minHeight: 100}} onChange={formik.handleChange} value={formik.values.jobDescription}></textarea>
                                {formik.errors.jobDescription && formik.touched.jobDescription && (
                                    <p style={{ color: "red" }}>{formik.errors.jobDescription}</p>
                                )}
                            </div>
                        </div>
                        <Button type="submit" style={{ backgroundColor: "green", color: "white", marginBottom: "0.001em" }} >EKLE</Button>
                    </Form>
            </div>
        </div>
    )
}
