import Vue from 'vue';
import './styles/main.scss';
import Icon from './assets/house.svg';
import './index.html';
import MoodComponent from "./components/mood.vue";

export {app}

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
        moods: [
            { id: 1, name: "Happy"},
            { id: 2, name: "Sad"},
            { id: 3, name: "Angry"}
        ]
    },
    components: {
        'mood' : MoodComponent
    }
});

document.body.appendChild(component());


