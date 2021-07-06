
import axios from "axios"

export default class ForeignLanguageService {

    getForeignLanguages() {
        return axios.get("/api/foreignLanguage/getAll")

    }

}