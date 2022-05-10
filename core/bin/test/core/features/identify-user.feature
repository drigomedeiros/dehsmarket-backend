Feature: Identify user
    As a user
    I want to identify myself
    So then a can checkout my products

    Scenario Outline: A user informs a mailto proceed to checkout
        Given an user informing a "<mail>"
        When they try to get authorized
        Then their ability to checkout will be "<result>"

        Examples:
            | mail                         | result |
            | an_existing_mail@gmail.com   | true   |
            | an_invalid_mail@smt          | false  |
            | other_invalid_mail           | false  |
            | an_unexisting_mail@yahoo.com | true   |
