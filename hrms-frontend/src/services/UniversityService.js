import axios from 'axios'

export default class UniversityService{
    getUniversities(){
        return axios.get("http://localhost:8080/api/university/getall")
    }
}