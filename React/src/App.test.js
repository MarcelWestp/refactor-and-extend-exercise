import React from "react";
import { render } from "@testing-library/react";
import App, { isValidCar } from "./App";
import { fireEvent, cleanup } from "@testing-library/react";
import Enzyme, { mount, shallow } from "enzyme";
import Adapter from "enzyme-adapter-react-16";
Enzyme.configure({ adapter: new Adapter() });

describe("testing App component", () => {
  it("renders learn react link", () => {
    const { getByText } = render(<App />);
  });

  it("should render App without errors", () => {
    const wrapper = shallow(<App />);
    expect(wrapper.length).toBe(1);
  });

  it('should render div className="App" without errors', () => {
    const { container } = render(<App />);
    expect(container.firstChild).toHaveClass("App");
  });

  describe("render <h2>", () => {
    let container;
    let wrapper;

    beforeEach(() => {
      wrapper = shallow(<App />);
      container = wrapper.find("h2");
    });

    it("should have a <h2> element", () => {
      expect(container).toHaveLength(1);
    });

    it("should have a <h2> element with a text property", () => {
      expect(container.text()).toEqual("Invalid Vehicle");
    });
  });

  describe("isValid function", () => {
    let wrapper;
    beforeEach(() => {
      wrapper = mount(<App />);
    });

    test("with no number", () => {
      //Given
      let invalidCar = { make: "mazda", year: "A" };
      let expected = false;

      //When
      let actual = isValidCar(invalidCar);

      //Then
      expect(actual).toBe(expected);
    });

    test("wrong numberLength", () => {
      //Given
      const invalidCars = [
        { make: "mazda", year: "1" },
        { make: "mazda", year: "11111" },
        { make: "mazda", year: "123" },
      ];
      let expected = false;

      //When     //Then
      invalidCars.forEach((carElement) => {
        let actual = isValidCar(carElement);
        expect(actual).toBe(expected);
      });
    });

    test("wrong make", () => {
      //Given
      let invalidCar = { make: "davidMake", year: "97" };
      let expected = false;

      //When
      let actual = isValidCar(invalidCar);

      //Then
      expect(actual).toBe(expected);
    });

    test("valid make and invalid year", () => {
      //Given
      const invalidCars = [
        { make: "mazda", year: "96" },
        { make: "mazda", year: "1996" },
      ];
      let expected = false;

      //When     //Then
      invalidCars.forEach((carElement) => {
        let actual = isValidCar(carElement);
        expect(actual).toBe(expected);
      });
    });

    test("valid make and valid year", () => {
      //Given
      const invalidCars = [
        { make: "mazda", year: "98" },
        { make: "mazda", year: "1998" },
      ];
      let expected = true;

      //When     //Then
      invalidCars.forEach((carElement) => {
        let actual = isValidCar(carElement);
        expect(actual).toBe(expected);
      });
    });

    test("valid make (toyota) and invalid year", () => {
      //Given
      const invalidCars = [
        { make: "toyota", year: "07" },
        { make: "toyota", year: "96" },
        { make: "toyota", year: "2007" },
        { make: "toyota", year: "1996" },
      ];
      let expected = false;

      //When     //Then
      invalidCars.forEach((carElement) => {
        let actual = isValidCar(carElement);
        expect(actual).toBe(expected);
      });
    });

    test("valid make (toyota) and valid year", () => {
      //Given
      const invalidCars = [
        { make: "toyota", year: "99" },
        { make: "toyota", year: "1999" },
      ];
      let expected = true;

      //When     //Then
      invalidCars.forEach((carElement) => {
        let actual = isValidCar(carElement);
        expect(actual).toBe(expected);
      });
    });
  });
});
