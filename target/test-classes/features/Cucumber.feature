Feature: API Testing Cucumber Framework End2End

  @createIssue
  Scenario Outline: Verifying Jira Post issue
    Given Add the jira create Api Payload "<summary>" and "<description>"
    When User should call the "createIssueApi" with "Post" request
    Then User should verify whether the response code is 201

    Examples: 
      | summary                  | description                                |
      | User textbox not working | User textbox not working in the login page |

  @UpdateIssue
  Scenario Outline: Verifying Jira Put issue
    Given Add the jira update Api Payload "<summary>","<description>" 
    When User should call the "updateIssueApi" with "Put" request
    Then User should verify whether the response code is 204

    Examples: 
      | summary                   | description                                 |
      | User textbox not working1 | User textbox not working in the login page1 | 

  @getAllIssue
  Scenario: Verifying Jira Get issue
    Given Add the jira baseUri
    When User should call the "getAllIssueApi" with "Get" request
    Then User should verify whether the response code is 200

  @DeleteIssue
  Scenario: Verifying Jira Delete issue
    Given Add the jira delete Api Payload  
    When User should call the "deleteIssueApi" with "Delete" request
    Then User should verify whether the response code is 204

   
