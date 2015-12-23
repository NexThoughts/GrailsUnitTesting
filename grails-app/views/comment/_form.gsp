<%@ page import="com.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'comment', 'error')} required">
	<label for="comment">
		<g:message code="comment.comment.label" default="Comment" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="comment" cols="40" rows="5" maxlength="500" required="" value="${commentInstance?.comment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'user', 'error')} ">
	<label for="user">
		<g:message code="comment.user.label" default="User" />
		
	</label>
	<g:select id="user" name="user.id" from="${com.User.list()}" optionKey="id" value="${commentInstance?.user?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'feedback', 'error')} required">
	<label for="feedback">
		<g:message code="comment.feedback.label" default="Feedback" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="feedback" name="feedback.id" from="${com.Feedback.list()}" optionKey="id" required="" value="${commentInstance?.feedback?.id}" class="many-to-one"/>
</div>

