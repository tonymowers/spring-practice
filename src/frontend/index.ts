import Vue from 'vue';
import './styles/main.scss';
import Icon from './assets/house.svg';
import './index.html';

function component() {
    function createImage() {
        const myIcon: HTMLImageElement = new Image(300, 300);
        myIcon.src = Icon;
        return myIcon;
    }

    const result: HTMLElement = document.createElement("div");
    result.appendChild(createImage());
    return result;
}

let app : Vue = new Vue({
    el: '#app',
    data: {
        message: 'Vue is working!'
    }
});

document.body.appendChild(component());

function sayHello(msg: string) {
    let a: any = app;
    return a.message = msg;
}
export { app, sayHello }

