import axios from "axios"

export default class CvLanguageService {

    getCvLanguages() {
        return axios.get("http://localhost:8080/api/cvLanguages/getAll")

    }
    add(cvLanguage){
        return axios.post("http://localhost:8080/api/cvLanguage/add",cvLanguage)
    }
    getCvLanguagesByCvId(cvId) {
        return axios.get("/api/cvForeignLanguage/getCvLanguageDetails?cvId="+cvId)
    }

}