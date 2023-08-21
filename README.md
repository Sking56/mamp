### Amp Map
An interactive map of EV chargers in the US.

### Project Description
An android app utilizing Google Maps SDK to and data from NREL (National 
Renewable Energy Laboratory) to display EV charging stations in the US.


### Database
Currently planned to be backed using AWS RDS for MySQL. The database will 
utilize AWS Lambda to update the database with new data from NREL. REST API 
will be used to access the database from the app.