<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${title}</title>
</head>

<body>
<g:form controller="math">
    Number1: <g:textField name="num1"/>
    Number2: <g:textField name="num2"/><br/><br/>
    <g:actionSubmit value="SumWithoutService" action="addWithoutService"/>
    <g:actionSubmit value="SumWithService" action="addWithService"/>
    <g:actionSubmit value="MultiplyWithoutService" action="multipleWithoutService"/>
    <g:actionSubmit value="MultiplyWithService" action="multipleWithService"/>
    <g:actionSubmit value="DivideWithoutService" action="divideWithoutService"/>
    <g:actionSubmit value="DivideWithService" action="divideWithService"/>

</g:form>
<g:form>
    Principle: <g:textField name="principle"/>
    Rate: <g:textField name="rate"/>
    Time: <g:textField name="time"/><br/><br/>
    <g:actionSubmit value="InterestWithoutService" action="interestWithoutService"/>
    <g:actionSubmit value="InterestWithService" action="interestWithService"/>
</g:form>
<a href="${createLink(controller: 'math', action: 'testingRedirect')}">Testing Redirect</a>
</body>
</html>