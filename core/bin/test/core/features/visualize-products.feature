Feature: Visualize Products

    As a Deh's Market visitor
    I want to visualize the market products
    So then I can buy some

    Scenario: List available products
        Given any visitor
        When they enter in Deh's Market
        Then the products are presented

    Scenario: Filter available products
        Given a list of products being presented
        When a user types a filter "ang"
        Then only products that match the filter are presented

    Scenario Outline: Sort list of products
        Given a list of products being presented
        When a user sort by "<sorter>"
        Then products are presented sorted by the user option

        Examples:
            | sorter |
            | price  |


