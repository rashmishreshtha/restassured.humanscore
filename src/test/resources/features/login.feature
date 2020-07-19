Feature: Humanscore login 

Scenario: login to humanscore
Given login information is provided
 |user|password|
 |rashmi.shreshtha@gmail.com|pAssword1|
 |punu@gmail.com|pAssword1|
When post is performed to create auth
Then auth is created



