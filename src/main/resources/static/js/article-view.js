function rowWrapper(content) {
  return '<div class="row media">' + content + '</div>';
}

function video(src) {
  return '<video class="col-sm-11" controls="controls">' + '<source src="' + src
      + '" type="video/ogg"/>' + '</video> '
}

function picture(src) {
  return '<img class="col-sm-11" src="' + src + '"></img>';
}

function appendText(body, value) {
  $.ajax({
    url: recordUrl(value),
    type: "GET",
    data: null,
    processData: false,
    contentType: false,
    success: function (response) {
      body.append(rowWrapper(text(value.description, response)));
    }
  });
}

function text(title, content) {
  return '<h2>' + title + '</h2>' + '<p class="lead">' + content + '</p>';
}

function constructBody(result) {
  var body = $('.article-body');
  result.forEach(function (value) {
    if (category(value.contentType) === 'video') {
      body.append(rowWrapper(video(recordUrl(value))));
    } else if (category(value.contentType) === 'image') {
      body.append(rowWrapper(picture(recordUrl(value))));
    } else if (category(value.contentType) === 'text') {
      appendText(body, value);
    }
  });
}

function recordUrl(value) {
  return '/record/' + value.createdTime + '/' + value.rand + '/'
      + value.sequence
      + '?contentType=' + value.contentType;
}

function category(contentType) {
  if (contentType.indexOf("application") === 0) {
    return 'video';
  } else if (contentType.indexOf("image") === 0) {
    return "image";
  } else if (contentType.indexOf("text") === 0) {
    return "text";
  } else {
    return "unknown";
  }
}