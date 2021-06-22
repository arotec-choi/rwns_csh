<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>reactCrud</title>


<script src="https://unpkg.com/react@15/dist/wijmo.react.js"></script> <!--react -->
<script src="https://unpkg.com/react-dom@15/dist/react-dom.min.js"></script> <!-- react-dom -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.38/browser.min.js"></script> <!-- babel -->





</head>
<body>
 <div id="root"></div>
	<script type="text/babel">
		ReactDOM.render(getDOM(),document.getElementById('root'))
		function getDOM(){
      		// 각 변수에 css 설정을 담아둡니다.
			const css1={
				'color' : '#f00',
				'background-color' : '#f0f0ff',
				'font-size' : '2em'
			}
			const css2={
				'color' : '#00f',
				'background-color' : '#fff0ff',
				'font-size' : '2em'
			}
      			/*return 하는 html 구조에 style의 속성에 변수에 담긴 
      			css 속성을 적용하기 위해 {변수} 로 담아줍니다.*/
			return(
				<div>
					<p style={css1}>React의 구조와 작성법</p>
					<p style={css2}>React의 JSX 사용법(변수, 이벤트처리, 스타일 적용, 주석)</p>
				</div>
			)
		}
	</script>
 
</body>

</html>