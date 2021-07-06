import axios from "axios"

export default class SystemUserService {

    getSystemUsers(){
        return axios.get("http://localhost:8080/api/systemUser/getAll")
    }
    add(systemUser){
        return axios.post("http://localhost:8080/api/systemUser/register", systemUser)
    }
}