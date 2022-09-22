Feature: MottMac - Career Search Page 

  @Regression @Search
  Scenario Outline: Verify Search and View features in Career Search page
    Given user opens career search page   
    When user searches for "<Job_Title>"  
    Then search result has "<Job_Title>" 
    And verify the job details for "<Job_Title>" can be viewed


	Examples:
	|Job_Title             |
	|Java Developer        |


