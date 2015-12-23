package com

class MathController {

    def mathService

    def index() {
        render(view: 'index',model: [title:"Math Operation"])
    }

    def addWithoutService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = num1 + num2
        println("Sum is " +sum)
        render sum
    }

    def addWithService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = mathService.addTwoNumber(num1, num2)
        println("Sum is " +sum)
        render sum
    }

    def multipleWithoutService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = num1 * num2
        println("Multiply is " +sum)
        render sum
    }

    def multipleWithService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = mathService.multiplyTwoNumber(num1, num2)
        println("Multiply is " +sum)
        render sum
    }

    def divideWithoutService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = num1 / num2
        println("Divide is " +sum)
        render sum
    }

    def divideWithService(){
        Long num1 = params.num1 as Long
        Long num2 = params.num2 as Long
        Long sum = mathService.divideTwoNumber(num1, num2)
        println("Divide is " +sum)
        render sum
    }

    def interestWithoutService(){
        Long principle = params.principle as Long
        Long rate = params.rate as Long
        Long time = params.time as Long
        Long sum = (principle * rate * time)/100
        println("Interest is " +sum)
        render sum
    }

    def interestWithService(){
        Long principle = params.principle as Long
        Long rate = params.rate as Long
        Long time = params.time as Long
        Long sum =  mathService.interest(principle, rate, time)
        println("Interest is " +sum)
        render sum
    }

    def testingRedirect(){
        println("Going to redirect again Index")
        redirect(action: 'index')
    }
}
