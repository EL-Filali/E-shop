import React from 'react'
import { Link } from 'react-router-dom'
import './Products.css'

const Product = (props) => {
    return (
        <div className="product">
            <img src={props.imgUrl} alt={props.name}/>
            <div className="product__info">
                <p className="info__name">{props.name}</p>
                <p className="info__description">
                {props.description}
                   </p>
                <p className="info__price ">{props.price}</p>
                <Link to={'/product/${id}'} className="info__button"> Add to Cart</Link>
            </div> 
        </div>
    )
}

export default Product;
