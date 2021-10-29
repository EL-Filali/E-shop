import React from 'react'
import './ProductScreen.css'
const ProductScreen = () => {
    return (
        <div className="productscreen">
            <div className="productscreen__left">
                <div className="left__image">
                    <img src="" alt=""/>

                </div>
                <div className="left__info">
                    <p className="left__name">PlayStation</p>
                </div>
            </div>
            <div className="productscreen__right">
                <div className="right__info">
                    <p>
                        Price:<span>$499.2</span>
                    </p>
                    <p>
                        Status:<span>In Stock</span>
                    </p>
                    <p>
                        Qty
                        <select>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </p>
                    <p>
                        <button type="button"> add to cart</button>
                    </p>
                </div>
            </div>
        </div>
    )
}

export default ProductScreen
