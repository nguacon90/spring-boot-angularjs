angular.module('sampleApp', [ 'ngRoute', 'ui.bootstrap']);

angular.module('sampleApp').run(['$location', '$rootScope', function($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
        $rootScope.title = current.$$route.title;
    });
}]);