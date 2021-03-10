<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />
<%@ include file="../part/head.jspf"%>

<script>
	var MemberLoginForm__submitDone = false;

	function MemberLoginForm__submit(form) {
		if (MemberLoginForm__submitDone) {
			alert('처리중입니다.');
			return;
		}

		form.loginId.value = form.loginId.value.trim();
		form.loginId.value = form.loginId.value.replaceAll('-', '');
		form.loginId.value = form.loginId.value.replaceAll('_', '');
		form.loginId.value = form.loginId.value.replaceAll(' ', '');
		
		form.loginId.value = form.loginId.value.trim();
		if (form.loginId.value.length == 0) {
			form.loginId.focus();
			alert('아이디를 입력해주세요.');
			return;
		}

		form.loginPw.value = form.loginPw.value.trim();
		if (form.loginPw.value.length == 0) {
			form.loginPw.focus();
			alert('비밀번호를 입력해주세요.');
			return;
		}

		form.loginPwReal.value = sha256(form.loginPw.value);
		form.loginPw.value = '';
		
		form.submit();
	}
</script>
<form method="POST" action="doLogin"
	onsubmit="MemberLoginForm__submit(this); return false;">	
	<input type="hidden" name="loginPwReal">
	
	<div>
		<span>아이디</span> <input type="text" placeholder="로그인 아이디 입력해주세요." name="loginId" maxlength="30" />
	</div>
	<div>
		<span>비밀번호</span> <input type="password" placeholder="로그인 비밀번호를 입력해주세요." name="loginPw" maxlength="30"  />
	</div>

	<div>
		<button type="submit">로그인</button>
	</div>
</form>

<%@ include file="../part/foot.jspf"%>