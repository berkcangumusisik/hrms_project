
import axios from "axios"

export default class JobSeekerService{

    getJobSeeker(){
        return axios.get("http://localhost:8080/api/jobSeekers/getAll")
    }


    register(jobSeeker, passwordAgain, validationCode){
        return axios.post("http://localhost:8080/api/jobSeekers/register?passwordAgain="+passwordAgain+"&validationCode="+validationCode, jobSeeker)
    }

}