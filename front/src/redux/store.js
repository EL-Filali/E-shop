import { createStore,combineReducers,applyMiddleware } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";
import { cartReducer} from './reducers/cartReducers';
import {getProductReducer,getProductsReducer} from './reducers/productReducers'
const reducer=combineReducers({
    cart:cartReducer,
    product:getProductReducer,
    products:getProductsReducer
});

const middleware=[thunk];
const store = createStore(
    reducer,
    composeWithDevTools(applyMiddleware(...middleware))
);

export default store;