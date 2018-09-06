1. https://codereview.stackexchange.com/questions/84812/java-class-that-generates-a-short-url-string-for-an-input-string
2. https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/



Security consideration: 
1. https://www.troyhunt.com/owasp-top-10-for-net-developers-part-4/


#### Approach 

1. Long URL = Generate MD5 of name + username + datetime 
2. Once the URL is returned, admin will have an option to shorten the URL. There is provision to enter the preferred alias, if that alias is not present in the db, create short URL using that or else follow point 3. 
3. Calculate short URL using the base10 approach. Take first 48 characters of long URL and short URL will be of 7 chars. 


(Here, while calculating md5 including timestamp, as there should not be any restriction on generation of the poll by name or by user, whereas the same will not be applicable if it could have been simply shorten URL service. )

https://www.youtube.com/watch?v=fMZMm_0ZhK4&t=728s

https://hackernoon.com/url-shortening-service-in-java-spring-boot-and-redis-d2a0f8848a1d