Feature: Visualize Products

    As a Deh's Market visitor
    I want to visualize the market products
    So then I can buy some

    Background: My product list
        Given my product list is
            | name      | price |
            | Product 1 | 30    |
            | Product 2 | 27.5  |
            | Product 3 | 25    |

    Scenario: List available products
        Given any visitor
        When they enter in Deh's Market
        Then the products are presented

    Scenario Outline: Filter available products
        When a user types a filter "<filter>"
        Then only <quantity> products that match the filter are presented

        Examples:
            | filter    | quantity |
            |           | 3        |
            | Product 1 | 1        |
            | Product 5 | 0        |

    Scenario Outline: Sort list of products
        When a user sort by "<sorter>"
        Then products are presented sorted by the user option

        Examples:
            | sorter  |
            | price   |
            | name    |
            | default |


