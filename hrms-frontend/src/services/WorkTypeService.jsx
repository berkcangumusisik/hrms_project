import axios from "axios"

export default class WorkTypeService {

    getWorkTypes() {
        return axios.get("http://localhost:8080/api/workType/getAll")

    }
}