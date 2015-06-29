PDF Creator project - fetches data from the db and creates pdf from that data

-- I have made this project more generic it can now create any type of document example - pdf, xls, html we can add any more types supported by jasper report
-- The project is also generic to add any kind of report templates example it can create report of a product table. If there is a need to create Orders table report we can just create order template class and we are ready to go. There is clear separation of concerns and single responsiblity principles

--  For the client to be able to add behaviour dynamically, I have used Strategy Pattern and Open Closed principle of the SOLID design principles

To build the project use the below maven command
mvn clean install

to run the project
java -jar target/PdfCreator-1.0-SNAPSHOT-jar-with-dependencies.jar 
