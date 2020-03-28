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

const ComponentMood = {
    data: function() {
        return {
            count: 0
        }
    },
    template: `
        <div class="mood"">
            <div><b>mood</b> {{ title }}</div>
            <div>title = '{{ title }}'</div>
            <div>header = '<slot name="header"></slot>'</div>
        </div>
    `,
    props: {
        title: String
    }
};

let app : Vue = new Vue({
    el: '#app',
    data: {
        message: 'Vue is working!'
    },
    components: {
        'mood' : ComponentMood
    }
});

document.body.appendChild(component());

function sayHello(msg: string) {
    let a: any = app;
    return a.message = msg;
}

export {sayHello, app}

