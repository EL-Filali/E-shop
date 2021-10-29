import axios from 'axios'
import * as actionTypes from '../constants/cartConstats'


export  const addToCart =(id,qty)=> async(dispatch)=>{
    const {data} =await axios.get('/products/'+id);
    dispatch({
        type: actionTypes.ADD_TO_CART,
        payload:{
            name: data.name,
            imgUrl: data.price,
            countInStock: data.countInStock,
            qty
        }
       
    })

    localStorage.setItem("cart",JSON.stringify(getState().cart))
}

export  const removeFromCart =(id,qty)=> (dispatch, getState)=>{
    const {data } =await axios.get('/products/${id}');
    dispatch({
        type: actionTypes.ROMOVE_FROM_CART,
        payload:id 
    })

    localStorage.setItem("cart",JSON.stringify(getState().cart))
}