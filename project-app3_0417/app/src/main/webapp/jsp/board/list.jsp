<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>MyList!</title>
  <link href="/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">

<div id="header">
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div id="sidebar">
<jsp:include page="/jsp/sidebar.jsp"></jsp:include>
</div>

<div id="content">
<h1>게시글</h1>
<a href="form.jsp">새 게시글</a>
<table id="x-board-table" border="1">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<%
BoardService boardService = (BoardService) application.getAttribute("boardService");

int pageNo = 1;
int pageSize = 5; //페이지 게시글 수 // 파라미터값이 안들어온다면 디폴트값 
int totalPageSize = 0;// 총 게시글 수 

try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
  pageSize = Integer.parseInt(request.getParameter("pageSize"));
  if (pageSize < 5 || pageSize > 100) {  //5개이상 100개미만 페이지에 대해서는 유효 //디도스공격 - 서버에 많은 일을 시켜서 제기능을 하지못하게 하여 이용자의 이용을 막음
    pageSize = 5;
  }
} catch (Exception e) {}

//게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
int boardSize = boardService.size(); 
totalPageSize = boardSize / pageSize; // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
if ((boardSize % pageSize) > 0) {
  totalPageSize++;
}

try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
  pageNo = Integer.parseInt(request.getParameter("pageNo"));
  if (pageNo < 1 || pageNo > totalPageSize) {// pageNo 유효성 검증
    pageNo = 1;
  }
} catch (Exception e) {
}

List<Board> boards = boardService.list(pageSize, pageNo);
for (Board board : boards) {
%>
  <tr>
    <td><%=board.getNo()%></td>
    <td><a href='view.jsp?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getWriter().getName()%></td>
    <td><%=board.getViewCount()%></td>
    <td><%=board.getCreatedDate()%></td>
  </tr>
<%
}
%>
</tbody>
</table>
<div>
<%if (pageNo > 1){%>
<a href="list.jsp?pageNo=<%=pageNo - 1%>&pageSize=<%=pageSize%>">[이전]</a>
<%} else {%>
[이전]
<%} %>
<%=pageNo%>
<%if (pageNo < totalPageSize) { %>

<a href="list.jsp?pageNo=<%=pageNo + 1 %>&pageSize=<%=pageSize%>">[다음]</a>
<%} else { %>
[다음]
<%} %>
<div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
