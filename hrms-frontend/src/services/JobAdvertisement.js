import axios from 'axios'

export default class JobAdvertisementsService{
    getJobAdvertisement(){
        return axios.get("http://localhost:8080/api/jobadvertisements/getall")
    }
}