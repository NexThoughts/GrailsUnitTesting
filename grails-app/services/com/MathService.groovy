package com

import grails.transaction.Transactional

@Transactional
class MathService {
    def otherService

    def addTwoNumber(Long num1, Long num2) {
        println("Inside the Add Service Method")
        return (num1 + num2)
    }

    def divideTwoNumber(Long num1, Long num2) {
        println("Inside the Divide Service Method")
        return num1 / num2
    }

    def multiplyTwoNumber(Long num1, Long num2) {
        println("Inside the Multiply Service Method")
        return num1 * num2
    }

    def interest(Long principle, Long rate, Long time) {
        println("Inside the Interest Service Method")
        Long first = otherService.multiplyTwoNumber(principle, rate, time)
        Long result = otherService.divideTwoNumber(first, 100)
        return result
    }
}
