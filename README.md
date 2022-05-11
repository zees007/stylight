# stylight

How to run the project:

checkout the code from master branch
Run Maven cmd - mvn clean
Run the main project


Tect Stack used: spring boot, Hibernate/Jpa, Rest Api, In Memory H2 db

Rest Endpoints:

I've created two rest endpoints as below:

1. http://localhost:8080/getAllPrettyUrls

It will recieve the list of parameterized urls as below:

Request:

[
    "/products",
"/products?gender=female",
"/products?tag=5678",
"/products?tag=123&tag1234",
"/products?brand=123",
"/products?tag=123&tag=12345&Brand=657"
]

Response:

{
    "/products?brand=123": "/Adidas/",
    "/products?tag=123&tag=12345&Brand=657": "/Fashion/?tag=123&tag=12345&Brand=657",
    "/products?gender=female": "/Women/",
    "/products?tag=5678": "/Boat-shoes/",
    "/products?tag=123&tag1234": "/Women/Shoes/",
    "/products": "/Fashion/"
}

Response will return with parameterized urls as key and corresponding pretty urls as value.


2. http://localhost:8080/getAllParameterizedUrls

It will recieve the list of pretty urls as below:

Request:

[
    "/Boat-shoes/", 
    "/Fashion/", 
    "/Women/", 
    "/Women/Shoes?tag123", 
    "Male/tShirt"
]

Response :

Response will come with pretty urls as key and corresponding parameterized urls as value.

{
    "/Boat-shoes/": "/products?tag=5678",
    "/Fashion/": "/products",
    "/Women/Shoes?tag123": "/products?gender=femaleShoes?tag123",
    "Male/tShirt": "Male/tShirt",
    "/Women/": "/products?gender=female"
}

Both rest api are having birectional lookup. While mapping the urls if exact match didn't get, I covered the biggest part of the URL from left to right as shown in response.


For such kind of big urls mapping stoage, i will prefer to use Datalake or job feed of every 6 hrs interval which sync with user cache.
If any new url configured or updated in datalake. we should update the caching data of user spontaniously.
By this way, we will first check the cache for requested url. if found we will return the same from cache. If not, will check the datalake.




