angular.module('sampleApp').controller('homeController', ['$scope' , HomeController]);

function HomeController($scope){
	$scope.welcomeMessage = 'Hello angular web application!';
};