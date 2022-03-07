# JanusGraph with Apache Cassandra and Elasticsearch

Clone the repo or download the zipped folder

Open the path in terminal or in VS Code

Run docker-compose up -d

In the same terminal (or if you didn't provide the -d, in another terminal) run docker exec -it jce-janusgraph bin/gremlin.sh

Into the gremlin console type the following 2 commands>
graph = TinkerGraph.open()
g = graph.traversal()

Now load the graph into the gremlin server by running graph.io(graphml()).readGraph('/opt/janusgraph/mydata/air-routes.graphml')

To check the loaded graph run graph into gremlin console. Expected output: tinkergraph[vertices:3619 edges:50148]

Now you're ready to traverse the graph


