
import axios from "axios"

export default class LanguageLevelService {

    getLanguageLevels(){
        return axios.get("http://localhost:8080/api/languageLevels/getAll")
    }
}