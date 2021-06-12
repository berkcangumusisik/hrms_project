import axios from 'axios'

export default class CurriculumVitaeService{
    getCurriculumVitae(){
        return axios.get("http://localhost:8080/api/jobseekers/getCv")
    }
}