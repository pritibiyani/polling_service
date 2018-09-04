#### Typically the layers are:
- Controller: Only I/O should live here. HTTP/Thrift/whatever to your domain entities and back.
- Service: The core of your logic.
- Repository/DAO: Database access code. This is where SQL records (or Mongo documents, or whatever) are turned to your domain models and back.
- Gateway: Clients for external web services you use. HTTP/Thrift/whatever to domain models and back.
- All layers except service should be thin.
- But: You can separate your layers as you see fit for your particular application. Do not go out of your way to conform to established three layers.


##### For designing the polling behaviors:
There are multiple ways to model this.
Essentially, the "poll" that you post to your service, one that is returned by the database, and then one that is further manipulated by the service aren't really the same model.
Sure they all represent the same entity "poll", but in its many different phases.
It helps to represent all of these manifestations with separate types.
And then provide methods to turn one type into another, as needed.
So you may have:
```
class PollInput(createdBy: User)
class Poll(id: UUID, createdAt: DateTime, createdBy: User, ...)

```
As for DateTime.now(), there are many approaches with their pros and cons. I suggest doing it in your service, in your code, in your repository/DAO layer. Some leave this to SQL but that approach has its own issues.