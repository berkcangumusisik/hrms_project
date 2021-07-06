import axios from "axios"

export default class WorkExperienceService {

    getWorkExperiences() {
        return axios.get("http://localhost:8080/api/workExperience/getAll")

    }
    add(workExperience){
        return axios.post("http://localhost:8080/api/workExperience/add", workExperience)
    }

    getWorkExperiencesByCvId(cvId) {
        return axios.get("http://localhost:8080/api/workExperience/getWorkExperiencJobPositionDetails?cvId="+cvId)

    }

}