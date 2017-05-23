	$scope.login = function(loginFrame, password) {

		var data = {
			login : loginFrame,
			password : password
		};

		$http.post("users/login", data).success(function(data, status, headers, config) {
			$scope.messageShow = false;
			$window.location.href = 'index.html';
		}).error(function(data, status, headers, config) {
			$scope.messageShow = true;
		});
	}
	
	$scope.goToHomePage = function(){
		$window.location.href = 'index.html';
	}

});