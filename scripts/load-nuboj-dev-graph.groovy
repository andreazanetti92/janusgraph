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
graph.io(graphson()).readGraph('/opt/janusgraph/mydata/nuboj_dev_things_db_2022_03_11.json')

g=graph.traversal()
:set max-iteration 1000