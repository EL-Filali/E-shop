import * as actionTypes from '../constants/cartConstats';


export const cartReducer=(state={cartItems:[]},action)=>{
    switch(action.type){
        case actionTypes.ADD_TO_CART:
            const item= action.payload;
            const existItem=state.cartItems.find((x)=> x.product===item.product);
            if(existItem){
                return{
                    ...state,
                    cartItems: state.cartItems.map((x)=>x.product ===existItem.product?item:x)
             }
             }else{
                 return{
                    ...state,
                    cartItems: [...state.carteItems,item]
                 }
             }
            case actionTypes.ROMOVE_FROM_CART:
                 return{
                     ...state,carteItems: state.carteItems.filter((x)=> x.product !== action.payload)
                 }
            default:
                return state;
    }
}