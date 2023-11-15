'use client'
import React, { useState } from "react";
import { createIngredient } from "../../services/topping/toppingService";
import styles from './css/ToppingForm.module.css';
import AreAllPropertiesNonEmpty from '../../common/utils'

export default function ToppingForm() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [topping, setTopping] = useState({
    id: "",
    name: "",
    type: "",
    available: "",
    price: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setTopping({ ...topping, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    if(!AreAllPropertiesNonEmpty(parameter)) {
      alert("Complete the form");
      return
    };
    createIngredient(topping)
      .then((response) => {
        console.log("OK");
        window.location.reload();
      })
      .catch((error) => {
        alert("Error: topping creation fail");
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
          value={topping.name}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="type">Type:</label>
        <input
          type="text"
          id="type"
          name="type"
          value={topping.type}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="available">Available:</label>
        <input
          type="text"
          id="available"
          name="available"
          value={topping.available}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="price">Price:</label>
        <input
          type="number"
          id="price"
          name="price"
          value={topping.price}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <button disabled={isSubmitting} className={styles.submitButton} type="submit">Save</button>
      {error && <p className={styles.errorMessage} style={{ color: "red" }}>{error}</p>}
    </form>
  );
}
