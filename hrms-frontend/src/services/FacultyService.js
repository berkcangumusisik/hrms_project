import axios from 'axios'

export default class FacultyService{
    getFaculties(){
        return axios.get("http://localhost:8080/api/faculty/getall")
    }
}