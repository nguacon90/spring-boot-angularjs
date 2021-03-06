angular.module('sampleApp', ['ngRoute', 'pascalprecht.translate'])
	   .config(config)
	   .config(configI18n)
	   .directive('ngActiveTab', function($location) {
			return {
				link : function postLink(scope, element, attrs) {
					scope.$on("$routeChangeSuccess", function(event, current, previous) {
						var pathLevel = attrs.activeTab || 1, pathToCheck = $location
								.path().split('/')[pathLevel], tabLink = attrs.href
								.split('/')[pathLevel];
						if (pathToCheck === tabLink) {
							element.parent().addClass(
									"active");
						} else {
							element.parent()
									.removeClass(
											"active");
						}
					});
				}
			};
		});

function config($routeProvider, $locationProvider) {
	$locationProvider.html5Mode(true);

	$routeProvider.when('/home', {
		title : 'Home',
		templateUrl : 'app/home/home.html',
		controller : 'homeController'
	}).when('/about', {
		title : 'About',
		templateUrl : 'app/about/about.html',
		controller : 'aboutController'
	}).otherwise({
		redirectTo : '/home'
	});

};

function configI18n($translateProvider) {
	$translateProvider.useStaticFilesLoader({
		prefix : '/app/i18n/',
		suffix : '.json'
	});
	
	$translateProvider.preferredLanguage('en');
	
};