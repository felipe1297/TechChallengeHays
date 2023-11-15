import axios from "../axios";

const createPizza = (pizzaDto) => {
  return axios.post("/pizza", pizzaDto);
};

const getXPizzasByName = (name, limit) => {
  return axios.get(`/pizza/name/${name}/${limit}`);
};

const getAllPizzas = () => {
  return axios.get(`/pizza/all`);
};

const getPizzaById = (id) => {
  return axios.get(`/pizza/${id}`);
};

export { createPizza, getXPizzasByName, getPizzaById , getAllPizzas};
