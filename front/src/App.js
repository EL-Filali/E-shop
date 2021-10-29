import './App.css';
import {BrowserRouter as Router , Switch ,Route} from 'react-router-dom';
import HomeScreen from './Screens/HomeScreen';
import CartScreen from './Screens/CartScreen'
import ProductScreen from './Screens/ProductScreen';


import Navbar from './components/Navbar';
import BackDrop from './components/BackDrop'; 
import SlideDrawer from './components/SlideDrawer';

function App() {
  return (
    <Router>
       <div className="app">
      {/* navbar */}
      <Navbar/>
      {/* slideDrawer */}
      <SlideDrawer/>
      {/* BackDrop */}
      <BackDrop/>
      <main>
        <Switch>
          <Route exact path="/" component={HomeScreen}/>
          <Route exact path="/product/:id" component={ProductScreen}/>
          <Route exact path="" component={CartScreen}/>
          
        </Switch>
      </main>
      {/* HomeScreen */}
      {/* CartScreen*/}
    </div>

    </Router>
   
  );
}

export default App;
