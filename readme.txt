http://localhost:8080/health – Shows application health information (a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated). It is sensitive by default.
http://localhost:8080/info – Displays arbitrary application info. Not sensitive by default.
http://localhost:8080/metrics – Shows ‘metrics’ information for the current application. It is also sensitive by default.
http://localhost:8080/trace – Displays trace information (by default the last few HTTP requests).



curl http://localhost:8080/user/list
curl http://localhost:8080/user/narinder
curl -XPUT -d  http://localhost:8080/user          {"id":1,"username":"narinder","email":"narinders.chana@gmail.com"}
curl -XDELETE http://localhost:8080/user/narinder
