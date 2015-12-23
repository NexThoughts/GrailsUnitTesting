<%@ page import="com.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="30" pattern="${userInstance.constraints.name.matches}" required="" value="${userInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'webpage', 'error')} ">
	<label for="webpage">
		<g:message code="user.webpage.label" default="Webpage" />
		
	</label>
	<g:field type="url" name="webpage" value="${userInstance?.webpage}"/>
</div>

