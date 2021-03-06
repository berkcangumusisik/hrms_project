import axios from 'axios';

export default class EmployerService{
    getEmployers(){
        return axios.get("http://localhost:8080/api/employers/getall")
    }
    
    register(employer, passwordAgain) {
        return axios.post("http://localhost:8080//api/employers/register?passwordAgain="+passwordAgain, employer)

    }
    login(email,password){
        return axios.post("http://localhost:8080/api/employers/login?email=" + email + "&password=" + password)
    }
    getAllEmployerByVerificationStatus(status){
        return axios.get("http://localhost:8080/api/employers/getAllEmployerByVerificationStatus?status="+status)
   }
}