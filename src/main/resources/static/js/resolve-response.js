function resolveResponse(response) {
  if (response.code == 10001) {
    return response.result;
  } else {
    alert(response.message);
    return null;
  }
}