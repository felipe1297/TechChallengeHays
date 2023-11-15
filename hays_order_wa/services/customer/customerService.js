import axios from "../axios";

const createCustomer = (customerDto) => {
  return axios.post("/customer", customerDto);
};

const getAllCustomers = () => {
  return axios.get("/customer/all");
};

export { createCustomer, getAllCustomers };
