package com

import grails.transaction.Transactional

@Transactional
class OtherService {

    def multiplyTwoNumber(Long num1, Long num2, Long num3) {
        println("Inside the multiply Service Method of Other")
        return num1 * num2 * num3
    }

    def divideTwoNumber(Long num1, Long num2) {
        println("Inside the divide Service Method of Other")
        return num1 / num2
    }
}
