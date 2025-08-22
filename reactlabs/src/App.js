import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';  // ✅ Bootstrap import
import './App.css';

// Assignment imports
import GroceryApp from "./GroceryApp"; 
import Car from "./Car";            
import Phone from "./Phone";        
import SweetList from "./SweetList"; 
import Electronics from "./Electronics"; 
import CanteenMenu from "./CanteenMenu"; 
import JuiceList from "./JuiceList";
import Restaurant from "./Restaurant";
import TempleList from "./TempleList"; 
import TailorShop from "./TailorShop"; 
import Fruits from "./Fruits";
import TelevisionManager from "./TelevisionManager";
import MarriageForm from "./MarriageForm";
import AccessoriesForm from "./AccessoriesForm";
import BakingItemsForm from "./BakingItemsForm";
import App15 from "./App15";
import MovieForm from "./MovieForm";
import ConditionalRenderingApp from "./ConditionalRenderingApp";

// ✅ New import for Furniture Store
import FurnitureStore from "./FurnitureComponents";

function App() {
  return (
    <div className="App container mt-4">
      <h1 className="text-center mb-4">React Assignments</h1>

      <GroceryApp />
      <Car brand="Hyundai" model="Verna" color="Black" year="2025" />
      <Phone />
      <SweetList />
      <Electronics />
      <CanteenMenu />
      <JuiceList />
      <Restaurant />
      <TempleList />
      <TailorShop />
      <Fruits />
      <TelevisionManager />
      <MarriageForm />
      <AccessoriesForm />
      <BakingItemsForm />
      <App15 />
      <MovieForm />
      <ConditionalRenderingApp />

      
      <FurnitureStore />
    </div>
  );
}

export default App;
