angular.module('sampleApp').config(config).directive('ngActiveTab', function($location) {
    return {
		link: function postLink(scope, element, attrs) {
		    scope.$on("$routeChangeSuccess", function(event, current, previous) {
				var pathLevel = attrs.activeTab || 1,
					pathToCheck = $location.path().split('/')[pathLevel],
					tabLink = attrs.href.split('/')[pathLevel];
				if (pathToCheck === tabLink) {
				    element.parent().addClass("active");
				} else {
				    element.parent().removeClass("active");
				}
		    });
		}
    };
});

function config($routeProvider, $locationProvider) {
	$locationProvider.html5Mode(true);
	
	$routeProvider.when('/home', {
		templateUrl : 'app/home/home.html',
		controller : 'homeController'
	})
	.when('/about', {
		templateUrl : 'app/about/about.html',
		controller : 'aboutController'
	})
	.otherwise({
		redirectTo: '/home'
    });
};