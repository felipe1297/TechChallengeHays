"use client";

import React, { useEffect, useState } from "react";
import { getAllCustomers } from "../../services/customer/customerService";
import CustomersList from "../../components/customer/customersList";
import CustomerForm from "@/components/customer/customerForm";

export default function CustomersPage() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    getAllCustomers()
      .then((response) => {
        setCustomers(response.data);
      })
      .catch((error) => {
        console.error("Error get all customers:", error);
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
          Create customer
        </h1>

        <CustomerForm />
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
          All Customers
        </h1>

        <CustomersList customers={customers} />
      </div>
    </div>
  );
}
