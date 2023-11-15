import axios from "../axios";

const getParameterByType = (type) => {
  return axios.get("/parameter", { params: { type } });
};

const createParameter = (parameterDto) => {
  return axios.post("/parameter", parameterDto);
};

const getAllParameters = () => {
  return axios.get("/parameter/all");
};

const getCrustTypesParameter = () => {
  return axios.get("/parameter/crust");
};

const getSizeTypesParameter = () => {
  return axios.get("/parameter/size");
};

const getParameterById = (id) => {
  return axios.get(`/parameter/${id}`);
};

export {
  getParameterByType,
  createParameter,
  getAllParameters,
  getCrustTypesParameter,
  getSizeTypesParameter,
  getParameterById,
};
