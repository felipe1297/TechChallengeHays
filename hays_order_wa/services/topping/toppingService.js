import axios from "../axios";

const createIngredient = (toppingDto) => {
  return axios.post("/topping", toppingDto);
};

const getXPizzasByName = (name, limit) => {
  return axios.get(`/topping/name/${name}/${limit}`);
};

const getPizzaById = (id) => {
  return axios.get(`/topping/${id}`);
};

const getAllToppings = () => {
  return axios.get(`/topping/all`);
};

export { createIngredient, getXPizzasByName, getPizzaById , getAllToppings};
