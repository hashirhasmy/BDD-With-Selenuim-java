Feature: As a new user I am going to register to the murkery tours to get their services

  Background: Register to the website
    Given User is on Mercury Home Page --> Register Page

  Scenario Outline: Register to the website
     Given user enter first name as "<first_name>"
     And user enter last name as "<last_name>"
     And user enter phone number as "0776808389"
     And user enter email as "nhashir@codimite.com"
     And user enter user name "hashir"
     And user enter pass as "111222333"
     And user enter confirm pass as "111222333"
     When user submit
     Then Salutation message will display as "Dear Mohamed Hashir,"

     Examples:
    |first_name| |last_name|
    |      thisarani    | |  lk        |
    |  Mohamed        | |   Hashir       |














