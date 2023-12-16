# Transportation System API

This repository contains the source code for a Transportation System API implemented in Java using the Spring Boot framework. The API provides endpoints for managing buses and their routes.


## Prerequisites

* Java 17
* Maven
* Spring Boot- 3.2



## Getting Started
1. Clone the repository:
   git clone https://github.com/BSSowmya/Case_Study.git
	 cd transport
2. Create a database "transportdb" on PostgreSQL
3. Build the project using Maven:
   mvn clean install

4. Run the application:
   mvn spring-boot:run

5.  Run the below Query in DB to create a procedure and insert routes into table
   
  - `CREATE OR REPLACE FUNCTION public.get_route_wise_bus_details(
    inputrouteid integer
) RETURNS TABLE (
    busid BIGINT,
    regnumber VARCHAR,
    starttime TIME,
    endtime TIME
) LANGUAGE 'plpgsql'
AS $$
BEGIN
    RETURN QUERY
    SELECT
        b.bus_id,
        b.reg_no,
        bs.start_time,
        bs.end_time
    FROM
        buses b
    LEFT JOIN
        bus_schedules bs ON b.bus_id = bs.bus_id
    WHERE
        b.route_id = get_route_wise_bus_details.inputrouteid;
END;
$$;`


- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-1','BANGALORE','HASSAN');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-2','BANGALORE','MADEKERI');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-3','BANGALORE','CHIKKAMAGLURU');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-4','BANGALORE','BIDAR');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-6','BANGALORE','TUMKUR');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-7','BANGALORE','CHITRADURGA');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-8','BANGALORE','DAVENGERE');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-9','BANGALORE','CHENNAI');`
- `INSERT INTO routes (route_name,pickup_point,drop_point)VALUES('Route-10','BANGALORE','TIRICHY');`

* The API will be accessible at http://localhost:8080/api.


## Endpoints
- **Add Bus**
  - `POST /api/admin/bus`
  - Add a new bus to the system.

- **Update Bus**
  - `PUT /api/admin/bus/{id}`
  - Update an existing bus by ID.

- **Delete Bus**
  - `DELETE /api/admin/bus/{id}`
  - Delete a bus by ID.

- **Get Bus by ID**
  - `GET /api/bus/{id}`
  - Retrieve bus details by ID.

- **Get All Buses**
  - `GET /api/bus`
  - Retrieve a list of all buses.

- **Get Bus Details Route-Wise**
  - `GET /api/busdetails?routeId={routeId}`
  - Retrieve bus details for a specific route.

- **Map Bus to Route**
  - `POST /api/admin/busmapping`
  - Map a bus to a specific route.

- **Get All Routes**
  - `GET /api/route`
  - Retrieve a list of all routes.
  - 
- **Add Routes**
  - `POST /api/route`
  - Add a list of routes.

## Authentication Endpoints
- **User Sign In**
  - `POST /api/auth/signin`
  - Password must be minimum 8 characters with atleast one uppercase, lowercase, digit and special character
  -  Authenticate a user with a username and password. Returns a JWT token upon successful authentication.
- **User Sign Up**
    - `POST /api/auth/signup`
		- Register a new user. Requires a unique username and password. Returns a success message upon successful registration.
