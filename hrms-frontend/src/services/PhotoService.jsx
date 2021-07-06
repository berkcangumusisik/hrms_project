import axios from "axios"

export default class PhotoService {

    getPhotos() {
        return axios.get("http://localhost:8080/api/photo/getAll")

    }
    getPhotoForCvId(cvId){
        return axios.get("http://localhost:8080/api/photo/getByPhotoForCvId?cvId="+cvId)
    }

}