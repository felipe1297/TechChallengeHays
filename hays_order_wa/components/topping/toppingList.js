import React from 'react';
import ToppingCard from './toppingCard';

const ToppingList = ({ toppings, onToppingClick , selectedToppings }) => {
  return (
    <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', margin: '10px' }}>
      {toppings.map((topping, i) => (
        <ToppingCard isSelected={selectedToppings.some(selected => selected.id === topping.id)} onClick={() => onToppingClick(topping)} key={topping.id} topping={topping} style={i === 0 || i === topping.length - 1 ? { maxWidth: '100%' } : { maxWidth: '300px' }} />
      ))}
    </div>
  );
};

export default ToppingList;
