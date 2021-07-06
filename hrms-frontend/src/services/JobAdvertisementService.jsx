
import axios from "axios"

export default class JobAdvertisementService {

    getJobAdvertisements() {
        return axios.get("/api/jobAdvertisement/getAll")
    }
    closeTheJobAdvertisement(employerId, jobAdvertisementId, status){
        return axios.post("/api/jobAdvertisement/closeTheJobAdvertisement?employerId="+employerId+"&jobAdvertisementId="+jobAdvertisementId+"&status="+status)
    }
    add(jobAdvertisement){
        return axios.get("/api/jobAdvertisement/add",jobAdvertisement)
    }
    getByAdvertisementStatus(status){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getAllActives?status="+status)
    }
    getAllActiveSorted(){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getAllActiveSorted")
    }
    getAllApproveStatus(status){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getAllApproveStatus?status="+status)
    }
    getAllSorted(){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getAllSorted")
    }

    getByEmployerJobAdvertisements(userId){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getByEmployerJobAdvertisements?userId="+userId)
    }

    getJobAdvertisementDetails(){
        return axios.get("http://localhost:8080/api/jobAdvertisement/getJobAdvertisementDetails")
    }
    changeApprovalStatusForJobAdvertisementID(jobAdvertisementID, status){
        return axios.post("http://localhost:8080/api/jobAdvertisement/updateJobAdvertisementSetApprovalStatus?jobAdvertisementId="+jobAdvertisementID+"&status="+status)
    }
    getJobAdvertisementByJobAdvertisementId(jobAdvertisementId) {
        return axios.get("http://localhost:8080/api/jobAdvertisement/getByJobAdvertisementId?id="+jobAdvertisementId)
    }


}