@StackExchange
Feature: StackExchange apis testing
  I want to use this template for my feature file
  
@GetAllBadges
  Scenario Outline: Get all badges
     When I get all badges page <page> pageSize <pageSize> site <site> verify status <status>
   
    Examples: 
      | page | pageSize |    site       |   status  |
      | 1    |     2    | stackoverflow |   200     | 
      | 2    |     4    | stackoverflow |   200     |
      

@GetAllBadgesNegative
  Scenario Outline: Get all badges negative test scenario
     When Negative Test get all badges page <page> pageSize <pageSize> site <site> verify status <status> errror <error_message>
	 #Then I verify response error_message <error_message>  
	   
    Examples: 
      | page | pageSize |    site       |   status  | error_message                 |
      |  1.2 |     2    | stackoverflow |   400     |   page                        |
      | -1.2 |     4    | stackoverflow |   400     |   page                        |
      |  1   |     1.2  | stackoverflow |   400     |   page                        |
      |  1   |    -1.3  | stackoverflow |   400     |   page                        |
      |  1   |     4    |     123       |   400     | No site found for name `123`  |
      |  1   |     4    |      DCP      |   400     | No site found for name `DCP`  |
      
      
      
@GetBadgesName
  Scenario Outline: Get badges Name
     When I get badges name page <page> pageSize <pageSize> site <site> verify status <status>
   
    Examples: 
      | page | pageSize |    site       |   status  |
      | 1    |     2    | stackoverflow |   200     | 
      | 2    |     4    | stackoverflow |   200     |
      

@GetBadgesNameNegative
  Scenario Outline: Get badges Name negative test scenario
     When Negative Test get badges name page <page> pageSize <pageSize> site <site> verify status <status> errror <error_message>
	 #Then I verify response error_message <error_message>  
	   
    Examples: 
      | page | pageSize |    site       |   status  | error_message                 |
      |  1.2 |     2    | stackoverflow |   400     |   page                        |
      | -1.2 |     4    | stackoverflow |   400     |   page                        |
      |  1   |     1.2  | stackoverflow |   400     |   page                        |
      |  1   |    -1.3  | stackoverflow |   400     |   page                        |
      |  1   |     4    |     123       |   400     | No site found for name `123`  |
      |  1   |     4    |      DCP      |   400     | No site found for name `DCP`  |
      
      
@GetBadgesRecipientsById
  Scenario Outline: Get badges Recipients by Id
     Given Get the id 260
     When I get badges recipients by page <page> pageSize <pageSize> site <site> verify status <status>
     
    Examples: 
      | page | pageSize |    site       |   status  |
      | 1    |     2    | stackoverflow |   200     | 
      | 2    |     4    | stackoverflow |   200     |
      

@GetBadgesRecipientsByIdNegative
  Scenario Outline: Get badges Recipients by Id negative test scenario
     Given Get the id 260
     When Negative Test get badges recipients by page <page> pageSize <pageSize> site <site> verify status <status> errror <error_message>
	 	   
    Examples: 
      | page | pageSize |    site       |   status  | error_message                 |
      |  1.2 |     2    | stackoverflow |   400     |   page                        |
      | -1.2 |     4    | stackoverflow |   400     |   page                        |
      |  1   |     1.2  | stackoverflow |   400     |   page                        |
      |  1   |    -1.3  | stackoverflow |   400     |   page                        |
      |  1   |     4    |     123       |   400     | No site found for name `123`  |
      |  1   |     4    |      DCP      |   400     | No site found for name `DCP`  |
      