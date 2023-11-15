import axios from "../axios";

const createOrder = (orderDtoApi) => {
  return axios.post("/order", orderDtoApi);
};

const getAllOrders = () => {
  return axios.get("/order/all");
};

const getOrdersByCustomer = (customerId) => {
  return axios.get("/order/customer", { params: { customerId } });
};

const getOrderById = (id) => {
  return axios.get(`/order/${id}`);
};

export { createOrder, getAllOrders, getOrdersByCustomer, getOrderById };
