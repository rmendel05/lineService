# lineService

##How does your system work? (if not addressed in comments in source)
Each time a request is made for a specific line, the line is read from the file and stored in memory for faster access if requested again in the future.

##How will your system perform with a 1 GB file? a 10 GB file? a 100 GB file?
1GB - Initial requests for specific lines will require an amount of time that is roughly proportional to the line number requested.
Subsequent requests for lines previously requested will complete in constant time, since a hash is used to access these lines stored in memory.
10GB - Requests for higher line numbers in a 10GB file will require more time to read the file for each request and thus take significantly longer than a 1GB file.
As more lines are cached in memory, the Java program memory limit could be exceeded causing abnormal termination.  
Otherwise, if the OS cannot provide enough physical RAM, program memory will likely be store on disk causing slower retrieval of lines already fetched from the input file.
100GB - Similar to 10GB.  Initial lookup of high line numbers in the file will take proportionally more time.  
Disk caching of RAM will continue to slow subsequent line requests.

##How will your system perform with 100 users? 10000 users? 1000000 users?
Did not have time to test performance.  This appears to barely work for 100 users.  However, this will likely not work well for 10000 or 1000000 users unless the commonly requested lines can be cached in memory without maxxing out available RAM.

##What documentation, websites, papers, etc did you consult in doing this assignment?
none

##What third-party libraries or other tools does the system use? How did you choose each library or framework you used?
Jetty for a quick and dirty open source web server

##How long did you spend on this exercise? If you had unlimited more time to spend on this, how would you spend it and how would you prioritize each item?
3.5 hours
Focus more on appropriate performance strategies for different data set sizes and user load.
Consider alternative strategies for caching data for faster retrieval.

##If you were to critique your code, what would you have to say about it?
Add logging and unit tests.
Replace file store with an indexed database system.
Use an enterprise web server such as Apache to efficiently handle user request load.
More management of multiple file read requests - possibly using a single separate thread to respond to a queue of user requests.
