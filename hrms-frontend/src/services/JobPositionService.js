import axios from 'axios'

export default class JobPositionService{
    getJobPosition(){
        return axios.get("http://localhost:8080/api/jobpositions/getall")
    }
}