import axios from 'axios'

export default class CvEducationService{
    getCvEducation(){
        return axios.get("http://localhost:8080/api/cvEducation/getall")
    }
}