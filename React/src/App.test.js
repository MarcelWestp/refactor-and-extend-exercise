import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import {fireEvent, cleanup} from "@testing-library/react"
import {shallow} from 'enzyme';



describe('App test Component',  () => {
  it('renders learn react link', () => {
  const { getByText } = render(<App />);
  })

  it( 'should App rendern without errors', () => {
    const wrapper = shallow(<App />);
    expect(wrapper.length).toBe(1);
  })

  it( 'should div className="App" rendern without errors', () => {
    const { container } = render(<App/>);
    expect(container.firstChild).toHaveClass('App')
  })

  describe("render <h2>", () => {
    let container;
    let wrapper;

    beforeEach(() => {
      wrapper = shallow(<App />);
      container = wrapper.find("h2");
    });

    it("should have a <h2>", () => {
      expect(container).toHaveLength(1);
    });

    it("should have a <h2> with the properly text", () => {
      expect(container.text()).toEqual("Invalid Vehicle");
    });

  });




});
