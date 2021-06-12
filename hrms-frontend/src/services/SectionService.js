import axios from 'axios'

export default class SectionService{
    getSection(){
        return axios.get("http://localhost:8080/api/section/getall")
    }
}

