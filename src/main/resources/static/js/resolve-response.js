var code = {success: 100001, error: 100002};

function resolveResponse(response) {
  if (response.code == code.success) {
    return response.result;
  } else if (response.code == code.error) {
    alert('Some error occurred');
  } else {
    alert('Unexpected error');
  }
}