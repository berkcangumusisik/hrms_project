import axios from 'axios'

export default class PhotographService{
    getPhotographs(){
        return axios.get("http://localhost:8080/api/photograph/getall")
    }
}

