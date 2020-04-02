import { Given, Then, When } from 'cucumber'
import testLoading from '@/utils/test_loading'

Given('a new user', function () {
    // Write code here that turns the phrase above into concrete actions
    console.log(testLoading());
});

When('the user starts using the application', function () {
    // Write code here that turns the phrase above into concrete actions

});

Then('the user should be greeted with {string}', function (a: string) {
    console.log('greeting:' + a)

});
