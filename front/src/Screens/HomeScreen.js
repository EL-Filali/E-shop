import React from 'react'
import Product from '../components/Product'
import { useSelector,useDispatch } from 'react-redux'
import { useEffect } from 'react'
import { getAllProducts } from '../redux/actions/productActions'



const HomeScreen = () => {
    const dispatch=useDispatch();
    const products = useSelector((state) => state.products);
    const {  loading, productsList, error } = products;
    useEffect(() => {
        dispatch(getAllProducts())
    }, [dispatch])

    return (
         <div className="homescreen">
      <h2 className="homescreen__title">Latest Products</h2>
      <div className="homescreen__products">
        {loading ? (
          <h2>Loading...</h2>
        ) : error ? (
          <h2>{error}</h2>
        ) : (
          
            productsList.map(product => <Product  
                key={product.id}
                 id={product.id}
                 name={product.name}
                 price={product.price}
                 description={product.description}
                 imgUrl={product.imgUrl}
                 />)
          )
        }
      </div>
    </div>
              
    );     
            }
export default HomeScreen ;
