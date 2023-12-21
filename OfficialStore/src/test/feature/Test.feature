Feature: Official Store Operations

  @OfficialStore
  Scenario Outline:: Successful filtering
    Given Be in BliBli home page "https://blibli.com/"
    When Should enter "GIFTN" and apply filters
    And Should apply brands "Tako" and "no brand"
