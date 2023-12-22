Feature: Official Store Operations

  @OfficialStore
  Scenario: Successful filtering
    Given Be in BliBli home page "https://blibli.com/"
    When Should enter "GIFTN" and apply filters
    Then shows the out of stock product list
    When Should enter brands "Tako" and "no brand" and apply filters
    Then show brand selected products
    When Should apply "Termurah" filter
    Then show the assertion result of last 2 pages
