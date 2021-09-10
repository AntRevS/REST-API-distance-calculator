# REST-API-distance-calculator  
Api for calculating the distance between cities  
  
## Usage  
- yourhost:8080 - page for uploading data  
- /api/v1/cities/all - list of all cities  
- /api/v1/cities/calc/{type}/{from city}/{for city} - calculate distance  
  
## Types of calculation  
- crowflight (distance in a straight line)
- matrix (search in the distance matrix (db))
- all (all types)
