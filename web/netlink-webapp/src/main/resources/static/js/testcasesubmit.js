app.controller('myCtrl', function($scope, $filter, $http,shareDataService) {
	$scope.groupName="";
	$scope.welcome = {};
	$scope.resdata = {};
	$scope.testForm = {};
	$scope.testForm.testCaseFormInputData = [];
	$scope.inputName = "inputnama";
	$scope.inputdata = "inputdata";
	$scope.thinkworks = msg;
$scope.executedaytime="";
	// $scope.thinkworks= shareDataService.getList();
	 
	console.log(JSON.stringify($scope.thinkworks));
	 $scope.reqdatasend=[];
	
	$scope.onSubmit = function() {

		 console.log("srihari   onSubmit " + welcome);

		$http.get("testForm").success(
				function(response) {
					 console.log(response);
					$scope.resdata = response;
				}).error(function(response) {
			 console.log(response);
		}

		)
	}

	/* *************start method  *****************  */
	 $scope.submit = function(groupname,executedaytime){
		
		// console.log(formvalues);
		 console.log(" reqdatasend :: "+ JSON.stringify($scope.reqdatasend));
		 console.log("$scope.reqdata  :: " + JSON.stringify( $scope.reqdata));
		 $scope.reqdatasend=$scope.reqdata;
	
	/*for (var i=0; i<2; i++) {
     $scope.reqdatasend[i].groupName=formvalues;
    } */
		console.log(JSON.stringify($scope.reqdatasend));
		 var reqsend= JSON.stringify($scope.reqdatasend);
		$scope.reqsend12={"testcasesbindings" : JSON.parse(reqsend),"groupName":groupname,"executedaytime":$scope.executedaytime};

		var mystst=JSON.stringify($scope.reqsend12);
		 var reqsendinitial= JSON.parse(mystst);
	       
	    console.log(" mystst :: "+mystst);
		 
	
		 $http.post("testcasesubmitrequest",
					mystst).success(function(response) {
				 console.log(response);
				$scope.resdata = response;
			}).error(function(response) {
				 console.log(response);
			})
	 }
	/********************post end****************************************/
	 
	 
	$scope.myVar = "";
	$scope.names=msg;

	
	$scope.reqdata=[];
	
	$scope.addID = function (pagename,myVar){
		 console.log(pagename +  "    "+myVar);
		for(var i=0;i<=2;i++){
		
		 if( myVar==true && $scope.names[i].pageName==pagename ){
		 
		 console.log("GHSP  "+JSON.stringify($scope.names[i]));
		$scope.reqdata.push($scope.names[i]);
		console.log(JSON.stringify($scope.reqdata))
			}  
			
		
		
	}}
	$scope.onblur_check_groupname = function() {
		
$http.get('validation/{'+$scope.groupName+'}/').success(function(data) {
   if(data)
    document.getElementById("gname").innerHTML =" group name already  exist :"+ data;
   else
	    document.getElementById("gname").innerHTML ="";
   return false;
});
		//var gname=$scope.groupName;
		
	}
	
	  /* ************ SAVE METHOD **************   */
	
	$scope.onsave = function() {

		 console.log("srihari  onsave");
		$scope.testForm.testCaseFormInputData.push({
			"inputName" : $scope.inputName,
			"inputdata" : $scope.inputdata
		});

		$http.post("saveAndRunTestcases/saveTestCases",
				JSON.stringify($scope.testForm)).success(function(response) {
			 console.log(response);
			$scope.resdata = response;
		}).error(function(response) {
			 console.log(response);
		}

		)
	}
	  /* ************ END SAVE METHOD **************   */
	
	
	/*  *********start MEthod  **************  */
	$scope.onblurchangevalue = function (key,value,$index,objectvalues){
		
		
		 console.log("SRI  "+ document.getElementById(value).value);
		
		var element = document.getElementById(value).value;
		loop1: for(var i=0; i<=10;i++){
		
		loop2: for(k in $scope.reqdata[i].pageInputs){
			console.log(k);
            $scope.reqdata[i].pageInputs[k];
		if(k==key){
			console.log( "its equal");
			$scope.reqdata[i].pageInputs[k]=element;
			console.log($scope.reqdata[i].pageInputs[k]);
			break loop1;
		}
		
	}}
			console.log(  " key:   "+key);
			console.log(  " value:   "+value);
			console.log(  " $index:   "+$index);
			console.log(  " element:  "+element );
		
		console.log(  "  objectvalues  "+JSON.stringify(objectvalues));
		 
	}
	
	
	 /*   ****** END THIS METHOD ********** */
	
});
