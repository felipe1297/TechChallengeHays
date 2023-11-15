import { createSlice } from "@reduxjs/toolkit";

export const Slice = createSlice({
  name: "order",
  initialState: {
    codePromotion: null,
    orderDto: {
      customer:{},
      customPizzas:[]
    },
    paymentDto: {},
  },
  reducers: {
    saveCustomer: (state, action) => {
      state.orderDto.customer = action.payload;
    },
    addCustomPizza: (state, action) => {
      state.orderDto.customPizzas.push(action.payload);
    },
    saveCodePromotion: (state, action) => {
      state.codePromotion = action.payload;
    },
    savePaymentDto: (state, action) => {
      state.paymentDto = action.payload;
    },
  },
});

export const { saveCustomer, saveCodePromotion, savePaymentDto , addCustomPizza} =
  Slice.actions;
