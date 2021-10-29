import axios from 'axios'
import * as actionTypes from '../constants/productsConstants'

export const getProduct=(id)=> async(dispatch)=>{
    try{
        dispatch({
            type: actionTypes.GET_PRODUCT_DETAILS_REQUEST
        });
        const {data}=await axios.get('/products/'+id);
        dispatch({
            type: actionTypes.GET_PRODUCT_DETAILS_REQUEST,
            payload:{
                id:data.id,
                name:data.name,
                description:data.description,
                price:data.price,
                countInStock:data.countInStock,
                imgUrl:data.imgUrl
            }
        });
    }catch(error){
        dispatch(
            {
                type : actionTypes.GET_PRODUCT_DETAILS_FAIL,
                payload: error.data
            }
        );
    }
    

}

export const getAllProducts=()=> async(dispatch)=>{
    
    try{
        dispatch(
            {
                type:actionTypes.GET_PRODUCTS_REQUEST
            }
        );
        const config = {
            headers: {
              'Content-Type': 'application/json'
            },
          };
        const {data} =await axios.get('/products');
        dispatch(
            {
                type:actionTypes.GET_PRODUCTS_SUCCESS,
                payload:data
            }
        );

    }catch(error){
        dispatch(
            {
                type : actionTypes.GET_PRODUCTS_FAIL,
                payload: error.data
            }
        )
    }
}