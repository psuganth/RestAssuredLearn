#Author: your.email@your.domain.com
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Incident Management
	Background:
		#Given Set the endpoint
    #And Set the authentication
  @tag1
  Scenario: Get all incidents
    When Get all the incidents
    Then Validate the response code 200
    
    @TestCase2
  Scenario: Create an incident
    When create the incident with body '{"description":"Some Issue 3 update","short_description":"Big issue 3 update"}'
    Then Validate the response code 201
    
  @TestCase3
  Scenario Outline: Create an incident with file body
  	When create incident with file '<fileName>'
  	Then Validate the response code 201
  	Examples:
  	|fileName|
  	|createIncident.json|
  	|createIncident2.json|
  	
  	
  Scenario Outline: Update the created incident
  	#When the incident is created verify with sysID
  	Then update the incident with the new '<Description>' and '<Short Description>'
  	And verify the updated '<Description>' and '<Short Description>'
  	Examples:
  	|Description|Short Description|
  	|New Carry on Issue|Not a good movie|
  	|Sikkandar ka muqqadar|worst movie|

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
