###  Database 

Polling 

|  ID | CreatedBy | PollName   |Created At  | Link|  
| --- | ---       | ---         | --- | --- |

Questions 

|  Polling ID | Question ID | Question  | Question Type |  
| ---         | ---         | ---       | --- | 

1. Save Polling data along with questions in the database. 
2. User should be able to see the questions by hitting link 
3. 


- Repository: responsible for storing poll in database 
- Service layer will call the repository layer. 
- Should  it be event? But no! These are related, like poll and pol questions. 


Things to keep in mind: 
1. Poll question itself could be an image/video 
2. Poll answers could be image/video as well 
3. Given a link one should directly see poll. To provide answer, one has to login. 
    