import * as actionTypes from '../constants/productsConstants'


export const getProductsReducer=(state={productsList:[]},action)=>{
    const {type,payload }=action;
    switch(type){
        case actionTypes.GET_PRODUCTS_REQUEST:
            return{
                loading:true,
                productsList:[]
            };
        case actionTypes.GET_PRODUCTS_FAIL:
            return{
                loading:false,
                error:payload
            };
        case actionTypes.GET_PRODUCTS_SUCCESS:
            return {
                loading:false,
                productsList:[...payload.content]
            };
        default:
            return state;
    };
}

export const getProductReducer=(state={product:{}},action)=>{
    const {type,payload }=action;
    switch(type){
        case actionTypes.GET_PRODUCT_DETAILS_SUCCESS:
            return{
                loading: false ,
                product:payload
            }
        case actionTypes.GET_PRODUCT_DETAILS_FAIL:
            return{
                loading: false ,
                error:payload
            }
        case actionTypes.GET_PRODUCT_DETAILS_REQUEST:
            return{
                loading: true 
            }
        case actionTypes.GET_PRODUCT_DETAILS_RESET:
            return{
                product: {} 
            }
            
        default:
            return state;
    }
}