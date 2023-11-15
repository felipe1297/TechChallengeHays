import React from 'react';
import PizzaCard from './pizzaCard';

const PizzaList = ({ pizzas, onPizzaClick  }) => {
  return (
    <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', margin: '10px' }}>
      {pizzas.map((pizza, i) => (
        <PizzaCard onClick={() => onPizzaClick(pizza)} key={pizza.id} pizza={pizza} style={i === 0 || i === pizza.length - 1 ? { maxWidth: '100%' } : { maxWidth: '300px' }} />
      ))}
    </div>
  );
};

export default PizzaList;
