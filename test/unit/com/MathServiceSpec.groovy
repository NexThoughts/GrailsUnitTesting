package com

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(MathService)
class MathServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

//        @IgnoreRest
    @Unroll("Going to Test  Add #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math adding operation of Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        Long finalResult = service.addTwoNumber(number1, number2)

        then:

        finalResult == (result as Long)

        where:
        sno | num1 | num2 | result
        1   | 10   | 15   | 25
        2   | 108  | 954  | 1062
        3   | 200  | 300  | 500
    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test Multiply #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Multiply operation of Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        Long finalResult = service.multiplyTwoNumber(number1, number2)

        then:

        finalResult == (result as Long)

        where:
        sno | num1 | num2 | result
        1   | 15   | 10   | 150
        2   | 108  | 954  | 103032
        3   | 300  | 200  | 60000
        4   | 985  | 200  | 197000

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test Divide #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Divide operation of Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        Long finalResult = service.divideTwoNumber(number1, number2)

        then:

        finalResult == (result as Long)

        where:
        sno | num1  | num2 | result
        1   | 15    | 10   | 1
        2   | 108   | 954  | 0
        3   | 300   | 200  | 1
        4   | 98500 | 200  | 492

    }

    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test Interest #sno for Principle: #principles, Rate: #rates, Time: #times and Result: #result")
    void "test math Interest operation of Service"() {
        when:
        Long principle = principles as Long
        Long rate = rates as Long
        Long time = times as Long
        def otherService = mockFor(OtherService)
        otherService.demandExplicit.multiplyTwoNumber(principle, rate, time) { Long num1, Long num2, Long num3 ->
            return num1 * num2 * num3
        }

        otherService.demandExplicit.divideTwoNumber(1,1) { Long num1, Long num2->
            return (principle * rate * time) / 100
        }

        service.otherService = otherService.createMock()
        Long finalResult = service.interest(principle, rate, time)

        then:

        finalResult == (result as Long)

        where:
        sno | principles | rates | times | result
        1   | 1500       | 10    | 1     | 150
        2   | 10800      | 67    | 5     | 36180
        3   | 30000      | 105   | 3     | 94500
        4   | 98500      | 20    | 4     | 78800
    }
}
