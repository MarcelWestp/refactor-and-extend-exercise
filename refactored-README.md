- As Todd I want to see a full inventory of vehicles the company owns so I can see if my car is already listed.

I -2
N +2
V -1
E +1
S +1
T +2
----
  +3

BUT ->  We could implement an full inventory of vehicles the company owns to buy new vehicles


<!--
E  2
S  +
U  -
C  -
----
  +4 -->
----------------------------------------------------------------------------------------------------------------------------------------

- As Todd I want to see a history of the cars I have submitted to the form so that I don't submit a vehicle a second time.

I -1
N +2
V -1
E  0
S +1
T +2
----
  +2

<!--
E  2
S  +
U  +
C  -
----
  +8 -->

BUT -> We could implement an inventory of your submitted vehicles.
----------------------------------------------------------------------------------------------------------------------------------------

- As Laura I want to be able to create new model and year acceptance rules through the website so that I can accept more types of vehicles.

I +2
N +2
V +2
E  0
S  0
T +2
----
  +8

Prio: 1

GIVEN there is an acceptance rule list AND a new valid acceptance rule is provided
WHEN the new acceptance rule is submitted
THEN the acceptance rule list should contain the new rule.

GIVEN there is an acceptance rule list AND a new invalid acceptance rule is provided
WHEN the new acceptance rule is submitted
THEN the new rule will be rejected and a message will be displayed which tells what went wrong

New Story after acceptance rule split:
- As Laura I want to see a message after submitting an invalid acceptance rule So that i can see what went wrong

E  2
S  +
U  +
C  -
----
  +8   
----------------------------------------------------------------------------------------------------------------------------------------
  
- As Laura I want to see the value of each vehicle in my inventory so I can price the vehicles on my lot.

I -2
N +2
V +2
E -2
S -2
T -1
----
  -3

<!-- 
E  2
S  +
U  +
C  +
----
  +16 -->
   
First of all we need to talk how we estimate the value of the vehicle. 
----------------------------------------------------------------------------------------------------------------------------------------

- As Mary I want to see a message that tells me why a car is not valid so that I know why my submission is being rejected.

I -2
N +2
V +2
E +1
S +1
T +2
----
  +6

Prio 2

GIVEN a vehicle of the wrong model is submitted
WHEN the result page is shown
THEN a message will appear on the screen telling the user an incorrect model was submitted

GIVEN a vehicle of the wrong year is submitted
WHEN the result page is shown
THEN a message will appear on the screen telling the user an incorrect year was submitted

GIVEN a vehicle of the wrong make is submitted
WHEN the result page is shown
THEN a message will appear on the screen telling the user an incorrect make was submitted

Resolving Unknown:
- as a Team we want to define what kind of message will be sent so that we can complete the "submission rejected" story

E  2
S  +
U  +
C  -
----
  +8  
----------------------------------------------------------------------------------------------------------------------------------------

- As Todd I want to be able to see information about the company I am submitting the car information to so that I know it is a legitimate business.

I  0
N +2
V +2
E -1
S  0
T  0
----
  +3

E  2
S  +
U  +
C  +
----
  +16  


But we can show him the about us page. And talk about the clarification of the business information later.
----------------------------------------------------------------------------------------------------------------------------------------

- As Todd I want to be able to send the business owner a message so that I can ask a follow up question if my car is accepted or rejected.

I  0
N +1
V +2
E  0
S  0
T +1
----
  +4

<!--
E  2
S  +
U  -
C  -
----
  +4 -->

But we can show him the contact details from the business owner.
----------------------------------------------------------------------------------------------------------------------------------------

- As Mary I want to be able to access the website from my phone so I can submit a vehicle while I'm away from home.

I +2
N +1
V +1
E  0
S +1
T  0
----
  +5

Prio 3

GIVEN there is a working website
WHEN I connect to it using my phone
THEN the website loads and works as intended

GIVEN there is a working website
WHEN I connect to it using a not supported device
THEN the website loads like on a computer

E  2
S  -
U  -
C  -
----
  +2

----------------------------------------------------------------------------------------------------------------------------------------

- As Mary I want my choices of vehicle makes, models, and years to be automatically populated so that I can easily pick my vehicle.

I -2
N +1
V +2
E +1
S +1
T +2
----
  +5

Prio 2

GIVEN I have an empty form
WHEN I fill out the form
THEN The form will suggest fitting makes/models/years

GIVEN I have an empty form
WHEN I fill out the form with an invlid argument
THEN The form will highlight the invalid argument

As Mary if I use an invalid argument inside the submission form,
I want the invalid argument to be highlighted so that I can see which argument

E  2
S  +
U  +
C  -
----
  +8     

----------------------------------------------------------------------------------------------------------------------------------------

- As Laura I want to be able to accept specific models of vehicles along with their year and make so that I can accept a wider range of vehicles.

I -2
N +2
V +2
E +2
S +2
T +2
----
  +8

Prio 2

GIVEN there is an acceptance rule list of accepted vehicles
WHEN a new acceptance rule with a model and year is submitted
THEN the acceptance rule list should contain the new rule.

GIVEN there is an acceptance rule list of accepted vehicles
WHEN a new acceptance rule with an invalid model or year is submitted
THEN an error message should be displayed and the acceptance rule list should not contain the new rule 

E  2
S  +
U  -
C  -
----
  +4    

----------------------------------------------------------------------------------------------------------------------------------------
 
- As Laura I want to be able to know the colors of the vehicles being submitted to the form so that I can make better decisions about my inventory.

I  0
N +2
V +2
E +1
S +2
T +2
----
  +9

Prio 2

GIVEN I have a form to submit a vehicle
WHEN I choose a color in the submit form and submit a valid vehicle
THEN the color should be stored along with the submitted vehicle

GIVEN I have a form to submit a vehicle
WHEN I choose a color in the submit form and submit an invalid vehicle
THEN the vehicle and the chosen color should not be stored

E  2
S  +
U  -
C  -
----
  +4  

----------------------------------------------------------------------------------------------------------------------------------------

- As Laura I want to be able to remove acceptance rules so that I can stop accepting vehicles that are already in my inventory.

I -2
N +2
V +2
E +2
S +2
T +2
----
  +8

Prio 2

GIVEN there is an acceptance rule list
WHEN I select an acceptance rule and press the remove button
THEN the acceptance rule list shouldn't contain the removed rule anymore

GIVEN there is an acceptance rule list
WHEN press the remove button without selecting a rule
THEN an error message gets thrown

E  2
S  +
U  -
C  -
----
  +4  

----------------------------------------------------------------------------------------------------------------------------------------

- As Laura I want to be able to see a list of email addresses of customers who use the website so that I can send them a newsletter.

I -1
N +1
V  0
E  0
S +1
T +2
----
  +3
  
<!-- 
E  2
S  +
U  -
C  -
----
  +4 -->

But -> We can allow the customer to sign up to the newsletter page, which will automatically be sent. 

----------------------------------------------------------------------------------------------------------------------------------------

- As Laura I want to be able to see a picture of the vehicle submitted by the customer so that I can manually reject a vehicle if it has damage.

I -1
N +1
V +2
E  0
S -2
T +2
----
  +2

<!-- 
E  2
S  +
U  -
C  +
----
  +8 -->

But -> We can allowed laura to manually reject cars after the vehicle is already submitted.