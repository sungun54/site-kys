<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name} 게시물 리스트" />
<%@ include file="../part/head.jspf"%>
	<script>
		var ArticleWriterForm__submitDone = false;

		function ArticleWriteForm__submit(form) {
			if (ArticleWriterForm__submitDone) {
				alert('처리중입니다.');
				return;
			}

			form.title.value = form.title.value.trim();
			if (form.title.value.length == 0) {
				form.title.focus();
				alert('제목을 입력해주세요.');
				return;
			}

			if (body.length == 0) {
				bodyEditor.focus();
				alert('특이사항을 입력해주세요.');
				return;
			}
			form.body.value = body;
			form.submit();
		}
	</script>
	<form method="POST" action="${board.code}-doWrite"
		onsubmit="ArticleWriteForm__submit(this); return false;">
		<div>
			<span>제목</span> <input type="text" name="title" />
		</div>
		<div>
			<span>내용</span>
			<textarea name="body"></textarea>
		</div>

		<div>
			<button type="submit">작성</button>
		</div>
	</form>
<%@ include file="../part/foot.jspf"%>