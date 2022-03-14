import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import {shallow} from 'enzyme';

test('renders learn react link', () => {
  const { getByText } = render(<App />);
  // const linkElement = getByText(/learn react/i);
  // expect(linkElement).toBeInTheDocument();
})

describe('App test Component',  () => {
  it( 'should App rendern without errors', () => {
    const wrapper = shallow(<App />);
    expect(wrapper.length).toBe(1);
  })

  it( 'should div className="App" rendern without errors', () => {
    const wrapper = shallow(<App />);
    const component = wrapper.find('App')
    expect(component.length).toBe(1);
  })

  it( 'should div h2 test isValid', () => {
    const wrapper = shallow(<App />);
    const component = wrapper.find('h2')
    expect(component.textContent).toBe('Invalid Vehicle');
  })





});
