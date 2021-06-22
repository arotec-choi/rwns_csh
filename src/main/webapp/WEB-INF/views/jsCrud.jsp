<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>jsCrud</title>

<!-- Wijmo 레퍼런스 (필수) -->
<link
  href="https://cdn.grapecity.com/wijmo/5.latest/styles/wijmo.min.css"
  rel="stylesheet"
/>
<!-- 
    wijmo.min.css 대신에 아래와 같이 사용자 정의 테마 사용가능
    <link href="https://cdn.grapecity.com/wijmo/5.latest/styles/themes/wijmo.theme.modern.min.css" rel="stylesheet"/>
-->
<script src="https://cdn.grapecity.com/wijmo/5.latest/controls/wijmo.min.js"></script>

<!-- Wijmo 컨트롤 (옵션, 필요한 컨트롤 만 추가) -->
<script src="https://cdn.grapecity.com/wijmo/5.latest/controls/wijmo.grid.min.js"></script>
<script src="https://cdn.grapecity.com/wijmo/5.latest/controls/wijmo.input.min.js"></script>

<!-- Wijmo custom culture (옵션, 원하는 문화권을 추가) -->
<script src="https://cdn.grapecity.com/wijmo/5.latest/controls/cultures/wijmo.culture.ko.min.js"></script>

<!-- AngularJS and Wijmo directives (옵션, Angular/React/Vue/etc 어플리케이션에서 사용가능) 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/React.min.js"></script>
<script src="https://cdn.grapecity.com/wijmo/5.latest/interop/angular/wijmo.React.min.js"></script>
-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<link rel="stylesheet" type="text/css" href="/resources/css/jsCrud.css">
<!-- <script src="/resources/js/jsCrud.js"></script>  -->

</head>
<body>

<div class="container-fluid">
  <div class="row">
    <div class="col-xs-12">
    
    <p id="itemCount"></p>  
      <div id="theGrid"></div>
    </div>
    <div class="col-xs-12">
      <h4>편집된 항목:</h4> 
      <p id="edItemCount"></p>    
      <div id="edited" class="changed edited" ></div>
      <button type="button" id="btnSave" onclick="btnEdit();">수정</button>

      <h4>추가된 항목:</h4>
      <p id="addItemCount"></p>
      <div id="added" class="changed added"></div>
      <button type="button" id="btnAdd" onclick="btnAdd();">추가</button>

      <h4>제거된 항목:</h4>
      <p id="delItemCount"></p>
      <div id="removed" class="changed removed"></div>
       <button type="button" id="btnDel" onclick="btnDel();">추가</button>
    </div>
  </div>
</div>

 
</body>
 <script src="/resources/js/jsCrud.js"></script>
</html>