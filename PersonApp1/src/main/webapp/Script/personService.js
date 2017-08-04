app.factory('personService', function($http) {
	var URL = "http://localhost:8080/PersonApp1/webApi";

	var personService = this;
	personService.fetchAllPersons = function() {
		console.log('entering getAllBlogs')
		return $http.get(URL + "/show").then(function(response) {
			console.log(response)
			return response.data
		}, function(response) {
			console.error('Error while getting all Blogs')
			return response.status;
		});
	};

	personService.addPerson = function(person) {
		console.log('personService ->' + person.psnName)
		return $http.post(URL + "/show/add", person).then(function(response) {
			return response.data;
		}, function(response) {
			console.error("error in add part->personService")
			return response;
		});
	};

	  personService.editPerson = function(psnId, person) { 
		  console.log("editPerson->personService")
		  return $http.put(URL + "/show/edit/" + psnId, person).then(function(response) {
			  console.log(response.status)
			  return response.data;
				  }, function(error) {
				console.error("error in add part->personService")
				return error;
			}); 
	  };
	  
	  personService.deletePerson = function(psnId) {
		  console.log("deletePerson->personService")
		  return $http['delete'](URL + "/show/delete/" + psnId).then( function(response) { 
			  return response.data;
		  }, function(response) {
				console.error("error in add part->personService")
				return response;
			}); 
	  };
	  
	return personService;
});
