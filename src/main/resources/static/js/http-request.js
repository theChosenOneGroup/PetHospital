function requestAndDo(method, url, doFunc) {
  var httpClient = getHttpClient();
  httpClient.onreadystatechange = function () {
    if (httpClient.readyState == 4 && httpClient.status == 200) {
      doFunc(JSON.parse(httpClient.responseText));
    }
  }
  httpClient.open(method, url, true);
  httpClient.send();
}

function get(url, doFunc) {
  requestAndDo("GET", url, doFunc);
}

function post(url, doFunc) {
  requestAndDo("POST", url, doFunc);
}

function getHttpClient() {
  if (window.XMLHttpRequest) {
    return new XMLHttpRequest();
  }
  else {
    return new ActiveXObject("Microsoft.XMLHTTP");
  }
}