import React from 'react'
import './SlideDrawer.css'
import { Link } from 'react-router-dom'
const SlideDrawer = () => {
    return (
        <div className="slidedrawer">
            <ul className="sidedrawer__links">
                <li>
                <Link to="/cart">
                    <i className="fas fa-shopping-cart"></i>
                    <span>
                        Cart <span  className="sidedrawer__cartbadge" >0</span>
                    </span>s
                </Link>
                </li>
                <li>
                    <Link to="/">Shop</Link>
                </li>
            </ul>
        </div>
    )
}

export default SlideDrawer
 