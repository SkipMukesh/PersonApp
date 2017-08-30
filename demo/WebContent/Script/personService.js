app.factory('personService', function($http) {
	var URL = "http://localhost:8080/demo/api/v1";  // http://mcmuke01:8080/PersonApp1/webApi || mcmuke01 || localhost

	var personService = this;
	personService.fetchAllPersons = function() {
		console.log('entering getAllBlogs')
		return $http.get(URL + "/persons").then(function(response) {
			console.log(response)
			return response.data
		}, function(response) {
			console.error('Error while getting all details')
			return response.status;
		});
	};

	personService.addPerson = function(person) {
		console.log('personService ->' + person.psnName)
		return $http.post(URL + "/persons/", person).then(function(response) {
			return response.data;
		}, function(response) {
			console.error("error in add part->personService")
			return response;
		});
	};

	  personService.editPerson = function(psnId, person) { 
		  console.log("editPerson->personService")
		  return $http.put(URL + "/persons/" + psnId, person).then(function(response) {
			  console.log(response.status)
			  return response.data;
				  }, function(error) {
				console.error("error in add part->personService")
				return error;
			}); 
	  };
	  
	  personService.deletePerson = function(psnId) {
		  console.log("deletePerson->personService")
		  return $http['delete'](URL + "/persons/" + psnId).then( function(response) { 
			  return response.data;
		  }, function(response) {
				console.error("error in add part->personService")
				return response;
			}); 
	  };
	  
	return personService;
});
