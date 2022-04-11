// You can use this file to load the air-routes graph from the Gremlin Console
//
// To execute use the console command ":load load-air-routes-graph.groovy"
//

conf = new BaseConfiguration()
conf.setProperty("gremlin.tinkergraph.vertexIdManager","LONG")
conf.setProperty("gremlin.tinkergraph.edgeIdManager","LONG")
conf.setProperty("gremlin.tinkergraph.vertexPropertyIdManager","LONG")
graph = TinkerGraph.open(conf)

// Change the path below to point to wherever you put the graphml file
graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-1a-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-1b-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-1c-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-1d-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-2a-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-2b-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-2c-nuboj-dev.json')
// graph.io(graphson()).readGraph('/opt/janusgraph/mydata/part-2d-nuboj-dev.json')

g=graph.traversal()