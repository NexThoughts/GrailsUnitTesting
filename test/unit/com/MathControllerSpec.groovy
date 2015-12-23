package com

import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(MathController)
class MathControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
//    @Ignore
//    @IgnoreRest
    void "test Simple render"() {
        when:
        controller.index()

        then:
        view == '/math/index'
        model.title == 'Math Operation'
    }

//    @Ignore
//        @IgnoreRest
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math adding operation without Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2
        controller.addWithoutService()

        then:

        response.text == "" + result

        where:
        sno | num1 | num2 | result
        1   | 10   | 15   | 25
        2   | 108  | 954  | 1062
        3   | 200  | 300  | 500

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Multiply operation Without Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2
        controller.multipleWithoutService()

        then:

        response.text == "" + result

        where:
        sno | num1 | num2 | result
        1   | 15   | 10   | 150
        2   | 108  | 954  | 103032
        3   | 300  | 200  | 60000
        4   | 985  | 200  | 197000

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Divide operation Without Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2
        controller.divideWithoutService()

        then:

        response.text == "" + result

        where:
        sno | num1  | num2 | result
        1   | 15    | 10   | 1
        2   | 108   | 954  | 0
        3   | 300   | 200  | 1
        4   | 98500 | 200  | 492

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Principle: #principles, Rate: #rates, Time: #times and Result: #result")
    void "test math Interest operation Without Service"() {
        when:
        Long principle = principles as Long
        Long rate = rates as Long
        Long time = times as Long
        params.principle = principle
        params.rate = rate
        params.time = time
        controller.interestWithoutService()

        then:

        response.text == "" + result

        where:
        sno | principles | rates | times | result
        1   | 1500       | 10    | 1     | 150
        2   | 10800      | 67    | 5     | 36180
        3   | 30000      | 105   | 3     | 94500
        4   | 98500      | 20    | 4     | 78800

    }

//    @IgnoreRest
    void "test math redirect"() {
        when:
        controller.testingRedirect()

        then:
        response.redirectUrl == '/math/index'
    }

    //    @Ignore
        @IgnoreRest
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math adding operation with Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2

        def mathService = mockFor(MathService)

        mathService.demandExplicit.addTwoNumber(number1, number2) { Long num1, Long num2 ->
            return num1 + num2
        }

        controller.mathService = mathService.createMock()
        controller.addWithService()

        then:

        response.text == "" + result

        where:
        sno | num1 | num2 | result
        1   | 10   | 15   | 25
        2   | 108  | 954  | 1062
        3   | 200  | 300  | 500

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Multiply operation with Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2

        def mathService = mockFor(MathService)

        mathService.demandExplicit.multiplyTwoNumber(number1, number2) { Long num1, Long num2 ->
            return num1 * num2
        }

        controller.mathService = mathService.createMock()
        controller.multipleWithService()

        then:

        response.text == "" + result

        where:
        sno | num1 | num2 | result
        1   | 15   | 10   | 150
        2   | 108  | 954  | 103032
        3   | 300  | 200  | 60000
        4   | 985  | 200  | 197000

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Num1: #num1 and Num2: #num2 and Result: #result")
    void "test math Divide operation with Service"() {
        when:
        Long number1 = num1 as Long
        Long number2 = num2 as Long
        params.num1 = number1
        params.num2 = number2

        def mathService = mockFor(MathService)

        mathService.demandExplicit.divideTwoNumber(number1, number2) { Long num1, Long num2 ->
            return num1 / num2
        }

        controller.mathService = mathService.createMock()
        controller.divideWithService()

        then:

        response.text == "" + result

        where:
        sno | num1  | num2 | result
        1   | 15    | 10   | 1
        2   | 108   | 954  | 0
        3   | 300   | 200  | 1
        4   | 98500 | 200  | 492

    }

//    @IgnoreRest
    //    @Ignore
    @Unroll("Going to Test #sno for Principle: #principles, Rate: #rates, Time: #times and Result: #result")
    void "test math Interest operation with Service"() {
        when:
        Long principle = principles as Long
        Long rate = rates as Long
        Long time = times as Long
        params.principle = principle
        params.rate = rate
        params.time = time

//        def mathService1 = new MathService()
//
//        def otherService = mockFor(OtherService)
//        otherService.demandExplicit.multiplyTwoNumber(principle, rate, time) { Long num1, Long num2, Long num3 ->
//            return num1 * num2 * num3
//        }
//
//        otherService.demandExplicit.divideTwoNumber(1,1) { Long num1, Long num2->
//            return (principle * rate * time) / 100
//        }
//
//        mathService1.otherService = otherService.createMock()

        def mathService = mockFor(MathService)

        mathService.demandExplicit.interest(principle, rate,time) { Long num1, Long num2, Long num3->
            return (num1 * num2 * num3)/100
        }

        controller.mathService = mathService.createMock()
        controller.interestWithService()

        then:

        response.text == "" + result

        where:
        sno | principles | rates | times | result
        1   | 1500       | 10    | 1     | 150
        2   | 10800      | 67    | 5     | 36180
        3   | 30000      | 105   | 3     | 94500
        4   | 98500      | 20    | 4     | 78800

    }
}
