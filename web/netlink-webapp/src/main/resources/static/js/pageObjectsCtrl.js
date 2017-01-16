app.controller('pageObjectsCtrl', function($scope, $filter, $http) {

	$scope.pageXpaths = [];
	$scope.pagexpath = [];
	$scope.pagexpath_first ="enter xpath";
	$scope.pageActions = [];
	$scope.testformdata = [];
	$scope.pageaction_first = [];
	$scope.trequest = [];
	$scope.pageName = "";
	$scope.pageClass = "";
	var dst = [];
	$scope.tresp={};
	$scope.formsubmit = function() {

		console.log(" TestCaseCtrl came here ...........");

		console.log("pageActions   ::  " + JSON.stringify($scope.pageActions));
		console.log("pageXpaths    ::  " + JSON.stringify($scope.pageXpaths));

		$scope.trequest.push({
			pageActions : $scope.pageActions,
			pageXpaths : $scope.pageXpaths,
			pageName: $scope.pageName,
			pageClass: $scope.pageClass
		});
		
		console.log(JSON.stringify($scope.trequest));
		var xyy=JSON.stringify($scope.trequest);
		var reqpost=angular.toJson(xyy);
		var reqsendpost= JSON.parse(reqpost);
		 $http.post("savepageobjects",reqsendpost).success(function(response) {
				alert(xyy);
				$scope.tresp = response;
			}).error(function(response) {
				alert(response);
			});
		
		
	}

	 $scope.$watch('$scope.pagexpath_first', function() {
	        alert('hey, myVar has changed!' +$scope.pagexpath_first);
	    });

	$scope.addPageXpath = function() {

		$scope.pageXpaths.push({
			element1 : $scope.pagexpath_first.element1,
			xpath1 : $scope.pagexpath_first.xpath1,

		}); //Added the values to scopes which need to be added   
	};

	$scope.addPageActions = function() {

		$scope.pageActions.push({
			actionname1 : $scope.pageaction_first.actionname,
			xpath1 : $scope.pageaction_first.xpath1,
			pojoclassname : $scope.pageaction_first.pojoclassname,
			element1 : $scope.pageaction_first.element1,

		}); //Added the values to scopes which need to be added   
	};
});