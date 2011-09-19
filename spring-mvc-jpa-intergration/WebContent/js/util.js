function ObjectView() {
	
	this.addError = function(id) {
		if ($('#'+id) != null) {
			$('#'+id).addClass('error');
		} else {
			alert('null '+id);
		}
	};
	this.removeError = function(id) {
		if ($('#'+id).hasClass('error')) {
			$('#'+id).removeClass('error');
		}
	};
}

View = new ObjectView();