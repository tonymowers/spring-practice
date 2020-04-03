import { describe } from 'mocha'
import { assert } from 'chai'
import greeting from '@/utils/greeting'

describe('Greeting', function() {
    describe('#content', function() {
        it('greeting should be \'Hello world!\'', function() {
            assert.equal(greeting(),"Hello World!")
        });
    });
});

