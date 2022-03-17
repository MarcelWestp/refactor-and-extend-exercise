import React, { useState } from 'react';
import {render, fireEvent, cleanup} from "@testing-library/react"
import {Shallow} from 'enzyme'


export const isValidCar = (car) => {
  if (isNaN(car.year)) { return false; }

  if (car.year.length !== 2 && car.year.length !== 4) { return false; }

  if (car.make.toLowerCase() === "mazda") {
    if (car.year.length === 2) {
      if (parseInt(car.year) < 97 && parseInt(car.year) > 17) {
        return false;
      } else {
        return true;
      }
    } else if (car.year.length === 4) {
      if (parseInt(car.year) < 1997) {
        return false;
      } else {
        return true;
      }
    }
  } else if (car.make.toLowerCase() === "toyota") {
    if (car.year.length === 2) {
      if (parseInt(car.year) >= 6 && parseInt(car.year) <= 18) {
        return false;
      } else if (parseInt(car.year) <= 98) {
        return false;
      } else {
        return true;
      }
    } else if (car.year.length === 4) {
      if (parseInt(car.year) >= 2006) {
        return false;
      } else if (parseInt(car.year) <= 1998) {
        return false;
      } else {
        return true;
      }
    }
  } else {
    return false;
  }
};

const App = () => {
  const [state, setState] = useState({ make: '', year: '', isValid: undefined })
  // state = { make: '', year: '', isValid: undefined }  

    return (
      <div className="App" >
        {state.isValid ? <h2>Valid Vehicle</h2> : <h2>Invalid Vehicle</h2>}
        <label>Make:</label>
        <input type="text" name="make" onChange={(event) => setState({ ...state, make: event.target.value })} />
        <br />
        <label>Year:</label>
        <input type="text" name="year" onChange={(event) => setState({ ...state, year: event.target.value })} />
        <br />
        <button onClick={() => setState({ ...state, isValid: isValidCar({ make: state.make, year: state.year }) })}>Validate</button>
      </div>
    );
  
}

export default App;
