import { Given, Then, When } from 'cucumber'
import { expect } from 'chai'
import greeting from '@/utils/greeting'

Given('a new user', function () {
    console.log(this.WORLD_NAME);
});

When('the user starts using the application', function () {
    // Write code here that turns the phrase above into concrete actions

});

Then('the user should be greeted with {string}', function (msg: string) {
    expect(msg).to.equal(greeting())
});
