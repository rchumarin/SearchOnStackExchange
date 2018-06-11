<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
  <c:when test="${not empty resp.items}">
    <table class="simple-little-table" cellspacing='0'>
      <tr>
        <th>Date</th>
        <th>Author</th>
        <th>Title</th>
        <th>Link</th>
      </tr>
      <c:forEach items="${resp.items}" var="item">
        <c:choose>
          <c:when test="${item.getAnswer_count() > 0}">
            <tr id="font-text">
              <td>${item.getCreation_date()}</td>
              <td>${item.getOwner().getDisplay_name()}</td>
              <td>${item.getTitle()}</td>
              <td><a href="${item.getLink()}" target="_blank">view</a></td>
            </tr>
          </c:when>
          <c:otherwise>
            <tr>
              <td>${item.getCreation_date()}</td>
              <td>${item.getOwner().getDisplay_name()}</td>
              <td>${item.getTitle()}</td>
              <td><a href="${item.getLink()}" target="_blank">view</a></td>
            </tr>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h3>Not found</h3>
  </c:otherwise>
</c:choose>