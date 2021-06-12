import axios from 'axios'

export default class LinkService{
    getLinks(){
        return axios.get("http://localhost:8080/api/link/getall")
    }
}