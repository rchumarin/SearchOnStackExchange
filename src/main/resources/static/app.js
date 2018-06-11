function log(message) {
	document.getElementById('log').innerHTML = message;
}

function getRest() {
	var xhr = new XMLHttpRequest();
	var body = document.getElementById("title").value;
	if (body == '') {
		alert('Please enter a valid title.');
		return false;
	} else {
		xhr.open("POST", '/getResult', true);
		xhr.setRequestHeader('Content-Type', 'text/plain');

		xhr.upload.onprogress = function(event) {
			log("Sending request. Please wait ...");
		}

		xhr.onreadystatechange = function () {
			if (xhr.status == 200) {
				if (document.getElementById('res')) {
					document.getElementById('res').remove();
				}
				var test = document.createElement("div");
				test.id = 'res';
				test.innerHTML = xhr.responseText;
				result.appendChild(test);
				log(null);
			} else {
				log("error " + this.status);
			}
		}
	}
	xhr.send(body);
}