# CashMachine
## Launch Instructions
In order to run the application, you need to download the entire project to your computer. Next, open the project in the development environment and run it. While the launch is in progress, migrations are automatically performed, a database is created and filled with some necessary data.
As soon as the line *"Started CashmachineApplication in 22.221 seconds (JVM running for 28.512)"*. This means the application has been successfully launched. Next, follow the link: "http://localhost:8080/login". And enter the card details (1000000000000006) and pin code (1234).
## App Navigation
- http://localhost:8080/operations - operations page
- http://localhost:8080/{cardId}/balance - balance view page
- http://localhost:8080/{cardId}/withdrawal - withdrawal page
## My Comments
In one day I made a complete back. I thought, well, let's get down to the front and make it at least an hour. How wrong I was... I spent 2 days on almost nothing. I had rest controllers and I didn't think that they could not work with thymeleaf and jsp. And when I thought that I would have to hand over only the back. I came across another solution, where I already decided to remake from rest controllers to regular controllers. And about a miracle! Everything worked. I didn't fulfill all the requirements of the "customer", but I think that I did a lot. And I did everything possible to get into your company. And thank you for this task! It made me brainstorm!
