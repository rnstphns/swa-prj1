Ryan Stephens (112274), Nora Chaynane, Antonyo Michael, Tsinat Mehari \
September 2022 \
MIU ComPro CS590 Software Architecture course

Public repo at: https://github.com/rnstphns/swa-prj1 

## Steps to run the application:
>*If jar file is not present in target directory,* \
*run `mvn clean package` in main directory* 


run `docker compose up` in main directory
connect to database with mysql workbench using `localhost:3307` and password below \
go to http://localhost:8081/load in browser \
check database in mysql; students should be populated

## MYSQL container config:
port `3307` \
root password: `password`

## API Endpoint:
localhost:8081/load

## API Authentication/Authorization details:
One User 'admin' created with Spring Security ADMIN privileges \
username: admin \
password: adminpassword 



