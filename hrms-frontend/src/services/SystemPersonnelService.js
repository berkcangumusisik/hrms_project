import axios from 'axios'

export default class SystemPersonnelService{
    getPersonnel(){
        return axios.get("http://localhost:8080/api/systempersonnel/getall")
    }
}