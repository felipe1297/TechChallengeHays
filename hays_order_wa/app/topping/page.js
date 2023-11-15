"use client";

import React, { useEffect, useState } from "react";
import { getAllToppings } from "../../services/topping/toppingService";
import ToppingForm from "@/components/topping/toppingForm";
import ToppingList from "../../components/topping/toppingList";

export default function ToppingPage() {
  const [toppings, setToppings] = useState([]);

  useEffect(() => {
    getAllToppings()
      .then((response) => {
        setToppings(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error get all toppings:", error);
      });
  }, []);

  return (
    <div style={{ display:"flex" , flexDirection:"column", gap:"30px"}}>
      <div>
        <h1
          style={{
            color: "#0056b3",
            fontWeight: "bold",
            fontSize: "2rem",
            textTransform: "uppercase",
            textAlign: "center",
            margin:"30px"
          }}
        >
          Create topping
        </h1>

        <ToppingForm />
      </div>
      <div>
        <h1
          style={{
            color: "#0056b3",
            fontWeight: "bold",
            fontSize: "2rem",
            textTransform: "uppercase",
            textAlign: "center",
          }}
        >
          All Toppings
        </h1>

        <ToppingList toppings={toppings} selectedToppings={[]} />
      </div>
    </div>
  );
}
