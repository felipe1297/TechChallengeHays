"use client";

import React, { useEffect, useState } from "react";
import { getAllParameters } from "../../services/parameter/parameterService";
import ParameterForm from "@/components/parameter/parameterForm";
import ParameterList from "../../components/parameter/parameterList";

export default function ParameterPage() {
  const [parameters, setParameters] = useState([]);

  useEffect(() => {
    getAllParameters()
      .then((response) => {
        setParameters(response.data);
      })
      .catch((error) => {
        console.error("Error get all parameters:", error);
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
          Create parameter
        </h1>

        <ParameterForm />
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
          All Parameters
        </h1>

        <ParameterList parameters={parameters} />
      </div>
    </div>
  );
}
