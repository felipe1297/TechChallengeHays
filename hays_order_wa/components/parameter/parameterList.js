import React from 'react';
import ParameterCard from './parameterCard';

const ParameterList = ({ parameters, onParameterClick }) => {
  return (
    <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', margin: '10px' }}>
      {parameters.map((parameter, i) => (
        <ParameterCard onClick={() => onParameterClick(parameter)} key={parameter.id} parameter={parameter}  style={i === 0 || i === parameter.length - 1 ? { maxWidth: '100%' } : { maxWidth: '300px' }} />
      ))}
    </div>
  );
};

export default ParameterList;
