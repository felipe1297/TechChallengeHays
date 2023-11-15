'use client'
import React, { useState } from "react";
import { createPizza } from "../../services/pizza/pizzaService";
import styles from './css/PizzaForm.module.css';
import AreAllPropertiesNonEmpty from '../../common/utils'

export default function ParameterForm() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [pizza, setPizza] = useState({
    name: "",
    basePrice: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setPizza({ ...pizza, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    if(!AreAllPropertiesNonEmpty(parameter)) {
      alert("Complete the form");
      return
    };
    createPizza(pizza)
      .then((response) => {
        console.log("OK");
        window.location.reload();
      })
      .catch((error) => {
        alert("Error: pizza creation fail");
        window.location.reload();
      })
      .finally(() => {
        setIsSubmitting(false); 
      });
  };

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value={pizza.name}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="basePrice">Base price:</label>
        <input
          type="text"
          id="basePrice"
          name="basePrice"
          value={pizza.basePrice}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <button disabled={isSubmitting} className={styles.submitButton} type="submit">Save</button>
      {error && <p className={styles.errorMessage} style={{ color: "red" }}>{error}</p>}
    </form>
  );
}
