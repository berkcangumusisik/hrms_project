import axios from "axios"

export default class CvService {

    getCvs() {
        return axios.get("http://localhost:8080/api/cvs/getAll")
    }
    add(cv) {
        return axios.post("http://localhost:8080//api/cvs/add", cv)
    }

    getByCvIdForJobSeeker_UserId(cvId) {
        return axios.get("http://localhost:8080/api/cvs/getByCvIdForJobSeeker_UserId?userId" + userId)
    }

    getCvDetails(jobSeekerId) {
        return axios.get("http://localhost:8080/api/cvs/getCvDetails?cvId" + cvId)
    }

}