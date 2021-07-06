
import axios from "axios"

export default class SectionService {

    getSections(){
        return axios.get("http://localhost:8080/api/languageLevels/getAll")
    }
}