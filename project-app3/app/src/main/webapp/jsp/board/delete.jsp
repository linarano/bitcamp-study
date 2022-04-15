<%@page import="com.eomcs.mylist.domain.Member"%>
<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Board board = new Board();
board.setNo(Integer.parseInt(request.getParameter("no")));

Member loginUser = (Member) session.getAttribute("loginUser"); //서블릿과 비교 
board.setWriter(loginUser);

BoardService boardService = (BoardService) application.getAttribute("boardService");
boardService.delete(board);

response.sendRedirect("list.jsp"); // 따로출력이 필요없다.현재uRL에서게시물 목록 페이지를 다시 요청하라고 클라이언트에게 명령한다.
%>

