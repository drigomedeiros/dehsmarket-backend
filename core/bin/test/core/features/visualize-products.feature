Feature: Visualize Products

    As a Deh's Market visitor
    I want to visualize the market products
    So then I can buy some

    Scenario: List available products
        Given any visitor
        When they enter in Deh's Market
        Then show all the products that exist 
        And have stock greater than 2 

    Scenario: Filter available products
        Given a list of products being presented
        When a user types {string}
        Then show only products that match {string} 
        And have stock greater than 2 

    Scenario Outline: Sort list of product
        Given a list of products being presented
        When a user sort by <sorter>
        Then present the products sorted by <sorter>


