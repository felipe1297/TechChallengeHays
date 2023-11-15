"use client";

import React, { useEffect, useState } from "react";
import {
  getCrustTypesParameter,
  getSizeTypesParameter,
} from "../../services/parameter/parameterService";
import { getAllCustomers } from "../../services/customer/customerService";
import { getAllPizzas } from "../../services/pizza/pizzaService";
import { getAllToppings } from "../../services/topping/toppingService";
import { createOrder } from "../../services/order/orderService";
import ParameterList from "../../components/parameter/parameterList";
import CustomersList from "../../components/customer/customersList";
import PizzaList from "@/components/pizza/pizzaList";
import ToppingList from "@/components/topping/toppingList";
import style from "./css/OrderPage.module.css";

const OrderPage = () => {
  const [crustTypes, setCrustTypes] = useState([]);
  const [sizeTypes, setSizeTypes] = useState([]);
  const [customers, setCustomers] = useState([]);
  const [pizzas, setPizzas] = useState([]);
  const [toppings, setToppings] = useState([]);

  const [showParametersCrust, setShowParametersCrust] = useState(false);
  const [selectedParameterCrust, setSelectedParameterCrust] = useState(null);

  const [showParametersSize, setShowParametersSize] = useState(false);
  const [selectedParameterSize, setSelectedParameterSize] = useState(null);

  const [showCustomer, setShowCustomer] = useState(false);
  const [selectedCustomer, setSelectedCustomer] = useState(null);

  const [showPizza, setShowPizza] = useState(false);
  const [selectedPizza, setSelectedPizza] = useState(null);

  const [showTopping, setShowTopping] = useState(false);
  const [selectedTopping, setSelectedTopping] = useState([]);

  const fetchData = async () => {
    try {
      const customerResponse = await getAllCustomers();
      setCustomers(customerResponse.data);

      const crustResponse = await getCrustTypesParameter();
      setCrustTypes(crustResponse.data);

      const sizeResponse = await getSizeTypesParameter();
      setSizeTypes(sizeResponse.data);

      const pizzasResponse = await getAllPizzas();
      setPizzas(pizzasResponse.data);

      const toppingResponse = await getAllToppings();
      setToppings(toppingResponse.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleToppingsClick = (topping) => {
    if (selectedTopping.some((selected) => selected.id === topping.id)) {
      setSelectedTopping(
        selectedTopping.filter((selected) => selected.id !== topping.id)
      );
    } else {
      setSelectedTopping([...selectedTopping, topping]);
    }
  };

  const handlePizzaClick = (pizza) => {
    setSelectedPizza(pizza);
    setShowPizza(false);
  };

  const handleCustomerClick = (customer) => {
    setSelectedCustomer(customer);
    setShowCustomer(false);
  };

  const handleParameterClickCrust = (parameter) => {
    setSelectedParameterCrust(parameter);
    setShowParametersCrust(false);
  };

  const handleParameterClickSize = (parameter) => {
    setSelectedParameterSize(parameter);
    setShowParametersSize(false);
  };

  const resetStates = () => {
    setShowTopping(false);
    setSelectedTopping([]);

    setShowPizza(false);
    setSelectedPizza(null);

    setShowCustomer(false);
    setSelectedCustomer(null);

    setShowParametersCrust(false);
    setSelectedParameterCrust(null);

    setShowParametersSize(false);
    setSelectedParameterSize(null);
  };

  const sentOrder = () => {
    const total =
      (selectedPizza.basePrice +
        selectedTopping.reduce((sum, item) => sum + (item.price || 0), 0)) *
      (1 + selectedParameterCrust.value + selectedParameterSize.value);

    console.log((1 + selectedParameterCrust.value + selectedParameterSize.value));
    const paymentDto = {
      status: "Completed",
      amount: total,
      finalAmount: total,
      date: new Date(),
    };
    const orderDto = {
      customer: selectedCustomer,
      customPizzas: [
        {
          pizza: selectedPizza,
          toppings: selectedTopping,
          size: selectedParameterSize,
          crust: selectedParameterCrust,
        },
      ],
    };
    const order = {
      orderDto,
      paymentDto,
    };

    createOrder(order)
      .then((response) => {
        alert("Orden enviada, total: " + total);
      })
      .catch((error) => {
        console.error("Error to create order:", error);
      })
      .finally(() => {
        window.location.reload();
      });
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <div className={style.divOrder}>
        <h1 className={style.titleList}>Crust type</h1>
        <button
          className={style.buttonList}
          onClick={() => setShowParametersCrust(!showParametersCrust)}
        >
          {showParametersCrust ? "Hide cruts types" : "Show crust types"}
        </button>

        {showParametersCrust && (
          <ParameterList
            parameters={[...crustTypes]}
            onParameterClick={handleParameterClickCrust}
          />
        )}

        {selectedParameterCrust && (
          <div className={style.selectedOption}>
            Selected crust: {selectedParameterCrust.name}
          </div>
        )}
      </div>
      <div className={style.divOrder}>
        <h1 className={style.titleList}>Size type</h1>
        <button
          className={style.buttonList}
          onClick={() => setShowParametersSize(!showParametersSize)}
        >
          {showParametersSize ? "Hide size types" : "Show size types"}
        </button>

        {showParametersSize && (
          <ParameterList
            parameters={[...sizeTypes]}
            onParameterClick={handleParameterClickSize}
          />
        )}

        {selectedParameterSize && (
          <div className={style.selectedOption}>
            Selected size type: {selectedParameterSize.name}
          </div>
        )}
      </div>
      <div className={style.divOrder}>
        <h1 className={style.titleList}>Customers</h1>
        <button
          className={style.buttonList}
          onClick={() => setShowCustomer(!showCustomer)}
        >
          {showCustomer ? "Hide customer list" : "Show customer list"}
        </button>

        {showCustomer && (
          <CustomersList
            customers={[...customers]}
            onCustomerClick={handleCustomerClick}
          />
        )}

        {selectedCustomer && (
          <div className={style.selectedOption}>
            Selected customer: {selectedCustomer.name}
          </div>
        )}
      </div>

      <div className={style.divOrder}>
        <h1 className={style.titleList}>Pizza</h1>
        <button
          className={style.buttonList}
          onClick={() => setShowPizza(!showPizza)}
        >
          {showPizza ? "Hide pizza list" : "Show pizza list"}
        </button>

        {showPizza && (
          <PizzaList pizzas={[...pizzas]} onPizzaClick={handlePizzaClick} />
        )}

        {selectedPizza && (
          <div className={style.selectedOption}>
            Selected pizza: {selectedPizza.name}
          </div>
        )}
      </div>

      <div className={style.divOrder}>
        <h1 className={style.titleList}>Toppings</h1>
        <button
          onClick={() => setShowTopping(!showTopping)}
          className={style.buttonList}
        >
          {showTopping ? "Hide Toppings" : "Show Toppings"}
        </button>

        {showTopping && (
          <ToppingList
            toppings={[...toppings]}
            onToppingClick={handleToppingsClick}
            selectedToppings={selectedTopping}
          />
        )}

        <div className={style.selectedOption}>
          Selected Toppings:
          {selectedTopping.map((param) => (
            <div key={param.id}>{param.name}</div>
          ))}
        </div>
      </div>

      <div>
        <button className={style.buttonCancel} onClick={resetStates}>
          Cancel
        </button>
        <button className={style.buttonAddToCar} onClick={sentOrder}>
          Order
        </button>
      </div>
    </div>
  );
};

export default OrderPage;
