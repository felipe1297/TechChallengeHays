import React from 'react';
import styles from './HomePage.module.css';

const HomePage = () => {
  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Welcome to Deluxe Pizzeria!</h1>
      <p className={styles.subtitle}>Discover the True Taste of Artisan Pizza</p>
      <p className={styles.description}>
        Embark on a culinary journey with our handcrafted pizzas, made with the freshest ingredients and a touch of tradition. Perfectly baked to delight your senses!
      </p>
    </div>
  );
};

export default HomePage;
