import React from 'react'
import { Link } from 'react-router-dom'
import './CartItem.css'

const CartItem = () => {
    return (
        <div className="cartitem">
            <div className="cartitem__img">
                <img src="" alt="product name"/>
            </div>
            <Link to={'/product/${111}'} className="cartitem__name">
                <p>Product 1</p>
            </Link>

            <p className="cartitem__price">499.99</p>
            <select className="cartitem__select">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <button className="cartitem__deleteBtn">
                <i className="fas fa-trash"></i>
            </button>
        </div>
    )
}

export default CartItem
