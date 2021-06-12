import axios from 'axios'

export default class CvSkillService{
    getCvSkill(){
        return axios.get("http://localhost:8080/api/cvSkill/getall")
    }
}