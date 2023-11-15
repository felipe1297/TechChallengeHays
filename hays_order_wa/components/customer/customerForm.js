'use client'
import React, { useState } from "react";
import { createCustomer } from "../../services/customer/customerService";
import styles from './css/CustomerForm.module.css';
import AreAllPropertiesNonEmpty from '../../common/utils'

export default function CustomerForm() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [customer, setCustomer] = useState({
    address: "",
    email: "",
    id: "",
    name: "",
    number: "",
    password: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setCustomer({ ...customer, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    if(!AreAllPropertiesNonEmpty(customer)) {
      alert("Complete the form");
      return
    };
    createCustomer(customer)
      .then((response) => {
        console.log("OK");
        window.location.reload();
      })
      .catch((error) => {
        alert("Error: customer creation fail");
        window.location.reload();
      })
      .finally(() => {
        setIsSubmitting(false);
      });
  };

  const emailRegex = /\S+@\S+\.\S+/;
  const isEmailValid = emailRegex.test(customer.email);

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value={customer.name}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="email">Email:</label>
        <input className={styles.inputField}
          type="email"
          id="email"
          name="email"
          value={customer.email}
          onChange={handleChange}
        />
        {!isEmailValid && <p style={{ marginTop:"5px" , color: "red" }}>Email invalid</p>}
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="address">Address:</label>
        <input
          type="text"
          id="address"
          name="address"
          value={customer.address}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="id">ID:</label>
        <input
          type="text"
          id="id"
          name="id"
          value={customer.id}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="number">Number:</label>
        <input
          type="text"
          id="number"
          name="number"
          value={customer.number}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="password">Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={customer.password}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <button disabled={isSubmitting} className={styles.submitButton} type="submit">Save</button>
      {error && <p className={styles.errorMessage} style={{ color: "red" }}>{error}</p>}
    </form>
  );
}
