var app = angular.module("adminApp", ["ngRoute","ng-fusioncharts"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "adminhello.html"
    })
    .when("/addnewproduct", {
        templateUrl : "addnewproduct.html"
    })
    .when("/addnewcategory", {
        templateUrl : "addnewcategory.html"
    })
    .when("/modifycategory", {
        templateUrl : "modifycategory.html"
    })
    .when("/modifyproduct", {
        templateUrl : "modifyproduct.html"
    })
    .when("/deletecategory", {
        templateUrl : "deletecategory.html"
    })
    .when("/deleteproduct", {
        templateUrl : "deleteproduct.html"
    })
    .when("/viewbilling", {
        templateUrl : "viewbilling.html",
        
    })
    .when("/viewcustomer", {
        templateUrl : "viewcustomer.html"
    })
    
});
app.controller('myCtrl', function($scope) {
    $scope.firstname = "John";
    $scope.lastname = "Doe";    
});
app.controller('dCtrl', function($scope) {
    $scope.firstname = "J";
    $scope.lastname = "Doe";    
});
app.controller('addnewcatCtrl', function($scope, $http) {
  
	$scope.addnewcat=function(newcategory){
  	$http.get('/addncategory?id='+newcategory.id+'&name='+newcategory.name).then(function(success) {
		
		if(success.data==1)
		{	$scope.newcategory.status='Successfully added new category';
			$scope.newcategory.name='';
			$scope.newcategory.id='';
		}
		else{
			$scope.newcategory.status='Duplicate category exists';
			$scope.newcategory.name='';
			$scope.newcategory.id='';
		}
	}, function(error) {
		console.log("fail");
	});
	}
});

app.controller('modifycategoryCtrl', function($scope, $http) {
		//$scope.modcategory.categorysearchresult=false;
	 
		$scope.categorysearch=function(modifycategory){
			$scope.modcategory.status='';
	  	$http.get('/modifycategorysearch?id='+modifycategory.id).then(function(success) {
	  		
			console.log(success.data.productCategoryName);
			
			if(success.data)
			{	$scope.modcategory.categorysearchresult=true;
			console.log($scope.modcategory.categorysearchresult);
				$scope.modcategory.name=success.data.productCategoryName;
				$scope.modcategory.findstatus='';
			}
			else{
				$scope.modcategory.categorysearchresult=false;
				$scope.modcategory.findstatus='Not Found';
			}
		}, function(error) {
			console.log("fail");
		});
		}
		
		$scope.reset=function(modcategory){
			$scope.modcategory.categorysearchresult=false;
			$scope.modcategory.id='';
		}
		
		$scope.modifycategory=function(modifycategory){
			console.log('Clicked');
		  	$http.get('/updatecategory?id='+modifycategory.id+'&name='+modifycategory.name).then(function(success) {
				console.log(success.data);
				console.log(success);
				if(success.data)
				{	$scope.modcategory.status='Category Name Changed, all related products category changed also';
				}
				else{
					$scope.modcategory.status='Duplicate Category Exists';
				}
			}, function(error) {
				console.log("fail");
			});
			}
		
	});

app.controller('deletecategoryCtrl', function($scope, $http) {
	//$scope.modcategory.categorysearchresult=false;
 
	 
	$scope.categorysearch=function(modifycategory){
		$scope.modcategory.status='';
  	$http.get('/modifycategorysearch?id='+modifycategory.id).then(function(success) {
  		
		console.log(success.data.productCategoryName);
		
		if(success.data)
		{	$scope.modcategory.categorysearchresult=true;
		console.log($scope.modcategory.categorysearchresult);
			$scope.modcategory.name=success.data.productCategoryName;
			$scope.modcategory.findstatus='';
		}
		else{
			$scope.modcategory.categorysearchresult=false;
			$scope.modcategory.findstatus='Not Found';
		}
	}, function(error) {
		console.log("fail");
	});
  	
  		
	}
	
	$scope.reset=function(modcategory){
		$scope.modcategory.categorysearchresult=false;
		$scope.modcategory.id='';
	}
	
	$scope.modifycategory=function(modifycategory){
		console.log('Clicked');
	  	$http.get('/deletecategoryadmin?id='+modifycategory.id).then(function(success) {
			console.log(success.data);
			console.log(success);
			if(success.data)
			{	$scope.modcategory.status='Category and respective products removed';
			}
			else{
				$scope.modcategory.status='Some error occured, contact your administrator';
			}
		}, function(error) {
			console.log("fail");
		});
		$http.get('/deletecategoryadminprod?id='+modifycategory.id).then(function(success) {
			console.log(success.data);
			console.log(success);
			
		}, function(error) {
			console.log("fail");
		});
		}
	
});

