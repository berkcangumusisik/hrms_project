import axios from 'axios'

export default class CvExperienceService{
    getCvExperience(){
        return axios.get("http://localhost:8080/api/cvExperiences/getall")
    }
}