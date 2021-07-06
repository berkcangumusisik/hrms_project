import axios from "axios"

export default class CvEducationService {

    getCvEducations() {
        return axios.get("http://localhost:8080/api/cvEducation/getall")

    }
    getGraduationDateDesc(cvId) {
        return axios.get("localhost:8080/api/cvEducation/getGraduationDateDesc?cvId"+cvId)        
    }

    getAllByCv_CvId(cvId) {
        return axios.get("http://localhost:8080/api/cvEducation/getAllByCv_CvId?cvId"+cvId)        
    }

    add(cvEducation){
        return axios.post("http://localhost:8080/api/cvEducation/add",cvEducation)
    }


}