import axios from "axios"

export default class JobPositionService {

    getJobPositions() {
        return axios.get("http://localhost:8080/api/jobPositions/getAll")
    }

    add(jobPosition) {
        return axios.post("http://localhost:8080/api/jobPositions/add",jobPosition)
    }

}