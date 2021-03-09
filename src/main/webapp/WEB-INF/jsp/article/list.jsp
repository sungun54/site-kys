<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name} 게시물 리스트" />
<%@ include file="../part/head.jspf"%>

<div class="table-box con list">
  <table>
    <colgroup>
      <col width="100" />
      <col width="200" />
      <col />
      <col width="100" />
      <col width="100" />
    </colgroup>
    <thead>
      <tr>
        <th>번호</th>
        <th>날짜</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${articles}" var="article">
        <c:if test="${article.boardId == board.id}">
          <tr>
            <td>
              <a href="#">${article.id}</a>
            </td>
            <td>${article.regDate}</td>
            <td class="td-title">
              <a href="#">${article.title}</a>
            </td>
            <td>${article.hit}</td>
          </tr>
        </c:if>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="../part/foot.jspf"%>