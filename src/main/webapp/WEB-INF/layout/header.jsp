<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<ul class="nav nav-tabs" role="tablist">
    <li><a href="/home-page"><spring:message code="home"/></a></li>
    <li><a href="/chins-page"><spring:message code="chinchillas"/></a></li>
    <li><a href="/families-page"><spring:message code="families"/></a></li>
    <li><a href="/financies-page"><spring:message code="finance"/></a></li>
    <li class="pull-right"><a href="/?language=en_US"><spring:message code="language.en"/></a></li>
    <li class="pull-right"><a href="/?language=fr"><spring:message code="language.ua"/></a></li>
</ul>