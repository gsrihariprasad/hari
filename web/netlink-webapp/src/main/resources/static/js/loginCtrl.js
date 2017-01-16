
app.controller('loginCtrl', function($scope,$filter, $http) {
	
	 $scope.submit = function() {
   $http.get("login").then(function (response) {
        $scope.results = response.data;
    });
	 };
	
});
