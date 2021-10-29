import React from 'react'
import CartItem from '../components/CartItem'

const CartScreen = () => {
    return (
        <div className="cartscreen">
            <div className="cartscreen__left">
                <h2> shopping cart</h2>
                <CartItem/>
            </div>
            <div className="cartscreen__right">
                <div className="cartscreen__info">
                    <p>subtotal (0) items</p>
                    <p>$499.9</p>
                </div>
                <div>
                    <button>Proceed to checkoi</button>
                </div>
            </div>
        </div>
    )
}

export default CartScreen
