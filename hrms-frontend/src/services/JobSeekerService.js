import axios from 'axios'

export default class JobSeekerService{
    getJobSeeker(){
        return axios.get("http://localhost:8080/api/jobseekers/getall")
    }
}