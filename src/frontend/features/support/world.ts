import { setWorldConstructor } from "cucumber";

/*
 A new World instance is created for each Cucumber scenario and shared across steps.
 */
class World {
    // noinspection JSUnusedGlobalSymbols
    public readonly WORLD_NAME = "Spring Practice Frontend World";
}


setWorldConstructor(World);