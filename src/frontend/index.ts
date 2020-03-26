import Vue from 'vue';
import './styles/main.scss';
import Icon from './assets/house.svg';
import './index.html';

function component() {
    function createImage() {
        const myIcon: HTMLImageElement = new Image(200, 200);
        myIcon.src = Icon;
        return myIcon;
    }

    const result: HTMLElement = document.createElement("div");
    result.appendChild(createImage());
    return result;
}

let app = new Vue({
    el: '#app',
    data: {
        message: 'Vue is working!'
    }
});


document.body.appendChild(component());

