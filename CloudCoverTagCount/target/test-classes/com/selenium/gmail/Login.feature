#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login
Feature: StackOverflow 
  I want to use this template for my feature file

  
@Login
  Scenario Outline: Stackoverflow test scenario
    Given I open <Browser>
    And I go to stackOverflow
    When List of tags tagLinkBase_xpath loc 3 rd tag tagLink_xpath click
    Then Count the total no of questions newest_count_xpath
        
    Examples: 
      |Browser |   Result     |     
      |Mozilla |   success    |
      |Chrome  |   success    |
  
  