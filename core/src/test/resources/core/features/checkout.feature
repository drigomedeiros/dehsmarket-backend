Feature: Checkout to payment

    As an identified user
    I want to indicate the products to buy
    So then I can pay for it 

    Scenario: Ordering payment
        Given the user has a bag of products 
        And the user is identified
        When they finish the order 
        Then send to the user a mail with the invoice 

    Scenario: Unidentified user 
        Given an unidentified user
        When they try to checkout 
        Then ask user to identify themselves
