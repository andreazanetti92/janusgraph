# Mydata folder

There are 2 graph databases one in graphml and the other in json

## Load GRAPHML graph database   

Aftern launched ***docker-compose up -d***       

Run ***docker exec -it jce-janusgraph bin/gremlin.sh***    

Into the gremlin console run the 2 following commands to connect to the gremlin-server
and run the commands directly into it    

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml session
gremlin> :remote console
```

Finally, run the following commands to launch the graph read the graph
and set GraphTraversalSource to g.

```
gremlin>conf = new BaseConfiguration()
gremlin>conf.setProperty("gremlin.tinkergraph.vertexIdManager","LONG")
gremlin>conf.setProperty("gremlin.tinkergraph.edgeIdManager","LONG")
gremlin>conf.setProperty("gremlin.tinkergraph.vertexPropertyIdManager","LONG")
gremlin>graph = TinkerGraph.open(conf)
==>tinkergraph[vertices:0 edges:0]
gremlin> graph.io(graphml()).readGraph('/opt/janusgraph/mydata/air-routes.graphml')
==>null
gremlin> g = graph.traversal()
==>graphtraversalsource[tinkergraph[vertices:3619 edges:50148], standard]
```
### OR

Aftern launched ***docker-compose up -d***       

Run ***docker exec -it jce-janusgraph bin/gremlin.sh***    

```
gremlin> :load /opt/janusgraph/scripts/load-air-routes-graph.groovy
```

Into the gremlin console run the 2 following commands to connect to the gremlin-server
and run the commands directly into it    

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml session
gremlin> :remote console
```

## Load GRAPHSON graph database
Aftern launched ***docker-compose up -d***       

Run ***docker exec -it jce-janusgraph bin/gremlin.sh***    

Into the gremlin console run the 2 following commands to connect to the gremlin-server
and run the commands directly into it    

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml session
gremlin> :remote console
```

Finally, run the following commands to launch the graph read the graph
and set GraphTraversalSource to g.

```
gremlin>conf = new BaseConfiguration()
gremlin>conf.setProperty("gremlin.tinkergraph.vertexIdManager","LONG")
gremlin>conf.setProperty("gremlin.tinkergraph.edgeIdManager","LONG")
gremlin>conf.setProperty("gremlin.tinkergraph.vertexPropertyIdManager","LONG")
gremlin>graph = TinkerGraph.open(conf)
==>tinkergraph[vertices:0 edges:0]
gremlin> graph.io(graphson()).readGraph('/opt/janusgraph/mydata/nuboj_dev_things_db_2022_03_11.json')
==>null
gremlin> g = graph.traversal()
==>graphtraversalsource[tinkergraph[vertices:3619 edges:50148], standard]
```    
  
    
### OR

Aftern launched ***docker-compose up -d***       

Run ***docker exec -it jce-janusgraph bin/gremlin.sh***    

```
gremlin> :load /opt/janusgraph/scripts/load-nuboj-dev-graph.groovy
```

Into the gremlin console run the 2 following commands to connect to the gremlin-server
and run the commands directly into it:   

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml session
gremlin> :remote console
```