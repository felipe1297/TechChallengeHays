import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://ec2-54-165-43-104.compute-1.amazonaws.com:8080',
});

export default instance;
