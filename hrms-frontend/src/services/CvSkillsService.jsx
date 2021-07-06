import axios from "axios"

export default class CvSkillService {

    getCvSkills() {
        return axios.get("http://localhost:8080/api/cvSkill/getall")

    }
    add(cvSkill){
        return axios.post("http://localhost:8080/api/cvSkill/add", cvSkill)
    }
}