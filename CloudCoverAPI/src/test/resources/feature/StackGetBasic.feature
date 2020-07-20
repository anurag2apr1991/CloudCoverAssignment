@StackGetBasic
Feature: Testing different requests on the StackExchange application

@SMOKE
Scenario: Check if the details can be accessed by badge id
When GET badges by badge id 3028 response status code 200


@GetApi
Scenario: Simple get badge request by badge id
When Get badge by 3028



