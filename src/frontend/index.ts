import * as _ from 'lodash';
import './styles/main.scss';
import Icon from './assets/house.svg';

function createGreeting() {
    const element: HTMLElement = document.createElement('span');
    element.innerHTML = _.join([new Greeter().greet(), 'I wish you a very good day.'], ' ');
    return element;
}

function createImage() {
    const myIcon: HTMLImageElement = new Image(200, 200);
    myIcon.src = Icon;
    return myIcon;
}

function component() {
    const result: HTMLElement = document.createElement("div");
    result.appendChild(createGreeting());
    result.appendChild(createImage());

    return result;
}



class Greeter {
    private greeting: string = "Hello world!";

    greet() {
        return this.greeting;
    }
}

document.body.appendChild(component());