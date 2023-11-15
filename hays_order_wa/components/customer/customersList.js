import React from 'react';
import CustomerCard from './customerCard';

const CustomersList = ({ customers, onCustomerClick  }) => {
  return (
    <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', margin: '10px' }}>
      {customers.map((customer, i) => (
        <CustomerCard onClick={() => onCustomerClick(customer)} key={customer.id} customer={customer} style={i === 0 || i === customers.length - 1 ? { maxWidth: '100%' } : { maxWidth: '300px' }} />
      ))}
    </div>
  );
};

export default CustomersList;
