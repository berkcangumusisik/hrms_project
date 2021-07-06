import axios from "axios"

export default class WorkTimeTypeService {

    getWorkTimeTypes() {
        return axios.get("http://localhost:8080/api/workTimeType/getAll")

    }
}