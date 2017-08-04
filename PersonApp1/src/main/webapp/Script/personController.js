app.controller('demoCtrl', [
		'$scope',
		'personService',
		'$location',
		function($scope, personService, $location) {

			$scope.psn = {
				psnId : '',
				psnName : '',
				psnAge : '',
				psnMail : ''
			};

			$scope.persons;

			function fetchAllPersons() {
				console.log('entering fetchAll Persons in controller')
				personService.fetchAllPersons().then(function(data) {
					console.log('before ' + data);
					$scope.persons = data;
					console.log('After' + $scope.persons);
				}, function(error) {
					console.log('Error : ' + error)
				});
			}
			;

			fetchAllPersons();

			$scope.addPerson = function() {
				console.log("adding person..")
				personService.addPerson($scope.psn).then(function(data) {
					fetchAllPersons();
					$location.path('#/')
				}, function(error) {
					console.error('cant add')
				});
			};

			$scope.enabledEdit = [];

			$scope.editPerson = function(data) {
				console.log("editing person.." + data)
				$scope.enabledEdit[data] = true;
			};

			$scope.edittedPerson = function(person) {
				console.log(person.psnId + person)
				personService.editPerson(person.psnId, person).then(
						function(data) {
							console.log(data);
							fetchAllPersons();
						}, function(error) {
							console.log('Error while updating' + error);
						})
			}

			$scope.deletePerson = function(id) {
				console.log("deleting person.." + id);
				personService.deletePerson(id).then(function(data) {
					fetchAllPersons();
				}, function(error) {
					console.log('Error while deleting ' + error);
				})
			};

			$scope.submitPerson = function() {
				console.log("submit button")
				$location.path('#/')
			};

		} ]);
