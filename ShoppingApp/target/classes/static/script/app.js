var app = angular.module("myApp", ['ngCookies']);


app.controller('CookiesController', function ($scope, $window, $cookies) {
   
});

app.controller('myCtrl', function($scope, $http,$window,$location, $cookies) {
		//console.log(localStorageService.get('uname'));
	 $scope.SetCookies = function () {
	        $cookies.put("username", $scope.username);
	    };
	    $scope.GetCookies = function () {
	        $window.alert($cookies.get('username'));
	    };
	    $scope.ClearCookies = function () {
	        $cookies.remove('username');
	    };
	$scope.uname=$cookies.get('username');
//	$scope.checkoutproducts=JSON.parse($cookies.get('coutproducts'));
	console.log($scope.uname+' a');
		$scope.totalCategory = [];
		$scope.records=[];
	  	$http.get('/fetchproducts').then(function(success) {
	  		$scope.records =success.data;
	  		var i=0;
	  		while(i<success.data.length){
	  			$scope.totalCategory.push(success.data[i].productCategory);
	  			++i;
	  		}	
	  		
		}, function(error) {
			console.log("fail");
		});
		var count=0;	
			
		//$scope.selectedCategory = ['Mobile','Refrigerator','Camera','Laptop','Headphones'];
		console.log($scope.selectedCategory);
		$scope.selectedCategory=$scope.totalCategory;
		console.log($scope.selectedCategory);
		$scope.myfClick = function(a,b){
			console.log(b);
			if(count==0)
			{
				$scope.selectedCategory = [];
				count=1;
			}
			if(!b){
					
					var index = $scope.selectedCategory.indexOf(a);
					$scope.selectedCategory.splice(index, 1);
					
			}
			else{
				
			$scope.selectedCategory.push(a);
			
			}
			
			
			if($scope.selectedCategory.length==0)
			{	
				$scope.selectedCategory = $scope.totalCategory;
				count=0;
			}
		}
		
		$scope.containsComparator = function(expected, actual){  
			return actual.indexOf(expected) > -1;
		};
		$scope.filterreset = function(){
			//$window.location.reload();
			$scope.selectedCategory = $scope.totalCategory;
			count=0;
			}
		$scope.cartproducts=[];
		$scope.cartproductcount='';	
		
		$scope.addtocart=function(x){
			x.isDisabled = true;
			x.quantity=1;
			
			if($scope.cartproductcount=='')
			{
				$scope.cartproductcount=1;
				$scope.cartproducts.push(x);
			}
			else{
				$scope.cartproductcount+=1;
				$scope.cartproducts.push(x);
			}
			
		}	
		
		$scope.removefromcart=function(x){
				var searchTerm = x.Name,
				myindex = -1;
				for(var i = 0, len = $scope.cartproducts.length; i < len; i++) {
					if ($scope.cartproducts[i].Name === searchTerm) {
						myindex = i;
					break;
				}
				}			
					x.isDisabled=false;
					x.status = !x.status;
					$scope.cartproducts.splice(myindex, 1);
					$scope.cartproductcount-=1;
					if($scope.cartproductcount==0)
						{
						$scope.cartproductcount='';
						}
							
		}
		//$scope.uname='abc';
		$scope.login=function(u){
			console.log('clicked');
		
			
		  	$http.get('/checkcredentials?id='+u.username+'&pwd='+u.userpwd).then(function(success) {
		  		console.log(success.data);
		  		if(success.data==2)
		  			{
		  			$scope.loginstatus='Invalid credentials';
		  			}
		  		else if(success.data==0){
		  			$scope.uname='def';
		  			$window.location.href = "shoppingpage.html";
		  			$cookies.put("username", $scope.u.username);
		  			//$location.url="shoppingpage.html";
		  			
		  		}
		  		else if(success.data==1){
		  			$cookies.put("username", 'admin');
		  			$window.location.href = "adminhome.html";
		  			
		  		}
		  			
			}, function(error) {
				console.log("fail");
			});
		  		
		}
		
		$scope.checkout=function(){
			console.log('checkout clicked');
			$cookies.put("coutproducts", JSON.stringify($scope.cartproducts));	
			
			console.log($scope.cartproducts);
			console.log($cookies.get('coutproducts'));
			$window.location.href = "checkout.html";
		}
		$scope.totalprice=0;
		
		//$scope.checkoutproducts=JSON.parse($cookies.get('coutproducts'));
		$scope.checkoutproducts=[];
		console.log(!$cookies.get('coutproducts'));
		if(!$cookies.get('coutproducts')){
			
		}
		else{
			$scope.checkoutproducts=JSON.parse($cookies.get('coutproducts'));
		}
		
			for(var i=0;i<$scope.checkoutproducts.length;i++)
				{$scope.totalprice=$scope.totalprice+$scope.checkoutproducts[i].productPrice*$scope.checkoutproducts[i].quantity;
					}
		$scope.Buy=function(){
			
			
			console.log($cookies.get('coutproducts'));
		  	$http.get('/buyproducts?id='+$scope.uname+'&Products='+$cookies.get('coutproducts')+'&total='+$scope.totalprice).then(function(success) {
		  		console.log(success.data);
		  		if(success.data==1){
		  			$scope.orderstatus='Order has been placed successfully';
		  		}
			}, function(error) {
				console.log("fail");
			});
		}	
				
		
});