app.controller('addproductCtrl', function($scope, $http){
	$scope.categories=[];
  	$http.get('/searchcategory').then(function(success) {
  		var i=0;
  		while(i<success.data.length){
  			$scope.categories.push(success.data[i].productCategoryName);
  			++i;
  		}	
	}, function(error) {
		console.log("fail");
	});
	
  	$scope.addproduct=function(addprod){
  		console.log(addprod.id);
  		console.log(addprod.pname);
  		console.log(addprod.category);
  		console.log(addprod.price);
  		
  	  	$http.get('/addnproduct?id='+addprod.id+'&name='+addprod.pname+'&category='+addprod.category+'&price='+addprod.price).then(function(success) {
  			
  			if(success.data==1)
  			{	$scope.addprod.status='Successfully added new Product';
  				$scope.addprod.id='';
  				$scope.addprod.pname='';
  				$scope.addprod.category='';
  				$scope.addprod.price='';
  			}
  			else{
  				$scope.addprod.status='Duplicate Product exists';
  				$scope.addprod.id='';
  				$scope.addprod.pname='';
  				$scope.addprod.category='';
  				$scope.addprod.price='';
  			}
  		}, function(error) {
  			console.log("fail");
  		});
  	}
  	$scope.reset=function(addprod){
  		$scope.addprod.id='';
		$scope.addprod.pname='';
		$scope.addprod.category='';
		$scope.addprod.price='';
  	}
});


app.controller('modifyprodCtrl',function($scope, $http){
		$scope.productsearch=function(modprod){
			$http.get('/findproductadmin?id='+modprod.id).then(function(success) {
	  			//console.log(success.data);
	  			if(success.data)
	  			{	//console.log('found');
	  				$scope.modprod.categorysearchresult=true;
	  				$scope.modprod.name=success.data.productName;
	  				$scope.modprod.category=success.data.productCategory;
	  				$scope.modprod.price=success.data.productPrice;
	  				$scope.modprod.findstatus='';
	  				
	  			}
	  			else{
	  				//console.log('notfound');
	  				$scope.modprod.categorysearchresult=false;
					$scope.modprod.findstatus='Not Found';
	  			}
	  		}, function(error) {
	  			console.log("fail");
	  		});
	  	}
		
		$scope.reset=function(modprod){
			$scope.modprod.categorysearchresult=false;
			$scope.modprod.id='';
		}
		$scope.categories=[];
	  	$http.get('/searchcategory').then(function(success) {
	  		var i=0;
	  		while(i<success.data.length){
	  			$scope.categories.push(success.data[i].productCategoryName);
	  			++i;
	  		}	
		}, function(error) {
			console.log("fail");
		});
	  	
	  	$scope.modifyproduct= function(modprod){
	  	  	$http.get('/updateproductadmin?id='+modprod.id+'&name='+modprod.name+'&category='+modprod.category+'&price='+modprod.price).then(function(success) {
	  			
	  			if(success.data==1)
	  			{	$scope.modprod.status='Successfully updated Product Details';
	  				$scope.modprod.id='';
	  				$scope.modprod.name='';
	  				$scope.modprod.category='';
	  				$scope.modprod.price='';
	  			}
	  			else{
	  				$scope.modprod.status='Some error occured,Contact Administrator';
	  				$scope.modprod.id='';
	  				$scope.modprod.name='';
	  				$scope.modprod.category='';
	  				$scope.modprod.price='';
	  			}
	  		}, function(error) {
	  			console.log("fail");
	  		});
	  	}
	  	
	  	$scope.deleteproduct= function(modprod){
	  		$http.get('/deleteproductadmin?id='+modprod.id).then(function(success) {
	  			if(success.data==1)
	  			{	$scope.modprod.status='Successfully deleted Product';
	  				$scope.modprod.id='';
	  				$scope.modprod.categorysearchresult=false;
	  			}
	  			else{$scope.modprod.id='';
	  				$scope.modprod.status='Some error occured,Contact Administrator';
	  				$scope.modprod.categorysearchresult=false;
	  			}
	  		}, function(error) {
	  			console.log("fail");
	  		});
	  	}
	
});


app.controller('viewcustomer', function($scope, $http){
	$http.get('/fetchcustomerdata').then(function(success) {
			//console.log(success.data);
			$scope.orderproducts=success.data;
		}, function(error) {
			console.log("fail");
		});
	
	$http.get('/fetchbillingdata').then(function(success) {
		//console.log(success.data);
		
		$scope.sales=success.data;
	}, function(error) {
		console.log("fail");
	});
	
	$http.get('/fetchchartdata').then(function(success) {
		console.log(success.data);
		$scope.ChData=success.data; 
			FusionCharts.ready(function () {
			    var revenueChart = new FusionCharts({
			        type: 'doughnut3d',
			        renderAt: 'chart-container',
			        width: '500',
			        height: '300',
			        dataFormat: 'json',
			        dataSource: {
			        	
			            "chart": {
			                "caption": "Sales Report",
			                "subCaption": "Day Wise",
			                "numberPrefix": "$",
			                "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
			                "bgColor": "#ffffff",
			                "showBorder": "0",
			                "use3DLighting": "0",
			                "showShadow": "0",
			                "enableSmartLabels": "0",
			                "startingAngle": "310",
			                "showLabels": "0",
			                "showPercentValues": "1",
			                "showLegend": "1",
			                "legendShadow": "0",
			                "legendBorderAlpha": "0",                                
			                "decimals": "0",
			                "captionFontSize": "14",
			                "subcaptionFontSize": "14",
			                "subcaptionFontBold": "0",
			                "toolTipColor": "#ffffff",
			                "toolTipBorderThickness": "0",
			                "toolTipBgColor": "#000000",
			                "toolTipBgAlpha": "80",
			                "toolTipBorderRadius": "2",
			                "toolTipPadding": "5",
			            },
			            
			            data: $scope.ChData
			        }
			    });
			    revenueChart.render();
			});
	}, function(error) {
		console.log("fail");
	});
	

	
});


