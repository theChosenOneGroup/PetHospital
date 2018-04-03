function pagingTags(pagingData) {
  var head = '<li><a id="paging-previous">&laquo;</a></li>';
  var tail = '<li><a id="paging-next">&raquo;</a></li>';
  var count = 0;
  var elements = head;
  while (count < pagingData.windowSize && count < pagingData.pageNumber) {
    pagingData.elementId[count] = 'paging-tag-' + count;
    elements += '<li><a class="paging-index" id="' + pagingData.elementId[count]
        + '">' + count + '</a></li>';
    count++;
  }
  elements += tail;
  return elements;
}

function moveWindow(direction, pagingData) {
  if (direction == 'LEFT' && pagingData.head > 0) {
    pagingData.head = pagingData.step > pagingData.head ? 0 : pagingData.head
        - step;
  } else if (direction == 'RIGHT' && pagingData.head + pagingData.windowSize
      < pagingData.pageNumber) {
    var next = pagingData.head + pagingData.windowSize + pagingData.step;
    pagingData.head = next > pagingData.pageNumber ? pagingData.pageNumber
        - pagingData.windowSize
        : next - pagingData.windowSize;
  }
  var count = 0;
  var ids = pagingData.elementId;
  while (count < pagingData.windowSize && pagingData.head + count
  < pagingData.pageNumber) {
    document.getElementById(ids[count]).innerHTML = pagingData.head + count;
    count++;
  }
}