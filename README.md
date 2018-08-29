## Polling Service

[![Build Status](https://api.travis-ci.com/pritibiyani/polling_service.svg?branch=master
)](https://travis-ci.com/pritibiyani/polling_service)

## Customer Feedback System

### MVP
-------------------

#### Feature 1:
 ##### Create a Survey (Survey NAME) -- BY ADMIN

 - Ability to add multiple questions (max 25)
 - All questions only of type score 1-5. (1: Bad   5:Excellent)
 ..- Short Name (Service)
 ..- Description: Text to show (How was our service)
  
##### Fill a survey (By ANONYMOUS)
  - A link for entering survey (which is linked to above poll)
  - Enter customer name + email id + enter answers. + capture date+time


 ##### REPORT PAGE / Show Report Link next to Surveys
  - For each question --- show a graph by date -- average score (line graph)
     (some d3.js library)

##### Feature 2:

 EMAIL a Survery and fill it from anywhere (anonymous)
	- Email a survey request (to a list of people)
	- Any one can click on it only ONCE. (single submission)
	- Link Expiry
	- On submission (send thank you email)


##### Feature 3:

 Export Survey results in PDF
    - Show report in PDF (so that it can be emailed)



