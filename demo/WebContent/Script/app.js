var app = angular.module("appMain", [ "ngRoute" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "Pages/show.html",
		controller : "demoCtrl"
	}).when("/ad", {
		templateUrl : "Pages/addPerson.html",
		controller : "demoCtrl"
	}).when("/ed", {
		templateUrl : "Pages/editDelete.html",
		controller : "demoCtrl"
	}).otherwise({
		redirectTo : "/"
	});

});
