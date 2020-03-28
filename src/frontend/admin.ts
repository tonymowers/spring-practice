import Icon from "./assets/bike.svg";
import './admin.html';

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

document.body.appendChild(component())

function doAdmin() {
    console.log("admin message")
}

export { doAdmin }