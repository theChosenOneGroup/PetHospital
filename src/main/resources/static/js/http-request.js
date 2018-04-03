var JSONType = "application/json";

function requestAndDo(method, url, paras, dataType, doFunc, async) {
  var httpClient = getHttpClient();
  httpClient.onreadystatechange = function () {
    if (httpClient.readyState == 4 && httpClient.status == 200) {
      doFunc(JSON.parse(httpClient.responseText));
    }
  };
  httpClient.open(method, url, async);
  if (method.toUpperCase() == 'POST' || method.toUpperCase() == 'PUT') {
    if (dataType != null) {
      httpClient.setRequestHeader('Content-Type', dataType);
    }
    httpClient.send(paras);
  } else {
    httpClient.send();
  }
}

function get(url, paras, doFunc) {
  if (paras != null) {
    url = url + "?" + paras;
  }
  requestAndDo("GET", url, null, null, doFunc,true);
}

function synchGet(url, paras, doFunc) {
  if (paras != null) {
    url = url + "?" + paras;
  }
  requestAndDo("GET", url, null, null, doFunc, false);
}

function post(url, paras, dataType, doFunc) {
  requestAndDo("POST", url, paras, dataType, doFunc,true);
}

function postJson(url, paras, doFunc) {
  requestAndDo("POST", url, paras, JSONType, doFunc,true);
}

function httpDelete(url, paras, doFunc) {
  if (paras != null) {
    url = url + "?" + paras;
  }
  requestAndDo("DELETE", url, null, null, doFunc,true);
}

function put(url, paras, dataType, doFunc) {
  requestAndDo("PUT", url, paras, dataType, doFunc,true);
}

function getHttpClient() {
  if (window.XMLHttpRequest) {
    return new XMLHttpRequest();
  }
  else {
    return new ActiveXObject("Microsoft.XMLHTTP");
  }
}