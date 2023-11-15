'use client'
import React, { useState } from "react";
import { createParameter } from "../../services/parameter/parameterService";
import styles from './css/ParameterForm.module.css';
import AreAllPropertiesNonEmpty from '../../common/utils'

export default function ParameterForm() {
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [parameter, setParameter] = useState({
    id: "",
    name: "",
    type: "",
    value: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setParameter({ ...parameter, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    if(!AreAllPropertiesNonEmpty(parameter)) {
      alert("Complete the form");
      return
    };
    createParameter(parameter)
      .then((response) => {
        console.log("OK");
        window.location.reload();
      })
      .catch((error) => {
        alert("Error: parameter creation fail");
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
          value={parameter.name}
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
          value={parameter.type}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <div className={styles.divField}>
        <label className={styles.labelField} htmlFor="value">Value:</label>
        <input
          type="text"
          id="value"
          name="value"
          value={parameter.value}
          onChange={handleChange}
          className={styles.inputField}
        />
      </div>
      <button disabled={isSubmitting} className={styles.submitButton} type="submit">Save</button>
      {error && <p className={styles.errorMessage} style={{ color: "red" }}>{error}</p>}
    </form>
  );
}
