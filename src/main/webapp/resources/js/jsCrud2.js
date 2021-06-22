
//테이블 만들기
var view = new wijmo.collections.CollectionView(url, {
	trackChanges: true,
			
});

var data=null;
// 그리드에 데이터 표시
var itemCountElement = $(this).attr('itemCount');

var theGrid = new wijmo.grid.FlexGrid('#theGrid', {
    itemsSource: view,
    isReadOnly: true,
    //selectionMode: 'None',
    //headersVisibility: 'Column',
/*   columns: [
      { binding: 'buttons', header: 'Edit', width: 160 }
    ],*/
    allowAddNew: true,
    allowDelete: true,
    //isReadOnly: true, //읽기만 가능, 수정, 삭제 안됨
    loadedRows: function () {        	 
        itemCountElement.innerHTML = theGrid.rows.length + '개';     
        theGrid.getColumn('NMB').allowDragging=false;
        theGrid.getColumn('NMB').isReadOnly=true;
        theGrid.getColumn('BOOLTWO').dataMap=getSelectBox();    
        theGrid.rows.defaultSize = 40;
    },    
});

/*--------------------------------------*/
// 편집 버튼 및 입력 컨트롤을 수용할 수 있도록 행 높이 설정

//
// 버튼 및 편집기 사용자 정의 형식 지정
theGrid.formatItem.addHandler(function (s, e) {
  if (e.panel == s.cells) {
    var col = s.columns[e.col], item = s.rows[e.row].dataItem;
    //
    if (item == currentEditItem) {
      //
      //편집 중인 항목에 대한 편집기 및 버튼 만들기
      switch (col.binding) {
        case 'buttons':
          e.cell.innerHTML = document.getElementById('tplBtnEditMode').innerHTML;
          e.cell['dataItem'] = item;
          break;
        case 'TEXTONE':
        case 'TEXTTWO':
        case 'NUMBERONE':
        case 'NUMBERTWO':
        case 'DATEONE':
        case 'DATETWO':
        case 'BOOLONE':
        case 'BOOLTWO':
          e.cell.innerHTML = '<input class="form-control" ' +
            'NMB="' + col.binding + '" ' +
            'value="' + s.getCellData(e.row, e.col, true) + '"/>';
          break;
      }
    }
    else {
      //
      // 편집되지 않은 항목에 대한 버튼 만들기
      switch (col.binding) {
        case 'buttons':
          e.cell.innerHTML = document.getElementById('tplBtnViewMode').innerHTML;
          e.cell['dataItem'] = item;
          break;
      }
    }
  }
});
//
// 버튼 클릭 핸들
theGrid.addEventListener(theGrid.hostElement, 'click', function (e) {
  let targetBtn;
  if (e.target instanceof HTMLButtonElement) {
    targetBtn = e.target;
  }
  else if (e.target instanceof HTMLSpanElement && e.target.classList.contains('glyphicon')) {
    targetBtn = e.target.parentElement;
  }
  if (targetBtn) {
    //
    //버튼의 데이터 항목을 가져오기
    var item = wijmo.closest(targetBtn, '.wj-cell')['dataItem'];
    //
    // 버튼 핸들
    switch (targetBtn.id) {
        //
        // 항목 편집을 시작
      case 'btnEdit':
        editItem(item);
        break;
        //
        // 컬렉션으로 부터 아이템 제거
      case 'btnDelete':
        theGrid.collectionView.remove(item);
        break;
        //
        // 편집
      case 'btnOK':
        commitEdit();
        break;
        //
        // 편집 취소
      case 'btnCancel':
        cancelEdit();
        break;
    }
  }
});
//
// 그리드를 스크롤하거나 포커스를 잃을 때 편집 모드를 종료
theGrid.scrollPositionChanged.addHandler(cancelEdit);
theGrid.lostFocus.addHandler(cancelEdit);
//
//편집 명령
var currentEditItem = null;
//
function editItem(item) {
  cancelEdit();
  currentEditItem = item;
  theGrid.invalidate();
}
//
function commitEdit() {
  if (currentEditItem) {
    theGrid.columns.forEach(function (col) {
      var input = theGrid.hostElement.querySelector('#' + col.binding);
      if (input) {
        var value = wijmo.changeType(input.value, col.dataType, col.format);
        if (wijmo.getType(value) == col.dataType) {
          currentEditItem[col.binding] = value;
        }
      }
    });
  }
  currentEditItem = null;
  theGrid.invalidate();
}
//
function cancelEdit() {
  if (currentEditItem) {
    currentEditItem = null;
    theGrid.invalidate();
  }
}





/*--------------------------------------*/
function getSelectBox() {
    return 'Y,N'.split(',');
  }

var url =  wijmo.httpRequest ('jsCrudViwe', { 
	 success : function (xhr) { 
		 view.sourceCollection  = JSON.parse (xhr.response, function (key, value) { 
				
			 return value;
			
		 });
		  		 			  
	 } 

 }); 

