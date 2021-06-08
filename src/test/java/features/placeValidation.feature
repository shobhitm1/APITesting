Feature: Validating Add API's'

Scenario: Verify if the Place is successfully added using AddAPIs
	Given Add Place Payload
	When user calls "Add Place API" Payload with Post Request
	Then API call is success with status code as 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
	