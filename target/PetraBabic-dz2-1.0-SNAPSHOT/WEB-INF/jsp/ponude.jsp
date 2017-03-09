<%-- 
    Document   : ponude
    Created on : Dec 21, 2016, 6:36:03 PM
    Author     : ko
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<h2>Ponude:  </h2>
<c:if test="${!empty ponude}">
    <table>
        <tr>
            <th width="350"> Naslov</th>
            <th width="200"> Kolicina</th>
        </tr>
        <c:forEach items="${ponude}" var="ponuda">
            <tr>
                <td>${ponuda.naslov}</td>
                <td>${ponuda.kolicina}</td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
