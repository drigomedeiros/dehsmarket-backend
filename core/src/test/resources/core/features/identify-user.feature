Feature: Identify user
    As a user
    I want to identify myself
    So then a can checkout my products

    Scenario: A user informs a known mail
        Given an user mail
        When it already exists in our database
        Then return the mail

    Scenario: A user informs an unknown mail
        Given an user mail
        When it doesn't exist in our database
        Then store it in our database
        And return the mail